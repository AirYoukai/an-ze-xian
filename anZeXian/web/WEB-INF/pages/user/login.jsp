<%--
  Created by IntelliJ IDEA.
  User: 24852
  Date: 2021/3/13
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>安责险后台管理系统-登录</title>
    <meta name="keywords" content="Bootstrap"/>
    <meta name="description" content="Bootstrap"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <!-- basic styles -->
    <link href="${pageContext.request.contextPath}/static/assets/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/font-awesome.min.css"/>

    <!--[if IE 7]>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/font-awesome-ie7.min.css" />
    <![endif]-->

    <!-- page specific plugin styles -->

    <!-- fonts -->

    <%--    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300"/>--%>

    <!-- ace styles -->

    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/ace.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/ace-rtl.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/ace-skins.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/datepicker.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/daterangepicker.css"/>


    <!--[if lte IE 8]>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/ace-ie.min.css" />
    <![endif]-->

    <!-- inline styles related to this page -->

    <!-- ace settings handler -->
    <%--    <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/echarts-all-3.js"></script>--%>

    <script src="${pageContext.request.contextPath}/static/assets/js/ace-extra.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/assets/js/html5shiv.js"></script>
    <script src="${pageContext.request.contextPath}/static/assets/js/respond.min.js"></script>

</head>

<body class="login-layout">
<div class="main-container">
    <div class="main-content">
        <div class="row">
            <div class="col-sm-10 col-sm-offset-1">
                <div class="login-container">
                    <div class="center">
                        <h1>
                            <i class="icon-leaf green"></i>
                            <span class="red">安责险</span>
                            <span class="white">后台管理系统</span>
                        </h1>

                    </div>

                    <div class="space-6"></div>

                    <div class="position-relative">
                        <div id="login-box" class="login-box visible widget-box no-border">
                            <div class="widget-body">
                                <div class="widget-main">
                                    <h4 class="header blue lighter bigger">
                                        <i class="icon-coffee green"></i>管理员登录 </h4>

                                    <div class="space-6"></div>

                                    <form>
                                        <fieldset>

                                            <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" class="form-control" placeholder="用户名"
                                                                   name="userName" id="userName"/>
															<i class="icon-user"></i>
														</span>
                                            </label>

                                            <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control" placeholder="密码"
                                                                   name="password" id="password"/>
															<i class="icon-lock"></i>
														</span>
                                            </label>

                                            <div class="space"></div>
                                            <div class="clearfix">
                                                <%--                                                <label class="inline">--%>
                                                <%--                                                    <input type="checkbox" class="ace"/>--%>
                                                <%--                                                    <span class="lbl"> 记住密码</span>--%>
                                                <%--                                                </label>--%>
                                                <button type="button" class="width-35 pull-right btn btn-sm btn-primary"
                                                        id="login">
                                                    <i class="icon-key">登录</i>
                                                    <%--                                                    <a href="${pageContext.request.contextPath}/user/tryLogin?userName=suncaper&age=10">登录</a>--%>
                                                </button>
                                            </div>

                                            <div class="space-4"></div>
                                        </fieldset>
                                    </form>
                                </div><!-- /widget-main -->
                                <div class="toolbar clearfix">
                                    <div>
                                        <a href="#" class="forgot-password-link" id="scanLogin"
                                           data-toggle="modal" data-target="#scanLoginModal"
                                        >
                                            <i class="icon-barcode"></i>
                                            扫码登录
                                        </a>
                                    </div>
                                </div>
                            </div><!-- /widget-body -->
                        </div><!-- /login-box -->
                    </div><!-- /position-relative -->
                </div>
            </div><!-- /.col -->
        </div><!-- /.row -->
        <div class="modal fade" id="scanLoginModal" tabindex="-1" role="dialog" aria-labelledby="scanLoginModalLabel"
             data-backdrop="static" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h1 class="modal-title" id="scanLoginModalLabel">小程序扫码登录</h1>
                    </div>
                    <div class="modal-body">
                        <%--                            <div style="width: 100%;height:100%;">--%>
                        <div class="row">
                            <div class="col-md-12">
                                <h3>请登录小程序后</h3>
                                <h3>点击 个人中心-网页扫码登录</h3>
                                <h3>扫描下方二维码登录系统</h3>
                                <%--                                <h3>登录成功后请点击右方“确认登录”按钮</h3>--%>
                            </div>

                            <div class="col-md-9">
                                <img id="scanLoginQRCode" alt="系统繁忙，请稍后重试">
                            </div>
                            <div class="col-md-3">
                                <%--                                <a href="#" class="btn btn-app btn-success" id="loginSucceed">--%>
                                <%--                                    <i class="icon-check bigger-230"></i>--%>
                                <%--                                    确认登录--%>
                                <%--                                </a>--%>
                                <%--                                <a href="#" class="btn btn-app btn-danger"--%>
                                <%--                                   data-dismiss="modal">--%>
                                <%--                                    <i class="icon-info-sign bigger-230"></i>--%>
                                <%--                                    取消--%>
                                <%--                                </a>--%>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <%--                            <button type="button" class="btn btn-primary" id="submitUpdate">提交更改</button>--%>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal -->
        </div>

    </div>

