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
    <title>理赔业务</title>
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
                        <h3 class="header smaller lighter blue center">理赔业务</h3>
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
                        <div class="profile-user-info profile-user-info-striped" id="claim_info">
                            <div class="profile-info-row">
                                <div class="profile-info-name">发起日期</div>
                                <div class="profile-info-value">
                                    <span class="editable editable-click" id="createTime">
                                    </span>
                                </div>
                            </div>
                            <div class="profile-info-row">
                                <div class="profile-info-name">理赔人</div>
                                <div class="profile-info-value">
                                    <span class="editable editable-click" id="claimantInfo">
                                    </span>
                                </div>
                            </div>

                            <div class="profile-info-row">
                                <div class="profile-info-name">审核员工</div>
                                <div class="profile-info-value">
                                    <span class="editable editable-click" id="reviewStaffInfo"></span>
                                </div>
                            </div>

                            <div class="profile-info-row">
                                <div class="profile-info-name">审核领导</div>
                                <div class="profile-info-value">
                                    <span class="editable editable-click" id="reviewManagerInfo"></span>
                                </div>
                            </div>

                            <%--                            <div class="profile-info-row">--%>
                            <%--                                <div class="profile-info-name">付款人</div>--%>
                            <%--                                <div class="profile-info-value">--%>
                            <%--                                    <span class="editable editable-click" id="payerInfo"></span>--%>
                            <%--                                </div>--%>
                            <%--                            </div>--%>

                            <div class="profile-info-row">
                                <div class="profile-info-name">订单详情</div>
                                <div class="profile-info-value">
                                    <span class="editable editable-click" id="orderInfo" data-toggle="modal"
                                          data-target="#updateModal"></span>
                                </div>
                            </div>

                            <div class="profile-info-row">
                                <div class="profile-info-name">申请材料</div>
                                <div class="profile-info-value">
                                    <span class="editable editable-click" id="getProofFile">点击下载</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-2">
                        <a href="#" class="btn btn-app btn-primary" id="payBack"
                           data-toggle="modal" data-target="#paybackModal"
                        >
                            <i class="icon-laptop bigger-230"></i>
                            赔款
                        </a>
                        <a href="#" class="btn btn-app btn-success" id="agree">
                            <i class=" icon-check bigger-230"></i>
                            通过
                        </a>
                        <a href="#" class="btn btn-app btn-danger" id="deny">
                            <i class="icon-ban-circle bigger-230"></i>
                            驳回
                        </a>
                    </div>
                </div>
            </div>

            <!-- 订单模态框（Modal） -->
            <div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="updateModalLabel"
                 data-backdrop="static" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title" id="updateModalLabel">订单详情</h4>
                        </div>
                        <div class="modal-body">
                            <div class="row">
                                <div class="col-sm-12">
                                    <nobr>套餐名称</nobr>
                                    <%--  套餐名不能在这里改，要去套餐管理那边改--%>
                                    <input class="input-xxlarge" type="text" id="serviceNameUpdate" disabled="true">
                                </div>
                                <div class="col-sm-12">
                                    <nobr>承保人</nobr>
                                    <input class="input-xxlarge" type="text" id="companyNameUpdate" disabled="true">
                                </div>

                                <div class="col-sm-12">
                                    <nobr>适用行业</nobr>
                                    <input class="input-xxlarge" type="text" id="industryUpdate" disabled="true">
                                </div>
                                <div class="col-sm-12">
                                    <nobr>是否过期</nobr>
                                    <input class="input-xxlarge" type="text" id="isActiveUpdate" disabled="true">
                                    <%--                                    <select class="form-control" id="isActiveUpdate" disabled="true">--%>
                                    <%--                                        <option value="">&nbsp;</option>--%>
                                    <%--                                        <option value="true">未到期</option>--%>
                                    <%--                                        <option value="false">已过期</option>--%>
                                    <%--                                    </select>--%>
                                </div>
                                <div class="col-sm-12">
                                    <nobr>到期时间</nobr>
                                    <input class="input-xxlarge" type="date" id="expireTimeUpdate" disabled="true">
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

            <div class="modal fade" id="paybackModal" tabindex="-1" role="dialog" aria-labelledby="paybackModalLabel"
                 data-backdrop="static" aria-hidden="true"
            <%--                 style="width: 500; height: 500"--%>
            >
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h1 class="modal-title" id="paybackModalLabel">加载中。。。</h1>
                        </div>
                        <div class="modal-body">
                            <%--                            <div style="width: 100%;height:100%;">--%>
                            <div class="row">
                                <div class="col-md-9">
                                    <img id="paybackQRCode" alt="系统繁忙，请稍后重试">
                                </div>
                                <div class="col-md-3">
                                    <a href="#" class="btn btn-app btn-success" id="payBackSucceed">
                                        <i class="icon-check bigger-230"></i>
                                        确认已付
                                    </a>
                                    <a href="#" class="btn btn-app btn-danger" id="payBackCancel">
                                        <i class="icon-info-sign bigger-230"></i>
                                        取消付款
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <%--                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>--%>
                            <%--                            <button type="button" class="btn btn-primary" id="submitUpdate">提交更改</button>--%>
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
        let curData = null;//当前页面的claim对象
        var id;
        var proofFilePath = null;//存放证明材料的路径
        var staMap = new Map();//存放 日期-记录数 的键值对
        // var pageSize = $("#pageSize").val();
        var pageSize = 1;
        var pageNum = 1;
        var payBackExpire = null;
        $.getTableData = function () {
            $.post("${pageContext.request.contextPath}/insuranceClaim/selectLike",
                {
                    pageNum: pageNum,
                    pageSize: pageSize,
                    timeFrom: $("#selectTimeFrom").val(),
                    timeTo: $("#selectTimeTo").val(),
                    orderByOne: $("#orderByOne").val(),
                    orderByTwo: $("#orderByTwo").val(),
                    orderByThree: $("#orderByThree").val()
                },
                function (data, status) {
                    console.info(JSON.stringify(data));
                    $.appendPageInfo(data);
                    data = data.list;
                    staMap.clear();
                    // $.setStaMap(data);
                    if (data.length > 0){
                        $.appendInfo(data[0]);
                    }
                    else {
                        $(".page-content").empty();
                        $(".page-content").append("<h1>暂无待办业务</h1>");
                    }
                }
            );
        }
        //设置staMap的数据
        $.setStaMap = function (data) {
            for (var i = 0; i < data.length; i++) {
                var dateStr = data[i].createTime.year + "-" + data[i].createTime.monthValue + "-" + data[i].createTime.dayOfMonth;
                if (staMap.has(dateStr)) {
                    // console.info("num of "+dateStr+" is "+staMap.get(dateStr));
                    staMap.set(dateStr, staMap.get(dateStr) + 1);
                } else
                    staMap.set(dateStr, 1);
                // console.info("dateStr value in map is "+staMap.get(dateStr));
            }

            // console.info("staMap value is "+staMap.values());
        }
        //此data就是一个insuranceClaim对象
        $.appendInfo = function (data) {
            curData = data;
            id = data.id;
            createTime
            $("#createTime").text(data.createTime.year+"-"+data.createTime.monthValue+"-"+data.createTime.dayOfMonth);
            $("#claimantInfo").text(data.userManageClaimant.userRealName);
            $("#orderInfo").text("查看详情");
            $("#reviewStaffInfo").text((data.userManageReviewStaff != null) ? (data.userManageReviewStaff.userRealName) : "暂无");
            $("#reviewManagerInfo").text((data.userManageReviewManager != null) ? (data.userManageReviewManager.userRealName) : "暂无");
            // $("#payerInfo").text((data.userManagePayer != null) ? (data.userManagePayer.userRealName) : "暂无");
            proofFilePath = null;
            proofFilePath = data.proofFilePath;
            $("#serviceNameUpdate").val(data.insuranceOrder.insuranceService.serviceName);
            $("#companyNameUpdate").val(data.insuranceOrder.insuranceService.insuranceCompany.companyName);
            $("#industryUpdate").val(data.insuranceOrder.insuranceService.industry);
            $("#isActiveUpdate").val(data.insuranceOrder.isActive == true ? "未到期" : "已过期");

            let day = (String(data.insuranceOrder.expireTime.dayOfMonth).length < 2) ? ("0" + data.insuranceOrder.expireTime.dayOfMonth) : (data.insuranceOrder.expireTime.dayOfMonth);
            let month = (String(data.insuranceOrder.expireTime.monthValue).length < 2) ? ("0" + data.insuranceOrder.expireTime.monthValue) : (data.insuranceOrder.expireTime.monthValue);
            let year = data.insuranceOrder.expireTime.year;
            $("#expireTimeUpdate").val(year + "-" + month + "-" + day);

            if (data.curPos == 0 || data.curPos == 1) {
                $("#payBack").addClass("disabled");
                $("#agree").removeClass("disabled");
                $("#deny").removeClass("disabled");
            } else if (data.curPos == 2) {
                $("#payBack").removeClass("disabled");
                $("#agree").addClass("disabled");
                $("#deny").addClass("disabled");
            } else
                alert("Error in curPos!")

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
            window.location.href = "${pageContext.request.contextPath}/insuranceClaim/getProofFile?"
                + "proofFilePath=" + proofFilePath;
        });


        $(document).on("click", "#payBack", function () {
            if (confirm("确认要付款吗？")) {
                $("#paybackQRCode").attr("src", "${pageContext.request.contextPath}/insuranceClaim/payback?claimId=" + curData.id)
                payBackExpire = new Date();
                payBackExpire.setMinutes(payBackExpire.getMinutes() + 30);
                $("#paybackModalLabel").html("请在 " +
                    payBackExpire.getHours() + ":" + payBackExpire.getMinutes() + ":" + payBackExpire.getSeconds() +
                    " 前扫码支付<br>支付后请务必点击右侧的“确认已付”，否则后果自负");
            }
        });
        $(document).on("click", "#payBackSucceed", function () {
            if (confirm("重要提醒：是否确认已完成支付？")) {
                $.post("${pageContext.request.contextPath}/insuranceClaim/payBackSucceed",
                    {},
                    function (data, status) {
                        if (data == true) {
                            alert("支付成功");
                            $('#paybackModal').modal('hide');
                            location.reload();
                        } else {
                            alert("支付失败，请稍后重试");
                            $('#paybackModal').modal('hide');
                            location.reload();
                        }
                    }
                );
            }
        });
        $(document).on("click", "#payBackCancel", function () {
            if (confirm("重要提醒：是否确认要取消本次支付？")) {
                $('#paybackModal').modal('hide');
            }
        });
        $(document).on("click", "#agree", function () {
            if (confirm("确认要通过吗？")) {
                $.post("${pageContext.request.contextPath}/insuranceClaim/updateAjax",
                    {
                        id: id,
                        curPos: curData.curPos,
                        method: "agree"
                    },
                    function (data, status) {
                        if (data == true)
                            alert("更改成功");
                        else
                            alert("更改失败");
                        $('#updateModal').modal('hide');
                        location.reload();
                    }
                );
            }
        });
        $(document).on("click", "#deny", function () {
            if (confirm("确认要驳回吗？")) {
                $.post("${pageContext.request.contextPath}/insuranceClaim/updateAjax",
                    {
                        id: id,
                        curPos: curData.curPos,
                        method: "deny"
                    },
                    function (data, status) {
                        if (data == true)
                            alert("更改成功");
                        else
                            alert("更改失败");
                        $('#updateModal').modal('hide');
                        location.reload();
                        // $(".modal-backdrop.fade").hide();
                        // $("#myModal").trigger("click");
                    }
                );
            }
        });
    });
</script>
</body>
</html>