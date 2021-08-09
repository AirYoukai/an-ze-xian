<%--
  Created by IntelliJ IDEA.
  User: 24852
  Date: 2021/3/13
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人中心</title>
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
<body style="">
<%--<%@ include file="/WEB-INF/pages/common/header.jsp" %>--%>

<div class="main-container">
    <script type="text/javascript">
        try {
            ace.settings.check('main-container', 'fixed')
        } catch (e) {
        }
    </script>
    <div class="main-container-inner">
        <%@ include file="/WEB-INF/pages/common/sidebar.jsp" %>
        <div class="main-content">
            <%--            分页功能--%>
            <div class="page-content">
                <div class="row">
                    <div class="col-md-12">
                        <h3 class="header smaller lighter blue center">个人信息</h3>
                    </div>
                    <div class="col-md-2">
                        <a href="#" class="btn btn-app btn-primary" id="save">
                            <i class="icon-laptop bigger-230"></i>
                            保存
                        </a>
                        <%--                        <a href="#" class="btn btn-app btn-success" id="agree">--%>
                        <%--                            <i class=" icon-check bigger-230"></i>--%>
                        <%--                            通过--%>
                        <%--                        </a>--%>
                        <%--                        <a href="#" class="btn btn-app btn-danger" id="deny">--%>
                        <%--                            <i class="icon-ban-circle bigger-230"></i>--%>
                        <%--                            驳回--%>
                        <%--                        </a>--%>
                    </div>
                    <div class="col-md-10">
                        <div class="profile-user-info profile-user-info-striped" id="user_info">
                            <div class="profile-info-row">
                                <div class="profile-info-name">用户名</div>
                                <div class="profile-info-value">
                                    <input class="input-xxlarge" type="text" id="userName">
                                </div>
                            </div>

                            <div class="profile-info-row">
                                <div class="profile-info-name">用户唯一标识</div>
                                <div class="profile-info-value">
                                    <span class="editable editable-click" id="openId"></span>
                                </div>
                            </div>

                            <div class="profile-info-row">
                                <div class="profile-info-name">密码</div>
                                <div class="profile-info-value">
                                    <input class="input-xxlarge" type="text" id="password">
                                </div>
                            </div>
                            <div class="profile-info-row">
                                <div class="profile-info-name">年龄</div>
                                <div class="profile-info-value">
                                    <input class="input-xxlarge" type="text" id="userAge">
                                </div>
                            </div>
                            <div class="profile-info-row">
                                <div class="profile-info-name">真实姓名</div>
                                <div class="profile-info-value">
                                    <input class="input-xxlarge" type="text" id="userRealName">
                                </div>
                            </div>

                            <div class="profile-info-row">
                                <div class="profile-info-name">性别</div>
                                <div class="profile-info-value">
                                    <select id="userSex" class="form-control">
                                        <option value="">未知</option>
                                        <option value="male">男</option>
                                        <option value="female">女</option>
                                    </select>
                                </div>
                            </div>
                            <div class="profile-info-row">
                                <div class="profile-info-name">用户身份</div>
                                <div class="profile-info-value">
                                    <span class="editable editable-click" id="userRole">
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%--<script type="text/javascript">--%>
<%--    try {--%>
<%--        ace.settings.check('sidebar', 'collapsed')--%>
<%--    } catch (e) {--%>
<%--    }--%>
<%--</script>--%>

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
    jQuery(function ($) {
        var oTable1 = $('#sample-table-2').dataTable({
            "aoColumns": [
                {"bSortable": false},
                null, null, null, null, null,
                {"bSortable": false}
            ]
        });


        $('table th input:checkbox').on('click', function () {
            var that = this;
            $(this).closest('table').find('tr > td:first-child input:checkbox')
                .each(function () {
                    this.checked = that.checked;
                    $(this).closest('tr').toggleClass('selected');
                });

        });


        $('[data-rel="tooltip"]').tooltip({placement: tooltip_placement});

        function tooltip_placement(context, source) {
            var $source = $(source);
            var $parent = $source.closest('table')
            var off1 = $parent.offset();
            var w1 = $parent.width();
            var off2 = $source.offset();
            var w2 = $source.width();
            if (parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2)) return 'right';
            return 'left';
        }
    })
</script>

<script>
    $(function () {
        var id = null;
        var openId = null;
        var userRole = null;
        $.getTableData = function () {
            $.post("${pageContext.request.contextPath}/user/gerCurUser",
                {},
                function (data, status) {
                    console.info(JSON.stringify(data));
                    $.appendInfo(data);//此data就是一个UserManage
                }
            );
        }
        $.appendInfo = function (data) {
            id = data.id;
            openId = data.openId;
            userRole = data.userRole;
            $("#userName").val(data.userName);
            $("#openId").text(data.openId);
            $("#password").val(data.password == null ? "暂无" : data.password);
            $("#userAge").val(data.userAge == null ? "暂无" : data.userAge);
            $("#userRealName").val(data.userRealName == null ? "暂无" : data.userRealName);
            $("#userSex").val(data.userSex == null ? "" : data.userSex);
            let role = "";
            if (data.userRole == -1) role = "系统管理员";
            if (data.userRole == 0) role = "老板";
            if (data.userRole == 1) role = "员工";
            $("#userRole").text(role);
        }
        $.getTableData();
        $(document).on("click", "#save", function () {
            $.post("${pageContext.request.contextPath}/user/updateAjax",
                {
                    id: id,
                    userName: $("#userName").val(),
                    password: $("#password").val(),
                    userRealName: $("#userRealName").val(),
                    userAge: $("#userAge").val(),
                    userSex: $("#userSex").val(),
                    openId: openId,
                    userRole: userRole
                },
                function (data, status) {
                    if (data == true) {
                        alert("更改成功");
                        location.reload();
                    } else
                        alert("更改失败");
                }
            );
        });
    });
</script>
</body>
</html>