</div><!-- /.main-container -->

<%--<script type="text/javascript">--%>
<%--    window.jQuery || document.write("<script src='${pageContext.request.contextPath}/static/assets/js/jquery-2.0.3.min.js'>" + "<" + "/script>");--%>
<%--</script>--%>

<%--<!-- <![endif]-->--%>

<%--<!--[if IE]>--%>
<%--<script type="text/javascript">--%>
<%-- window.jQuery || document.write("<script src='${pageContext.request.contextPath}/static/assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");--%>
<%--</script>--%>
<%--<![endif]-->--%>

<%--<script type="text/javascript">--%>
<%--    if ("ontouchend" in document) document.write("<script src='${pageContext.request.contextPath}/static/assets/js/jquery.mobile.custom.min.js'>" + "<" + "/script>");--%>
<%--</script>--%>

<!-- inline scripts related to this page -->

<script type="text/javascript">
    window.jQuery || document.write("<script src='${pageContext.request.contextPath}/static/assets/js/jquery-2.0.3.min.js'>" + "<" + "/script>");
</script>

<script type="text/javascript">
    if ("ontouchend" in document) document.write("<script src='${pageContext.request.contextPath}/static/assets/js/jquery.mobile.custom.min.js'>" + "<" + "/script>");
</script>
<script src="${pageContext.request.contextPath}/static/assets/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/assets/js/typeahead-bs2.min.js"></script>

<!-- page specific plugin scripts -->

<script src="${pageContext.request.contextPath}/static/assets/js/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/static/assets/js/jquery.dataTables.bootstrap.js"></script>

<script src="${pageContext.request.contextPath}/static/assets/js/echarts.min.js"></script>
<script src="${pageContext.request.contextPath}/static/assets/js/jQuery.print.js"></script>

<!-- ace scripts -->

<script src="${pageContext.request.contextPath}/static/assets/js/ace-elements.min.js"></script>
<script src="${pageContext.request.contextPath}/static/assets/js/ace.min.js"></script>
<!-- inline scripts related to this page -->

<!-- 引入相应的date time 文件 -->
<script src="${pageContext.request.contextPath}/static/assets/js/date-time/bootstrap-datepicker.min.js"></script>
<script src="${pageContext.request.contextPath}/static/assets/js/date-time/bootstrap-timepicker.min.js"></script>
<script src="${pageContext.request.contextPath}/static/assets/js/date-time/daterangepicker.min.js"></script>
<script src="${pageContext.request.contextPath}/static/assets/js/date-time/moment.min.js"></script>
<script type="text/javascript">
    function show_box(id) {
        jQuery('.widget-box.visible').removeClass('visible');
        jQuery('#' + id).addClass('visible');
    }
</script>
<script type="text/javascript">
    $(function () {
        let loginCode = "";
        window.setInterval(checkScanLogin, 1000 * 5);

        let items = new Array("~", "`", "!", "@", "#", "$", "%", "^", "&", "*", "{", "}", "[", "]", "(", ")");

        function inputCheck(str) {
            try {
                // alert(str);
                // if(str==""||str==null) throw "不能为空";
                for (var i = 0; i < items.length; i++) {
                    if (str.indexOf(items[i]) >= 0) {
                        throw "含有非法字符";
                        break;
                    }
                }
                // if(isNaN(x)) throw "必须是数字";
                // if(x<5) throw "数字太小";
                // if(x>10) throw "数字太大";
                // else throw "输入正确";
            } catch (err) {
                alert("输入不合法！提示：" + err);
                return false;
            }
            return true;
        }

        function checkScanLogin() {
            $.post("${pageContext.request.contextPath}/user/checkLoginSucceed",
                {},
                function (data, status) {
                    if (data == true) {
                        alert("登录成功！");
                        window.location.href = "${pageContext.request.contextPath}/user/toMyIndex";
                    }
                }
            );
        }

        $(document).on("click", "#login", function () {
            // 动作触发后执行的代码!!
            var userName = $("#userName").val();
            var password = $("#password").val();
            if (inputCheck(userName) && inputCheck(password)) {
                $.get("user/tryLoginWeb?userName=" + userName + "&password=" + password, function (data, status) {
                    if (data == true) {
                        window.location.href = "${pageContext.request.contextPath}/user/toMyIndex";
                    } else
                        alert("用户名或密码错误！");
                });
            }
        });
        $(document).on("click", "#scanLogin", function () {
            $("#scanLoginQRCode").attr("src", "${pageContext.request.contextPath}/user/getLoginQRCode");
        });


    });
</script>
<%--<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>--%>
</body>
</html>
