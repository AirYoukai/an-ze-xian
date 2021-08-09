package com.anzexian.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.anzexian.demo.entity.UserLogin;
import com.anzexian.demo.entity.UserManage;
import com.anzexian.demo.service.UserLoginService;
import com.anzexian.demo.service.UserManageService;
import com.anzexian.demo.util.ExportPrintUtils;
import com.anzexian.demo.util.HttpRequest;
import com.anzexian.demo.util.wxPaySDKTencent.WXPayUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.anzexian.demo.util.Constant.APP_ID;
import static com.anzexian.demo.util.Constant.MINIPRO_SECRET_KEY;
import static com.anzexian.demo.util.ExportPrintUtils.getReturnFile;
import static com.anzexian.demo.util.QRCodeUtil.encode;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserManageService userManageService;
    @Autowired
    private UserLoginService userLoginService;

    @RequestMapping("/toMyIndex")
    public String toMyIndex(HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession(true);
        if (session.getAttribute("curUser") != null) {
            UserManage curUser = (UserManage) session.getAttribute("curUser");
            if (curUser.getUserRole() == 0 || curUser.getUserRole() == 1)
                return "insurance/claim_business";
            else
                return "user/user_list";
        }
        return "common/logout";
    }

    @RequestMapping("/toUserMy")
    public String toUserMy(HttpServletRequest httpServletRequest) {
        return "user/user_my";
    }

    @RequestMapping("/gerCurUser")
    @ResponseBody
    public UserManage gerCurUser(HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession(true);
        UserManage curUser = new UserManage();
        if (session.getAttribute("curUser") != null) {
            curUser = (UserManage) session.getAttribute("curUser");
            curUser = userManageService.selectById(curUser.getId() + "");
        }
        return curUser;
    }

    @RequestMapping("/toUserList")
    public String toUserList(HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession(true);
        UserManage curUser = new UserManage();
        if (session.getAttribute("curUser") != null) {
            curUser = (UserManage) session.getAttribute("curUser");
            if (curUser.getUserRole() == -1)
                return "user/user_list";
            else
                return "common/role_exception";
        }
        return "common/logout";
    }

    @RequestMapping("/getAll")
    @ResponseBody
    public PageInfo getAll(
//            @RequestParam(value = "pageSize", required = false) String pageSize,
//            @RequestParam(value = "pageNum", required = false) String pageNum
    ) {
        return userManageService.getALl();
    }

    //分页列表
    @RequestMapping("/selectLike")
    @ResponseBody
    public PageInfo selectLike(
            HttpServletRequest httpServletRequest,
            @RequestParam(value = "pageSize", required = false) String pageSize,
            @RequestParam(value = "pageNum", required = false) String pageNum,
            @RequestParam(value = "userName", required = false) String userName,
            @RequestParam(value = "password", required = false) String password,
            @RequestParam(value = "openId", required = false) String openId,
            @RequestParam(value = "userRole", required = false) String userRole,
            @RequestParam(value = "userRealName", required = false) String userRealName,
            @RequestParam(value = "userAge", required = false) String userAge,
            @RequestParam(value = "userSex", required = false) String userSex,
            @RequestParam(value = "createTimeFrom", required = false) String createTimeFrom,
            @RequestParam(value = "createTimeTo", required = false) String createTimeTo,
            @RequestParam(value = "orderByOne", required = false) String orderByOne,
            @RequestParam(value = "orderByTwo", required = false) String orderByTwo,
            @RequestParam(value = "orderByThree", required = false) String orderByThree
    ) {
        UserManage userManage = setUserManageParam(userName, password, openId, userRole, userRealName,
                userAge, userSex, createTimeFrom, createTimeTo, orderByOne,
                orderByTwo, orderByThree);
        PageInfo res = userManageService.selectLike(userManage, pageNum, pageSize);
        return res;
    }


    @RequestMapping("/exportData")
    public ResponseEntity<byte[]> exportData() throws IOException {
        PageInfo res = userManageService.getALl();
        String[] rowsName = new String[]{"ID", "用户名", "密码", "openId", "权限", "真实姓名", "年龄", "性别", "创建时间", "状态"};
        return getReturnFile(ExportPrintUtils.createUserExcel("用户列表",
                rowsName, res.getList()), "用户列表.xls");
    }


