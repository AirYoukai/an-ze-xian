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
            if (curUser.getUserRole() == 0 || curUser.getUserRole() == 1)//????????????????????????????????????????????????
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
        /*?????????????????????ajax????????????*/
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* ??????????????????????????????????????????????????? */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        //?????????????????????get?????????????????????
        String openId = request.getParameter("openId");
        List<InsuranceClaim> insuranceClaimList = new ArrayList<>();
        try {
            UserManage userManage = new UserManage();
            userManage = userManageService.selectByUserName(openId);
            insuranceClaimList = insuranceClaimService.selectByClaimantId(userManage.getId());//????????????ID
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
            if ("????????????".equals(tmpQuery.get("trade_state_desc"))) {
                curWxpay.setPaySucceed(true);//?????????????????????????????????????????????????????????
                curWxpay.setPayTime(LocalDateTime.now());
                insuranceWxpayService.updateById(curWxpay);
                String body = curWxpay.getBody();
                InsuranceClaim insuranceClaim = new InsuranceClaim();
                try {
                    String claimId = body.substring(body.lastIndexOf("???") + 1);
                    insuranceClaim = insuranceClaimService.selectById(claimId);//????????????orderId?????????claim id
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
        HttpSession session = httpServletRequest.getSession(true);//???????????????session
        WXPay wxpay = new WXPay(new MyConfig());
        String out_trade_no = WXPayUtil.generateNonceStr();
        InsuranceClaim curClaim = insuranceClaimService.selectById(claimId);//????????????????????????????????????
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("body", "??????-????????????" + claimId);
        data.put("out_trade_no", out_trade_no);
        data.put("device_info", "");
        data.put("fee_type", "CNY");
        data.put("total_fee", String.valueOf(curClaim.getInsuranceOrder().getInsuranceService().getServicePremium()));//??????
        //??????????????????ip??????
        //???????????????ip??????
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
        data.put("trade_type", "NATIVE");  // ???????????????????????????
        data.put("product_id", "12");
        String url = "";
        try {
            Map<String, String> resp = wxpay.unifiedOrder(data);
            System.out.println(resp);
            url = resp.get("code_url");
            System.out.println("code_url=" + url);
            encode(resp.get("code_url"), httpServletResponse);//??????????????????url?????????????????????
            data.put("nonce_str", resp.get("nonce_str"));
            data.put("appid", resp.get("appid"));
            data.put("mch_id", resp.get("mch_id"));
            data.put("sign", resp.get("sign"));
            data.put("result_code", resp.get("result_code"));
            data.put("return_code", resp.get("return_code"));
            data.put("prepay_id", resp.get("prepay_id"));
            InsuranceWxpay insuranceWxpay = setInsuranceWxpayParamBeforeOrder(new InsuranceWxpay(), data);
            insuranceWxpay.setUnifiedorderTime(LocalDateTime.now());//????????????
            insuranceWxpay.setCreateTime(LocalDateTime.now());
            insuranceWxpay.setUnifiedorderSucceed(true);
            insuranceWxpayService.insertAtUnifiedorder(insuranceWxpay);
            session.setAttribute("curWxpay", insuranceWxpay);//?????????????????????????????????session
        } catch (Exception e) {
            e.printStackTrace();
        }
//        BufferedImage image = QRCodeUtil.createImage(url);
    }

    public InsuranceWxpay setInsuranceWxpayParamBeforeOrder(InsuranceWxpay insuranceWxpay, HashMap<String, String> data) {
        try {
//            data.put("body", "??????-????????????"+orderId);
//            data.put("out_trade_no", out_trade_no);
//            data.put("device_info", "");
//            data.put("fee_type", "CNY");
//            data.put("total_fee", String.valueOf(insuranceOrder.getInsuranceService().getServicePremium()));//??????
//            data.put("spbill_create_ip", spbill_create_ip);
//            data.put("notify_url", "http://www.example.com/wxpay/notify");
//            data.put("trade_type", "NATIVE");  // ???????????????????????????
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
//            insuranceWxpay.setOpenId(data.get("openid")); ????????????????????????
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
            if (curUser.getUserRole() == 0) {//????????????
                Integer[] integers = {CUR_POS_MANAGER_REVIEW};
                List<Integer> integerArrayList = Arrays.asList(integers);
                insuranceClaim.setCurPosList(integerArrayList);
            } else {//???????????????
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
        //??????????????????
        //curPos?????? ?????????
        //status_manager, status_staff
        //review_manager_id, review_staff_id, payer_id session??????
        //review_manager_time, review_staff_time, payback_time ??????method
        HttpSession session = httpServletRequest.getSession(true);

        UserManage curUser = (UserManage) session.getAttribute("curUser");
        InsuranceClaim insuranceClaim = new InsuranceClaim();
        try {
            insuranceClaim.setId(Integer.parseInt(id));
            if (curUser.getUserRole() == 0) {//????????????
                insuranceClaim.setCurPos(Integer.parseInt(curPos) + 1);
                insuranceClaim.setReviewManagerId(curUser.getId());
                insuranceClaim.setReviewManagerTime(LocalDateTime.now());
                if ("agree".equals(method)) {
                    insuranceClaim.setStatusManager(STATUS_AGREED);
                    insuranceClaim.setCurPos(CUR_POS_STAFF_PAYBACK);//???????????????????????????
                } else if ("deny".equals(method)) {
                    insuranceClaim.setStatusManager(STATUS_DENIED);
                    insuranceClaim.setCurPos(CUR_POS_CLIENT_RES);//???????????????????????????
                }
            } else {//???????????????
                if ("agree".equals(method)) {
                    insuranceClaim.setReviewStaffId(curUser.getId());
                    insuranceClaim.setCurPos(CUR_POS_MANAGER_REVIEW);//???????????????????????????
                    insuranceClaim.setStatusStaff(STATUS_AGREED);
                    insuranceClaim.setReviewStaffTime(LocalDateTime.now());
                } else if ("deny".equals(method)) {
                    insuranceClaim.setReviewStaffId(curUser.getId());
                    insuranceClaim.setCurPos(CUR_POS_CLIENT_RES);//???????????????????????????
                    insuranceClaim.setStatusStaff(STATUS_DENIED);
                    insuranceClaim.setReviewStaffTime(LocalDateTime.now());
                } else if ("payBack".equals(method)) {
                    insuranceClaim.setPayerId(curUser.getId());
                    insuranceClaim.setCurPos(CUR_POS_CLIENT_RES);//?????????????????????
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
        return MyFileUtils.downloadFile(proofFilePath, "????????????.zip");
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
        /*?????????????????????ajax????????????*/
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* ??????????????????????????????????????????????????? */
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
//        String uploadPath = "/opt/temp";//??????????????????URL;
        // ??????????????????????????????
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        // ??????????????? ??????.?????????
        String oldName = files.getOriginalFilename();
        String extensionName = "";
        // ????????????????????????
        if ((oldName != null) && (oldName.length() > 0)) {
            int dot = oldName.lastIndexOf('.');
            if ((dot > -1) && (dot < (oldName.length() - 1))) {
                extensionName = oldName.substring(dot);
            }
        }
        // ??????????????????
        String fileName = System.currentTimeMillis() + "_" + "????????????"
                + extensionName;
        // ??????????????????
        String proofFilePath = uploadPath + File.separator + fileName;
        proofFilePath = proofFilePath.replace("\\", "/");
        // ????????????
        Boolean flag = false;
        try {
            FileUtils.writeByteArrayToFile(new File(proofFilePath),
                    files.getBytes());
            System.out.println("?????????????????? " + proofFilePath);
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
