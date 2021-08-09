package com.anzexian.demo.controller;

import com.anzexian.demo.entity.InsuranceClaim;
import com.anzexian.demo.entity.InsuranceWxpay;
import com.anzexian.demo.entity.UserManage;
import com.anzexian.demo.service.InsuranceClaimService;
import com.anzexian.demo.service.InsuranceOrderService;
import com.anzexian.demo.service.InsuranceWxpayService;
import com.anzexian.demo.service.UserManageService;
import com.anzexian.demo.util.MyFileUtils;
import com.anzexian.demo.util.wxPaySDKTencent.MyConfig;
import com.anzexian.demo.util.wxPaySDKTencent.WXPay;
import com.anzexian.demo.util.wxPaySDKTencent.WXPayExample;
import com.anzexian.demo.util.wxPaySDKTencent.WXPayUtil;
import com.github.pagehelper.PageInfo;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.*;

import static com.anzexian.demo.util.Constant.*;
import static com.anzexian.demo.util.QRCodeUtil.encode;

@Controller
@RequestMapping("/insuranceClaim")
public class InsuranceClaimController {
    @Autowired
    InsuranceClaimService insuranceClaimService;
    @Autowired
    UserManageService userManageService;
    @Autowired
    InsuranceOrderService insuranceOrderService;
    @Autowired
    InsuranceWxpayService insuranceWxpayService;

    @RequestMapping("/paySucceed")
    public String paySucceed() {
        return "insurance/paySucceed";
    }

    @RequestMapping("/toClaimBusiness")
    public String toClaimBusiness(HttpServletRequest httpServletRequest) {
        UserManage curUser = new UserManage();
        HttpSession session = httpServletRequest.getSession(true);
        if (session.getAttribute("curUser") != null){
            curUser = (UserManage) session.getAttribute("curUser");
            if (curUser.getUserRole() == 0 || curUser.getUserRole() == 1)//员工或老板才有资格去处理理赔业务
                return "insurance/claim_business";
            else
                return "common/role_exception";
        }
        return "common/logout";
    }

