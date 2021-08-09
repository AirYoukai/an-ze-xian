<%--
  Created by IntelliJ IDEA.
  User: 24852
  Date: 2021/5/15
  Time: 9:22
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单业务</title>
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
                        <h3 class="header smaller lighter blue center">撤保申请</h3>
                    </div>
                    <div class="col-md-2">
                        <button class="btn btn-app btn-warning" id="prevPage">
                            上一个
                        </button>
                        <button class="btn btn-app btn-warning" id="nextPage">
                            下一个
                        </button>
                    </div>
                    <div class="col-md-8">
                        <div class="profile-user-info profile-user-info-striped">
                            <div class="profile-info-row">
                                <div class="profile-info-name">订单编号</div>
                                <div class="profile-info-value">
                                    <span class="editable editable-click" id="orderId">
                                    </span>
                                </div>
                            </div>
                            <div class="profile-info-row">
                                <div class="profile-info-name">服务详情</div>
                                <div class="profile-info-value">
                                    <span class="editable editable-click" id="serviceInfo" data-toggle="modal"
                                          data-target="#serviceModal">查看详情</span>
                                </div>
                            </div>
                            <div class="profile-info-row">
                                <div class="profile-info-name">支付详情</div>
                                <div class="profile-info-value">
                                    <span class="editable editable-click" id="wxpayInfo" data-toggle="modal"
                                          data-target="#wxpayModal">查看详情</span>
                                </div>
                            </div>
                            <div class="profile-info-row">
                                <div class="profile-info-name">买家详情</div>
                                <div class="profile-info-value">
                                    <span class="editable editable-click" id="buyerInfo" data-toggle="modal"
                                          data-target="#buyerModal">查看详情</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-2">
                        <a href="#" class="btn btn-app btn-success" id="agree">
                            <i class=" icon-check bigger-230"></i>
                            同意
                        </a>
                        <%--                        <a href="#" class="btn btn-app btn-danger" id="deny">--%>
                        <%--                            <i class="icon-ban-circle bigger-230"></i>--%>
                        <%--                            驳回--%>
                        <%--                        </a>--%>
                    </div>
                </div>
            </div>

            <!-- 服务模态框（Modal） -->
            <div class="modal fade" id="serviceModal" tabindex="-1" role="dialog" aria-labelledby="serviceModalLabel"
                 data-backdrop="static" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title" id="serviceModalLabel">服务详情</h4>
                        </div>
                        <div class="modal-body">
                            <div class="row">
                                <div class="col-sm-12">
                                    <nobr>套餐名</nobr>
                                    <input class="input-xxlarge" type="text" id="serviceName" disabled="true">
                                </div>
                                <div class="col-sm-12">
                                    <nobr>保险金额（元）</nobr>
                                    <input class="input-xxlarge" type="text" id="servicePremium" disabled="true">
                                </div>
                                <div class="col-sm-12">
                                    <nobr>购买价格（元）</nobr>
                                    <input class="input-xxlarge" type="text" id="servicePrice" disabled="true">
                                </div>
                                <div class="col-sm-12">
                                    <nobr>生效时长（月）</nobr>
                                    <input class="input-xxlarge" type="text" id="serviceDuration" disabled="true">
                                </div>

                                <div class="col-sm-12">
                                    <nobr>承保公司</nobr>
                                    <input class="input-xxlarge" type="text" id="companyName" disabled="true">
                                </div>
                                <div class="col-sm-12">
                                    <nobr>适用行业</nobr>
                                    <input class="input-xxlarge" type="text" id="industry" disabled="true">
                                </div>
                                <div class="col-sm-12">
                                    <nobr>联系人</nobr>
                                    <input class="input-xxlarge" type="text" id="contactName" disabled="true">
                                </div>
                                <div class="col-sm-12">
                                    <nobr>理赔方式</nobr>
                                    <select class="form-control" id="claimMethod" disabled="true">
                                        <option value="">&nbsp;</option>
                                        <option value="给付">给付</option>
                                        <option value="赔偿">赔偿</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal -->
            </div>
            <!-- 支付模态框（Modal） -->
            <div class="modal fade" id="wxpayModal" tabindex="-1" role="dialog" aria-labelledby="wxpayModalLabel"
                 data-backdrop="static" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title" id="wxpayModalLabel">支付详情</h4>
                        </div>
                        <div class="modal-body">
                            <div class="row">
                                <div class="col-sm-12">
                                    <nobr>唯一用户标识</nobr>
                                    <input class="input-xxlarge" type="text" id="wxpayOpenId" disabled="true">
                                </div>
                                <div class="col-sm-12">
                                    <nobr>公众账号ID</nobr>
                                    <input class="input-xxlarge" type="text" id="appId" disabled="true">
                                </div>
                                <div class="col-sm-12">
                                    <nobr>商户号</nobr>
                                    <input class="input-xxlarge" type="text" id="mchId" disabled="true">
                                </div>
                                <div class="col-sm-12">
                                    <nobr>随机字符串</nobr>
                                    <input class="input-xxlarge" type="text" id="nonceStr" disabled="true">
                                </div>
                                <div class="col-sm-12">
                                    <nobr>商品描述</nobr>
                                    <input class="input-xxlarge" type="text" id="body" disabled="true">
                                </div>
                                <div class="col-sm-12">
                                    <nobr>商户订单号</nobr>
                                    <input class="input-xxlarge" type="text" id="outTradeNo" disabled="true">
                                </div>
                                <div class="col-sm-12">
                                    <nobr>标价金额</nobr>
                                    <input class="input-xxlarge" type="text" id="totalFee" disabled="true">
                                </div>
                                <div class="col-sm-12">
                                    <nobr>终端IP</nobr>
                                    <input class="input-xxlarge" type="text" id="spbillCreateIp" disabled="true">
                                </div>
                                <div class="col-sm-12">
                                    <nobr>通知地址</nobr>
                                    <input class="input-xxlarge" type="text" id="notifyUrl" disabled="true">
                                </div>
                                <div class="col-sm-12">
                                    <nobr>交易类型</nobr>
                                    <input class="input-xxlarge" type="text" id="tradeType" disabled="true">
                                </div>
                                <div class="col-sm-12">
                                    <nobr>返回状态码</nobr>
                                    <input class="input-xxlarge" type="text" id="returnCode" disabled="true">
                                </div>
                                <div class="col-sm-12">
                                    <nobr>返回信息</nobr>
                                    <input class="input-xxlarge" type="text" id="resultCode" disabled="true">
                                </div>
                                <div class="col-sm-12">
                                    <nobr>预支付ID</nobr>
                                    <input class="input-xxlarge" type="text" id="prepayId" disabled="true">
                                </div>
                                <div class="col-sm-12">
                                    <nobr>签名类型</nobr>
                                    <input class="input-xxlarge" type="text" id="signType" disabled="true">
                                </div>
                                <div class="col-sm-12">
                                    <nobr>时间戳</nobr>
                                    <input class="input-xxlarge" type="text" id="timeStamp" disabled="true">
                                </div>
                                <div class="col-sm-12">
                                    <nobr>支付签名</nobr>
                                    <input class="input-xxlarge" type="text" id="paySign" disabled="true">
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            <%--                            <button type="button" class="btn btn-primary" id="submit">提交更改</button>--%>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal -->
            </div>
            <!-- 买家模态框（Modal） -->
            <div class="modal fade" id="buyerModal" tabindex="-1" role="dialog" aria-labelledby="buyerModalLabel"
                 data-backdrop="static" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title" id="buyerModalLabel">买家详情</h4>
                        </div>
                        <div class="modal-body">
                            <div class="row">
                                <div class="col-sm-12">
                                    <nobr>用户名</nobr>
                                    <input class="input-xxlarge" type="text" id="userName" disabled="true">
                                </div>

                                <div class="col-sm-12">
                                    <nobr>密码</nobr>
                                    <input class="input-xxlarge" type="text" id="password" disabled="true">
                                </div>

                                <div class="col-sm-12">
                                    <nobr>openid</nobr>
                                    <input class="input-xxlarge" type="text" id="userOpenId" disabled="true">
                                </div>
                                <div class="col-sm-12">
                                    <nobr>权限</nobr>
                                    <td>
                                        <select id="userRole" disabled="true">
                                            <option value="">&nbsp;</option>
                                            <option value="0">领导</option>
                                            <option value="1">员工</option>
                                            <option value="2">会员客户</option>
                                            <option value="3">普通客户</option>
                                        </select>
                                    </td>
                                </div>
                                <div class="col-sm-12">
                                    <nobr>真实姓名</nobr>
                                    <input class="input-xxlarge" type="text" id="userRealName" disabled="true">
                                </div>
                                <div class="col-sm-12">
                                    <nobr>年龄</nobr>
                                    <input class="input-xxlarge" type="text" id="userAge" disabled="true">
                                </div>
                                <div class="col-sm-12">
                                    <nobr>性别</nobr>
                                    <select id="userSex" disabled="true">
                                        <option value="">&nbsp;</option>
                                        <option value="male">男</option>
                                        <option value="female">女</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal -->
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
        let curData = null;//当前页面的order对象
        var id;
        var pageSize = 1;
        var pageNum = 1;
        $.getTableData = function () {
            $.post("${pageContext.request.contextPath}/insuranceOrder/selectLike",
                {
                    pageNum: pageNum,
                    pageSize: pageSize,
                    isActive: false
                },
                function (data, status) {
                    console.info(JSON.stringify(data));
                    $.appendPageInfo(data);
                    data = data.list;
                    if (data.length > 0)
                        $.appendInfo(data[0]);
                    else {
                        $(".page-content").empty();
                        $(".page-content").append("<h1>暂无待办业务</h1>");
                    }
                }
            );
        }
        //此data就是一个insuranceOrder对象
        $.appendInfo = function (data) {
            curData = data;
            id = data.id;
            $("#orderId").text(id);
            $("#serviceName").val(data.insuranceService.serviceName);
            $("#servicePremium").val(data.insuranceService.servicePremium);
            $("#servicePrice").val(data.insuranceService.servicePrice);
            $("#serviceDuration").val(data.insuranceService.serviceDuration);
            $("#industry").val(data.insuranceService.industry);
            $("#contactName").val(data.insuranceService.contactName);
            $("#claimMethod").val(data.insuranceService.claimMethod);
            $("#companyName").val(data.insuranceService.insuranceCompany.companyName);

            $("#wxpayOpenId").val(data.insuranceWxpay.openId);
            $("#appId").val(data.insuranceWxpay.appId);
            $("#mchId").val(data.insuranceWxpay.mchId);
            $("#nonceStr").val(data.insuranceWxpay.nonceStr);
            $("#body").val(data.insuranceWxpay.body);
            $("#outTradeNo").val(data.insuranceWxpay.outTradeNo);
            $("#totalFee").val(data.insuranceWxpay.totalFee);
            $("#spbillCreateIp").val(data.insuranceWxpay.spbillCreateIp);
            $("#notifyUrl").val(data.insuranceWxpay.notifyUrl);
            $("#tradeType").val(data.insuranceWxpay.tradeType);
            $("#returnCode").val(data.insuranceWxpay.returnCode);
            $("#resultCode").val(data.insuranceWxpay.resultCode);
            $("#prepayId").val(data.insuranceWxpay.prepayId);
            $("#signType").val(data.insuranceWxpay.signType);
            $("#timeStamp").val(data.insuranceWxpay.timeStamp);
            $("#paySign").val(data.insuranceWxpay.paySign)

            $("#userName").val(data.userManage.userName);
            $("#password").val(data.userManage.password);
            $("#userOpenId").val(data.userManage.openId);
            $("#userRole").val(data.userManage.userRole);
            $("#userRealName").val(data.userManage.userRealName)
            $("#userAge").val(data.userManage.userAge)
            $("#userSex").val(data.userManage.userSex)

            // let day = (String(data.insuranceOrder.expireTime.dayOfMonth).length < 2) ? ("0" + data.insuranceOrder.expireTime.dayOfMonth) : (data.insuranceOrder.expireTime.dayOfMonth);
            // let month = (String(data.insuranceOrder.expireTime.monthValue).length < 2) ? ("0" + data.insuranceOrder.expireTime.monthValue) : (data.insuranceOrder.expireTime.monthValue);
            // let year = data.insuranceOrder.expireTime.year;
        }
        //把页标信息涂上
        $.appendPageInfo = function (data) {
            pageNum = parseInt(data.pageNum);
            if (data.pageNum > 1) {
                $("#prevPage").removeClass("disabled");
            } else $("#prevPage").addClass("disabled");
            if (data.pageNum < data.pages) {
                $("#nextPage").removeClass("disabled");
            } else $("#nextPage").addClass("disabled");
        }
        $.getTableData();


        $(document).on("click", "#prevPage", function () {
            pageNum--;
            $.getTableData();
        });
        $(document).on("click", "#nextPage", function () {
            pageNum++;
            $.getTableData();
        });
        $(document).on("click", "#getProofFile", function () {
            window.location.href = "${pageContext.request.contextPath}/insuranceOrder/getProofFile?"
                + "proofFilePath=" + proofFilePath;
        });

        $(document).on("click", "#agree", function () {
            if (confirm("确认要通过吗？")) {
                $.post("${pageContext.request.contextPath}/insuranceOrder/deleteById",
                    {
                        id: id,
                    },
                    function (data, status) {
                        if (data == "true")
                            alert("操作成功");
                        else
                            alert("操作失败");
                        location.reload();
                    }
                );
            }
        });
    });
</script>
</body>
</html>