//    ResponseEntity<byte[]>


    //web端登录
    @RequestMapping("/tryLoginWeb")
    @ResponseBody
    public Boolean tryLoginWeb(HttpServletRequest httpServletRequest,
                              @RequestParam(value = "userName", required = false) String userName,
                              @RequestParam(value = "password", required = false) String password) {
        UserManage userManage = new UserManage();
        try {
            userManage.setUserName(userName);
            userManage.setPassword(password);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        userManage = userManageService.loginWeb(userManage);
        if (userManage.getId() != null && userManage.getId() > 0) {
            HttpSession session = httpServletRequest.getSession(true);
            session.setAttribute("curUser", userManage);
            return true ;
        } else return false ;
    }

    @RequestMapping("/selectById")
    @ResponseBody
    public UserManage selectById(@RequestParam(value = "id") String id) {
        return userManageService.selectById(id);
    }

    @RequestMapping("/deleteById")
    @ResponseBody
    public Boolean deleteById(@RequestParam(value = "id") String id) {
        return userManageService.deleteById(id);
    }

    @RequestMapping("/updateAjax")
    @ResponseBody
    public Boolean updateAjax(@RequestParam(value = "id", required = false) String id,
                              @RequestParam(value = "userName", required = false) String userName,
                              @RequestParam(value = "password", required = false) String password,
                              @RequestParam(value = "openId", required = false) String openId,
                              @RequestParam(value = "userRole", required = false) String userRole,
                              @RequestParam(value = "userRealName", required = false) String userRealName,
                              @RequestParam(value = "userAge", required = false) String userAge,
                              @RequestParam(value = "userSex", required = false) String userSex
    ) {
        UserManage userManage = new UserManage();
        try {
            userManage.setId(Integer.parseInt(id));
            userManage.setUserName("".equals(userName) ? null : userName);
            userManage.setPassword("".equals(password) ? null : password);
            userManage.setUserRole(userRole == null || "".equals(userRole) ? null : Integer.parseInt(userRole));
            userManage.setOpenId("".equals(openId) ? null : openId);
            userManage.setCreateTime(LocalDateTime.now());
            userManage.setUserRealName(userRealName);
            userManage.setUserAge(Integer.parseInt(userAge));
            userManage.setUserSex(userSex);
            return userManageService.updateById(userManage);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static UserManage setUserManageParam(
            String userName, String password, String openId, String userRole,
            String userRealName, String userAge, String userSex,
            String createTimeFrom, String createTimeTo,
            String orderByOne, String orderByTwo, String orderByThree) {
        UserManage userManage = new UserManage();
        try {
            userManage.setUserName(userName);
            userManage.setPassword(password);
            if (userRole != null && !"".equals(userRole))
                userManage.setUserRole(Integer.parseInt(userRole));
            userManage.setOpenId(openId);
//            userManage.setCreateTime(LocalDateTime.now());
            userManage.setUserRealName(userRealName);
//            if(userAge!=null)
//                userManage.setUserAge(Integer.parseInt(userAge));
            userManage.setUserSex(userSex);
            if (createTimeFrom != null && !"".equals(createTimeFrom))
                userManage.setCreateTimeFrom(createTimeFrom + " 00:00:00");
            if (createTimeTo != null && !"".equals(createTimeTo))
                userManage.setCreateTimeTo(createTimeTo + " 00:00:00");
            userManage.setOrderByOne(orderByOne);
            userManage.setOrderByTwo(orderByTwo);
            userManage.setOrderByThree(orderByThree);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return userManage;
    }

    @RequestMapping(value = {"/getLoginQRCode"}, method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    @CrossOrigin(origins = "*")//获取的二维码
    public void getLoginQRCode(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        String loginCode = WXPayUtil.generateNonceStr();//登录的标识
        HttpSession session = httpServletRequest.getSession(true);
        session.setAttribute("curLoginCode", loginCode);
        List<String> loginCodeList = new ArrayList<>();
        UserLogin userLogin = new UserLogin();
        userLogin.setLoginCode(loginCode);
        userLogin.setCreateTime(LocalDateTime.now());
        userLoginService.insert(userLogin);//插入数据库
        String codeUrl = "http://" + httpServletRequest.getServerName() + ":" //服务器地址
                + httpServletRequest.getServerPort()//端口号
                + httpServletRequest.getContextPath()      //项目名称
                + httpServletRequest.getServletPath() //请求页面或其他地址
                + "?loginCode=" + loginCode;     //参数
        System.out.println("codeUrl=" + codeUrl);
        encode(codeUrl, httpServletResponse);//这一句才是把url变成二维码语句
//        map.put("loginCode",loginCode);
    }

    @RequestMapping("/checkLoginSucceed")
    @ResponseBody
    public Boolean checkLoginSucceed(HttpServletRequest request, HttpServletResponse response) {
        Boolean flag = false;
        try {
            String curLoginCode = "";
            HttpSession session = request.getSession(true);
            if (session.getAttribute("curLoginCode") != null)
                curLoginCode = session.getAttribute("curLoginCode").toString();
            UserLogin userLogin = userLoginService.getUserLoginByLoginCode(curLoginCode);
            if (userLogin != null) {
                if (userLogin.getScannerId() != null && userLogin.getHaslogin()) {//该码已经被扫了而且登录了
                    UserManage curUser = new UserManage();
                    curUser = userManageService.selectById(userLogin.getScannerId() + "");
                    if (curUser != null) {//设session
                        session.setAttribute("curUser", curUser);
                        flag = true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    ////////////////////////////////////下面全是小程序/////////////////////////////////////////
    //小程序端扫描web二维码登录
    @RequestMapping("/scanLoginWeb")
    @ResponseBody
    public Boolean scanLoginWeb(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        /*设置响应头允许ajax跨域访问*/
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        //获取微信小程序get的参数值并打印
        String openId = request.getParameter("openId");
        String loginCode = request.getParameter("loginCode");
        System.out.println("openId=" + openId + "，loginCode=" + loginCode);
        Boolean flag = false;
        UserLogin userLogin = userLoginService.getUserLoginByLoginCode(loginCode);
        if (userLogin != null) {//如果为空，这码都没有东西，说明没有扫到对的码。登录失败
            userLogin.setIsScanned(true);
            UserManage userManage = new UserManage();
            if (userManageService.tryLogin(openId) != null) {//尝试登录一下
                userManage = userManageService.tryLogin(openId);
                userLogin.setHaslogin(true);
                userLogin.setScannerId(userManage.getId());
                flag = true;
            }
            userLoginService.updateByIdSelective(userLogin);
        }
        return flag;
    }

    @RequestMapping("/signup")
    @ResponseBody
    public Boolean signup(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        /*设置响应头允许ajax跨域访问*/
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        //获取微信小程序get的参数值并打印
        String openId = request.getParameter("openId");
        UserManage userManage = new UserManage();
        userManage.setCreateTime(LocalDateTime.now());
        userManage.setOpenId(openId);
        userManage.setUserName(openId);
        return userManageService.signup(userManage);
    }

    //小程序端的登录
    @RequestMapping("/tryLogin")
    @ResponseBody
    public UserManage tryLogin(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        /*设置响应头允许ajax跨域访问*/
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        //获取微信小程序get的参数值并打印
        String openId = request.getParameter("openId");
        System.out.println("openId" + openId);
        return userManageService.tryLogin(openId);
    }

    @RequestMapping("/getOpenIdAndSessionKey")
    @ResponseBody
    public JSONObject getOpenIdAndSessionKey(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        /*设置响应头允许ajax跨域访问*/
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        //获取微信小程序get的参数值并打印
        String js_code = request.getParameter("js_code");
        System.out.println("js_code=" + js_code);
        String wxspAppid = APP_ID;
        String wxspSecret = MINIPRO_SECRET_KEY;
        String grant_type2 = "authorization_code";
//	    		  1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid
        String params2 = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code=" + js_code + "&grant_type=" + grant_type2;
        // 发送请求
        Map<String, String> map = new HashMap<>();
        String sr2 = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params2);//
        JSONObject json2 = JSONObject.parseObject(sr2);
        System.out.println("json2==" + json2.toJSONString());
        return json2;
    }
}