    @RequestMapping("/selectByOpenId")
    @ResponseBody
    public List<InsuranceClaim> selectByOpenId(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("===========selectByOpenId in insuranceClaim entered!=============");
        response.setContentType("text/html;charset=utf-8");
        /*设置响应头允许ajax跨域访问*/
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        //获取微信小程序get的参数值并打印
        String openId = request.getParameter("openId");
        List<InsuranceClaim> insuranceClaimList = new ArrayList<>();
        try {
            UserManage userManage = new UserManage();
            userManage = userManageService.selectByUserName(openId);
            insuranceClaimList = insuranceClaimService.selectByClaimantId(userManage.getId());//理赔人的ID
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
//        return insuranceClaimService.selectById(id);
        return insuranceClaimList;
    }


    @RequestMapping("/payBackSucceed")
    @ResponseBody
    public Boolean notify(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(true);
        InsuranceWxpay curWxpay = (InsuranceWxpay) session.getAttribute("curWxpay");
        UserManage curUser = (UserManage) session.getAttribute("curUser");
        Map<String, String> tmpQuery = new HashMap<>();
        Boolean flag = false;
        try {
            tmpQuery = WXPayExample.queryOrder(curWxpay.getOutTradeNo());
            System.out.println(tmpQuery);
            if ("支付成功".equals(tmpQuery.get("trade_state_desc"))) {
                curWxpay.setPaySucceed(true);//当且仅当支付成功后才可以设置为支付成功
                curWxpay.setPayTime(LocalDateTime.now());
                insuranceWxpayService.updateById(curWxpay);
                String body = curWxpay.getBody();
                InsuranceClaim insuranceClaim = new InsuranceClaim();
                try {
                    String claimId = body.substring(body.lastIndexOf("号") + 1);
                    insuranceClaim = insuranceClaimService.selectById(claimId);//不应该用orderId而是用claim id
                    insuranceClaim.setStatusStaff("PAYEDBACK");
                    insuranceClaim.setWxpayId(curWxpay.getId());
                    insuranceClaim.setCurPos(3);
                    insuranceClaim.setPaybackTime(LocalDateTime.now());
                    insuranceClaim.setPayerId(curUser.getId());
                    insuranceClaimService.updateById(insuranceClaim);
                    flag = true;
                } catch (NullPointerException e) {
                    e.printStackTrace();
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @RequestMapping(value = {"/payback"}, method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @CrossOrigin(origins = "*")
    public void payback(HttpServletRequest httpServletRequest,
                        HttpServletResponse httpServletResponse,
                        @RequestParam(value = "claimId", required = false) String claimId
    ) throws Exception {
        HttpSession session = httpServletRequest.getSession(true);//后面将获取session
        WXPay wxpay = new WXPay(new MyConfig());
        String out_trade_no = WXPayUtil.generateNonceStr();
        InsuranceClaim curClaim = insuranceClaimService.selectById(claimId);//获取页面上的这个理赔对象
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("body", "赔偿-理赔编号" + claimId);
        data.put("out_trade_no", out_trade_no);
        data.put("device_info", "");
        data.put("fee_type", "CNY");
        data.put("total_fee", String.valueOf(curClaim.getInsuranceOrder().getInsuranceService().getServicePremium()));//保金
        //获取客户端的ip地址
        //获取本机的ip地址
        InetAddress addr = null;
        try {
            addr = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String spbill_create_ip = addr.getHostAddress();
        data.put("spbill_create_ip", spbill_create_ip);
        data.put("notify_url", "https://www.ylxteach.net/anZeXian/");
//        data.put("notify_url", "https://www.ylxteach.net/anZeXian/insuranceClaim/paySucceed");
        data.put("trade_type", "NATIVE");  // 此处指定为扫码支付
        data.put("product_id", "12");
        String url = "";
        try {
            Map<String, String> resp = wxpay.unifiedOrder(data);
            System.out.println(resp);
            url = resp.get("code_url");
            System.out.println("code_url=" + url);
            encode(resp.get("code_url"), httpServletResponse);//这一句才是把url变成二维码语句
            data.put("nonce_str", resp.get("nonce_str"));
            data.put("appid", resp.get("appid"));
            data.put("mch_id", resp.get("mch_id"));
            data.put("sign", resp.get("sign"));
            data.put("result_code", resp.get("result_code"));
            data.put("return_code", resp.get("return_code"));
            data.put("prepay_id", resp.get("prepay_id"));
            InsuranceWxpay insuranceWxpay = setInsuranceWxpayParamBeforeOrder(new InsuranceWxpay(), data);
            insuranceWxpay.setUnifiedorderTime(LocalDateTime.now());//下单时间
            insuranceWxpay.setCreateTime(LocalDateTime.now());
            insuranceWxpay.setUnifiedorderSucceed(true);
            insuranceWxpayService.insertAtUnifiedorder(insuranceWxpay);
            session.setAttribute("curWxpay", insuranceWxpay);//把即将要支付的单子放进session
        } catch (Exception e) {
            e.printStackTrace();
        }
//        BufferedImage image = QRCodeUtil.createImage(url);
    }

    public InsuranceWxpay setInsuranceWxpayParamBeforeOrder(InsuranceWxpay insuranceWxpay, HashMap<String, String> data) {
        try {
//            data.put("body", "赔偿-订单编号"+orderId);
//            data.put("out_trade_no", out_trade_no);
//            data.put("device_info", "");
//            data.put("fee_type", "CNY");
//            data.put("total_fee", String.valueOf(insuranceOrder.getInsuranceService().getServicePremium()));//保金
//            data.put("spbill_create_ip", spbill_create_ip);
//            data.put("notify_url", "http://www.example.com/wxpay/notify");
//            data.put("trade_type", "NATIVE");  // 此处指定为扫码支付
//            data.put("product_id", "12");
            insuranceWxpay.setAppId(data.get("appid"));
            insuranceWxpay.setMchId(data.get("mch_id"));
            insuranceWxpay.setNonceStr(data.get("nonce_str"));
            insuranceWxpay.setBody(data.get("body"));
            insuranceWxpay.setOutTradeNo(data.get("out_trade_no"));
            insuranceWxpay.setTotalFee(data.get("total_fee"));
            insuranceWxpay.setSpbillCreateIp(data.get("spbill_create_ip"));
            insuranceWxpay.setNotifyUrl(data.get("notify_url"));
            insuranceWxpay.setTradeType(data.get("trade_type"));

            insuranceWxpay.setPaySign(data.get("sign"));
            insuranceWxpay.setResultCode(data.get("result_code"));
            insuranceWxpay.setReturnCode(data.get("return_code"));
            insuranceWxpay.setPrepayId(data.get("prepay_id"));
//            insuranceWxpay.setOpenId(data.get("openid")); 付款后才知道是谁
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return insuranceWxpay;
    }

    @RequestMapping("/selectLike")
    @ResponseBody
    public PageInfo selectLike(
            HttpServletRequest httpServletRequest,
            @RequestParam(value = "pageSize", required = false) String pageSize,
            @RequestParam(value = "pageNum", required = false) String pageNum
    ) {
        InsuranceClaim insuranceClaim = new InsuranceClaim();
        HttpSession session = httpServletRequest.getSession(true);
        UserManage curUser = (UserManage) session.getAttribute("curUser");
        try {
            if (curUser.getUserRole() == 0) {//身为领导
                Integer[] integers = {CUR_POS_MANAGER_REVIEW};
                List<Integer> integerArrayList = Arrays.asList(integers);
                insuranceClaim.setCurPosList(integerArrayList);
            } else {//身为打工人
                Integer[] integers = {CUR_POS_STAFF_REVIEW, CUR_POS_STAFF_PAYBACK};
                List<Integer> integerArrayList = Arrays.asList(integers);
                insuranceClaim.setCurPosList(integerArrayList);
            }
        } catch (NullPointerException e) {
            System.out.println("Null pointer in selectLike in Service controller");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("NumberFormat problem in selectLike in Service controller");
            e.printStackTrace();
        }
        PageInfo res = insuranceClaimService.selectLike(insuranceClaim, pageNum, pageSize);
        return res;
    }

    @RequestMapping("/selectById")
    @ResponseBody
    public InsuranceClaim selectById(@RequestParam(value = "id") String id) {
        return insuranceClaimService.selectById(id);
    }

    @RequestMapping("/updateAjax")
    @ResponseBody
    public Boolean updateAjax(
            HttpServletRequest httpServletRequest,
            @RequestParam(value = "id", required = false) String id,
            @RequestParam(value = "method", required = false) String method,
            @RequestParam(value = "curPos", required = false) String curPos
    ) {
        //判断当前用户
        //curPos变化 前端传
        //status_manager, status_staff
        //review_manager_id, review_staff_id, payer_id session中来
        //review_manager_time, review_staff_time, payback_time 判断method
        HttpSession session = httpServletRequest.getSession(true);

        UserManage curUser = (UserManage) session.getAttribute("curUser");
        InsuranceClaim insuranceClaim = new InsuranceClaim();
        try {
            insuranceClaim.setId(Integer.parseInt(id));
            if (curUser.getUserRole() == 0) {//身为领导
                insuranceClaim.setCurPos(Integer.parseInt(curPos) + 1);
                insuranceClaim.setReviewManagerId(curUser.getId());
                insuranceClaim.setReviewManagerTime(LocalDateTime.now());
                if ("agree".equals(method)) {
                    insuranceClaim.setStatusManager(STATUS_AGREED);
                    insuranceClaim.setCurPos(CUR_POS_STAFF_PAYBACK);//同意后等待员工赔款
                } else if ("deny".equals(method)) {
                    insuranceClaim.setStatusManager(STATUS_DENIED);
                    insuranceClaim.setCurPos(CUR_POS_CLIENT_RES);//拒绝后直接到达用户
                }
            } else {//身为打工人
                if ("agree".equals(method)) {
                    insuranceClaim.setReviewStaffId(curUser.getId());
                    insuranceClaim.setCurPos(CUR_POS_MANAGER_REVIEW);//同意后等待老板审核
                    insuranceClaim.setStatusStaff(STATUS_AGREED);
                    insuranceClaim.setReviewStaffTime(LocalDateTime.now());
                } else if ("deny".equals(method)) {
                    insuranceClaim.setReviewStaffId(curUser.getId());
                    insuranceClaim.setCurPos(CUR_POS_CLIENT_RES);//拒绝后直接到达用户
                    insuranceClaim.setStatusStaff(STATUS_DENIED);
                    insuranceClaim.setReviewStaffTime(LocalDateTime.now());
                } else if ("payBack".equals(method)) {
                    insuranceClaim.setPayerId(curUser.getId());
                    insuranceClaim.setCurPos(CUR_POS_CLIENT_RES);//赔款后到达用户
                    insuranceClaim.setStatusStaff(STATUS_PAYEDBACK);
                    insuranceClaim.setPaybackTime(LocalDateTime.now());
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return insuranceClaimService.updateById(insuranceClaim);
    }

    @RequestMapping("/getProofFile")
    public ResponseEntity<byte[]> exportData(@RequestParam(value = "proofFilePath", required = false) String proofFilePath) {
        return MyFileUtils.downloadFile(proofFilePath, "证明材料.zip");
    }


    @RequestMapping(value = "/tryClaim",
//            produces = "application/json",
            method = RequestMethod.POST)
//@RequestMapping("/tryClaim")
    @ResponseBody
    public Boolean tryClaim(HttpServletRequest request, HttpServletResponse response,
                            @RequestParam(value = "file", required = false) MultipartFile files) {

        System.out.println("==========tryClaim entered!==============");
        response.setContentType("text/html;charset=utf-8");
        /*设置响应头允许ajax跨域访问*/
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        String orderId = request.getParameter("orderId");
        String openId = request.getParameter("openId");

        System.out.println("orderId: " + orderId);
        System.out.println("openId: " + openId);

        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        ServletContext servletContext = webApplicationContext.getServletContext();
        String realPath = servletContext.getRealPath(File.separator);
//        String uploadPath=realPath+"\\WEB-INF\\classes";
        String uploadPath = realPath + "/WEB-INF/classes";
//        String uploadPath = "/opt/temp";//你自己保存的URL;
        // 如果目录不存在就创建
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        // 获取文件的 名称.扩展名
        String oldName = files.getOriginalFilename();
        String extensionName = "";
        // 获取原来的扩展名
        if ((oldName != null) && (oldName.length() > 0)) {
            int dot = oldName.lastIndexOf('.');
            if ((dot > -1) && (dot < (oldName.length() - 1))) {
                extensionName = oldName.substring(dot);
            }
        }
        // 构建文件名称
        String fileName = System.currentTimeMillis() + "_" + "证明材料"
                + extensionName;
        // 构建文件路径
        String proofFilePath = uploadPath + File.separator + fileName;
        proofFilePath = proofFilePath.replace("\\", "/");
        // 保存文件
        Boolean flag = false;
        try {
            FileUtils.writeByteArrayToFile(new File(proofFilePath),
                    files.getBytes());
            System.out.println("接收文件成功 " + proofFilePath);
            InsuranceClaim insuranceClaim = new InsuranceClaim();
            insuranceClaim.setOrderId(Integer.parseInt(orderId));
            insuranceClaim.setProofFilePath(proofFilePath);
            insuranceClaim.setCreateTime(LocalDateTime.now());
            UserManage Claimant = new UserManage();
            Claimant = userManageService.selectByUserName(openId);
            insuranceClaim.setClaimantId(Claimant.getId());
            insuranceClaimService.insert(insuranceClaim);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
