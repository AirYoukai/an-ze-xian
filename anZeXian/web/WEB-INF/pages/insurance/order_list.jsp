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
    <title>订单列表</title>
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
                        <h3 class="header smaller lighter blue center">订单列表</h3>
                    </div>

                    <%--                    <div class="col-xs-3">--%>
                    <%--                        &lt;%&ndash;                        </no&ndash;%&gt;--%>
                    <%--                        &lt;%&ndash;                        </no&ndash;%&gt;--%>
                    <%--                        &lt;%&ndash;                        </nobr>&ndash;%&gt;--%>
                    <%--                        &lt;%&ndash;                        </nob&ndash;%&gt;--%>
                    <%--                        &lt;%&ndash;                        </nobr&ndash;%&gt;--%>
                    <%--                        &lt;%&ndash;                        </nob&ndash;%&gt;--%>
                    <%--                        &lt;%&ndash;                        </nobr&ndash;%&gt;--%>
                    <%--                        &lt;%&ndash;                        </nobr&ndash;%&gt;--%>
                    <%--                        &lt;%&ndash;                        </nobr&ndash;%&gt;--%>
                    <%--                        &lt;%&ndash;                        </nobr&ndash;%&gt;--%>
                    <%--                        &lt;%&ndash;                        </nob&ndash;%&gt;--%>
                    <%--                        &lt;%&ndash;                        </nobr&ndash;%&gt;--%>
                    <%--                        &lt;%&ndash;                        </nob&ndash;%&gt;--%>
                    <%--                        &lt;%&ndash;                        </nobr&ndash;%&gt;--%>
                    <%--                        &lt;%&ndash;                        </nobr>&ndash;%&gt;--%>
                    <%--                        &lt;%&ndash;                        </nobr&ndash;%&gt;--%>
                    <%--                        &lt;%&ndash;                        </nobr&ndash;%&gt;--%>
                    <%--                        &lt;%&ndash;                        </nobr&ndash;%&gt;--%>
                    <%--                        <nobr>第一字段</nobr>--%>
                    <%--                        <select id="orderByOne">--%>
                    <%--                            <option value="">&nbsp;</option>--%>
                    <%--                            <option value="open_id">唯一用户标识</option>--%>
                    <%--                            <option value="app_id">公众账号ID</option>--%>
                    <%--                            <option value="mch_id">商户号</option>--%>
                    <%--                            <option value="nonce_str">随机字符串</option>--%>
                    <%--                            <option value="body">商品描述</option>--%>
                    <%--                            <option value="out_trade_no">商户订单号</option>--%>
                    <%--                            <option value="total_fee">标价金额</option>--%>
                    <%--                            <option value="spbill_create_ip">终端IP</option>--%>
                    <%--                            <option value="notify_url">通知地址</option>--%>
                    <%--                            <option value="trade_type">交易类型</option>--%>
                    <%--                            <option value="return_code">返回状态码</option>--%>
                    <%--                            <option value="result_code">返回信息</option>--%>
                    <%--                            <option value="prepay_id">预订单ID</option>--%>
                    <%--                            <option value="sign_type">签名类型</option>--%>
                    <%--                            <option value="time_stamp">时间戳</option>--%>
                    <%--                            <option value="pay_sign">订单签名</option>--%>
                    <%--                            <option value="unifiedorder_succeed">下单结果</option>--%>
                    <%--                            <option value="pay_succeed">订单结果</option>--%>
                    <%--                            <option value="unifiedOrder_time">下单时间</option>--%>
                    <%--                            <option value="pay_time">订单时间</option>--%>
                    <%--                            <option value="create_time">创建时间</option>--%>
                    <%--                        </select>--%>
                    <%--                    </div>--%>
                    <%--                    <div class="col-md-3">--%>
                    <%--                        <nobr>第二字段</nobr>--%>
                    <%--                        <select id="orderByTwo">--%>
                    <%--                            <option value="">&nbsp;</option>--%>
                    <%--                            <option value="open_id">唯一用户标识</option>--%>
                    <%--                            <option value="app_id">公众账号ID</option>--%>
                    <%--                            <option value="mch_id">商户号</option>--%>
                    <%--                            <option value="nonce_str">随机字符串</option>--%>
                    <%--                            <option value="body">商品描述</option>--%>
                    <%--                            <option value="out_trade_no">商户订单号</option>--%>
                    <%--                            <option value="total_fee">标价金额</option>--%>
                    <%--                            <option value="spbill_create_ip">终端IP</option>--%>
                    <%--                            <option value="notify_url">通知地址</option>--%>
                    <%--                            <option value="trade_type">交易类型</option>--%>
                    <%--                            <option value="return_code">返回状态码</option>--%>
                    <%--                            <option value="result_code">返回信息</option>--%>
                    <%--                            <option value="prepay_id">预订单ID</option>--%>
                    <%--                            <option value="sign_type">签名类型</option>--%>
                    <%--                            <option value="time_stamp">时间戳</option>--%>
                    <%--                            <option value="pay_sign">订单签名</option>--%>
                    <%--                            <option value="unifiedorder_succeed">下单结果</option>--%>
                    <%--                            <option value="pay_succeed">订单结果</option>--%>
                    <%--                            <option value="unifiedOrder_time">下单时间</option>--%>
                    <%--                            <option value="pay_time">订单时间</option>--%>
                    <%--                            <option value="create_time">创建时间</option>--%>
                    <%--                        </select>--%>
                    <%--                    </div>--%>
                    <%--                    <div class="col-md-3">--%>
                    <%--                        <nobr>第三字段</nobr>--%>
                    <%--                        <select id="orderByThree">--%>
                    <%--                            <option value="">&nbsp;</option>--%>
                    <%--                            <option value="open_id">唯一用户标识</option>--%>
                    <%--                            <option value="app_id">公众账号ID</option>--%>
                    <%--                            <option value="mch_id">商户号</option>--%>
                    <%--                            <option value="nonce_str">随机字符串</option>--%>
                    <%--                            <option value="body">商品描述</option>--%>
                    <%--                            <option value="out_trade_no">商户订单号</option>--%>
                    <%--                            <option value="total_fee">标价金额</option>--%>
                    <%--                            <option value="spbill_create_ip">终端IP</option>--%>
                    <%--                            <option value="notify_url">通知地址</option>--%>
                    <%--                            <option value="trade_type">交易类型</option>--%>
                    <%--                            <option value="return_code">返回状态码</option>--%>
                    <%--                            <option value="result_code">返回信息</option>--%>
                    <%--                            <option value="prepay_id">预订单ID</option>--%>
                    <%--                            <option value="sign_type">签名类型</option>--%>
                    <%--                            <option value="time_stamp">时间戳</option>--%>
                    <%--                            <option value="pay_sign">订单签名</option>--%>
                    <%--                            <option value="unifiedorder_succeed">下单结果</option>--%>
                    <%--                            <option value="pay_succeed">订单结果</option>--%>
                    <%--                            <option value="unifiedOrder_time">下单时间</option>--%>
                    <%--                            <option value="pay_time">订单时间</option>--%>
                    <%--                            <option value="create_time">创建时间</option>--%>
                    <%--                        </select>--%>
                    <%--                    </div>--%>
                    <%--                    <div class="col-md-3">--%>
                    <%--                        <button class="btn btn-sm btn-primary" id="setOrder">排序</button>--%>
                    <%--                    </div>--%>
                    <%--                    </div>--%>
                    <div class="col-md-12">
                        <table id="sample-table-1" class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th class="center no-print">
                                    <label>
                                        <input type="checkbox" class="ace">
                                        <span class="lbl"></span>
                                    </label>
                                </th>
                                <th>
                                    <nobr>套餐名称</nobr>
                                </th>
                                <th>
                                    <nobr>承保人</nobr>
                                </th>
                                <th>
                                    <nobr>适用行业</nobr>
                                </th>
                                <th>
                                    <nobr>是否过期</nobr>
                                </th>
                                <th>
                                    <nobr><i class="icon-time bigger-110 hidden-480"></i>
                                        到期时间
                                    </nobr>
                                </th>
                                <th>
                                    <nobr>
                                        <i class="icon-time bigger-110 hidden-480"></i>
                                        创建时间
                                    </nobr>
                                </th>
                                <%--                                <th class="hidden-480">状态</th>--%>
                                <th class="no-print">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            </tbody>
                            <thead class="no-print">
                            <tr>
                                <td></td>
                                <td>
                                    <input type="text" class="col-xs-12" id="serviceNameSelect">
                                </td>
                                <td>
                                    <select class="form-control col-xs-12" id="companyIdSelect">
                                    </select>
                                </td>
                                <td>
                                    <input class="col-xs-12" type="text" id="industrySelect">
                                </td>
                                <td>
                                    <select class="form-control col-xs-12" id="isActiveSelect">--%>
                                        <%--                                        <option value="">&nbsp;</option>--%>
                                        <option value="true" selected="true">未到期</option>
                                        <option value="false">已过期</option>
                                    </select>
                                </td>
                                <td>
                                    <input class="col-xs-5" type="date" id="expireTimeFromSelect">
                                    <div class="col-xs-2">
                                        至
                                    </div>
                                    <input class="col-xs-5" type="date" id="expireTimeToSelect">
                                </td>
                                <td>
                                    <input class="col-xs-5" type="date" id="createTimeFromSelect">
                                    <div class="col-xs-2">至</div>
                                    <input class="col-xs-5" type="date" id="createTimeToSelect">
                                </td>
                                <td>
                                                                <span class="input-group-btn">
                                                                    <button type="button" class="btn btn-purple btn-sm"
                                                                            id="selectLike">
                            							                查询
                                                                    <i class="icon-search icon-on-right bigger-110"></i>
                                                                    </button>
                                                                </span>
                                </td>
                            </tr>
                            </thead>
                        </table>
                    </div>

                    <div class="col-sm-3">
                        <div id="sample-table-2_length" class="dataTables_length">
                            <nobr>
                                <label>显示
                                    <select size="1"
                                            name="sample-table-2_length"
                                            aria-controls="sample-table-2"
                                            id="pageSize">
                                        <option value="1">1</option>
                                        <option value="10" selected="selected">10</option>
                                        <option value="50">50</option>
                                        <option value="100">100</option>
                                    </select>条数据</label>
                            </nobr>
                        </div>
                    </div>
                    <div class="col-sm-3">
                        <div class="dataTables_paginate paging_bootstrap" style="float:right">
                            <ul class="pagination" id="goToPage">
                            </ul>
                        </div>
                    </div>
                    <div class="col-sm-3">
                        <%--                        <input class="input-mini" type="text" id="targetPageNum" placeholder="跳转到">--%>
                        <%--                        <button class="btn btn-sm btn-default" type="button"--%>
                        <%--                                id="goToPage">Go!--%>
                        <%--                        </button>--%>
                    </div>
                    <%--                    <div class="col-sm-1">--%>
                    <%--                        <span class="input-group-btn">--%>
                    <%--                            <button class="btn btn-danger btn-sm" id="addData" data-toggle="modal"--%>
                    <%--                                    data-target="#addModal">添加</button>--%>
                    <%--                        </span>--%>
                    <%--                    </div>--%>
                    <div class="col-sm-1">
                     <span class="input-group-btn">
                        <button id="openStaModal" class="btn btn-purple btn-sm" data-toggle="modal"
                                data-target="#staModal">统计</button>
                     </span>
                    </div>
                    <div class="col-sm-1">
                     <span class="input-group-btn">
                        <button class="btn btn-pink btn-sm" id="printData">打印</button>
                     </span>
                    </div>
                    <div class="col-sm-1">
                     <span class="input-group-btn">
                         <button class="btn btn-yellow btn-sm" id="exportData">导出</button>
                     </span>
                    </div>
                </div>
            </div>
            <!-- 统计模态框（Modal） -->
            <div class="modal fade" id="staModal" tabindex="-1" role="dialog" aria-labelledby="staModalLabel"
                 data-backdrop="static" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title" id="staModalLabel">统计信息</h4>
                        </div>
                        <div class="modal-body">
                            <div class="row">
                                <div class="col-md-3">
                                    <h5>统计基准</h5>
                                </div>
                                <div class="col-md-9">
                                    <select class="form-control" id="staTarget">
                                        <option value="date" selected="selected">按日期</option>
                                        <option value="industry">按行业</option>
                                    </select>
                                </div>
                            </div>
                            <div id="staModalContent" style="width: 600px;height:400px;"></div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal -->
            </div>

            <!-- 修改模态框（Modal） -->
            <div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="updateModalLabel"
                 data-backdrop="static" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title" id="updateModalLabel">修改信息（部分字段请到服务列表页面进行操作）</h4>
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
                                    <select class="form-control col-xs-12" id="isActiveUpdate">
                                        <option value="">未知</option>
                                        <option value="true">未到期</option>
                                        <option value="false">已过期</option>
                                    </select>
                                </div>
                                <div class="col-sm-12">
                                    <nobr>到期时间</nobr>
                                    <input class="input-xxlarge" type="date" id="expireTimeUpdate">
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            <button type="button" class="btn btn-primary" id="submitUpdate">提交更改</button>
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
        let items = new Array("~", "`", "!", "@", "#", "$", "%", "^", "&", "*", "{", "}", "[", "]", "(", ")");
        var id;
        var dataListAll = null;//存放全部的数据内容
        var industryStaMap = new Map();//存放 行业-记录数 的键值对
        var dateStaMap = new Map();//存放 日期-记录数 的键值对
        var companyArray = new Array();//存放所有的公司信息，用来设计单选框，要调用company getAll
        var serviceArray = new Array();//存放所有的套餐信息，用来设计单选框
        var pageSize = $("#pageSize").val();
        var pageNum = 1;
        let option = null;//这就是画图的那个B东西，当全局了

        function inputCheckNumber(str) {
            try {
                // alert(str);
                if (str != "" || str != null) {
                    for (var i = 0; i < items.length; i++) {
                        if (str.indexOf(items[i]) >= 0) {
                            throw "含有非法字符";
                            break;
                        }
                    }
                    if (isNaN(str)) throw "必须是数字";
                    if (str.length > 60) throw "输入字符太长";
                }
            } catch (err) {
                alert("输入不合法！提示：" + err);
                return false;
            }
            return true;
        }

        function inputCheck(str) {
            try {
                if (str != "" || str != null) {
                    for (var i = 0; i < items.length; i++) {
                        if (str.indexOf(items[i]) >= 0) {
                            throw "含有非法字符";
                            break;
                        }
                    }
                    if (str.length > 60) throw "输入字符太长";
                }
            } catch (err) {
                alert("输入不合法！提示：" + err);
                return false;
            }
            return true;
        }


        $.getAllCompany = function () {
            companyArray.length = 0;
            $.post("${pageContext.request.contextPath}/insuranceService/getAllCompany",
                {},
                function (data, status) {
                    console.info("AllCompany=" + JSON.stringify(data));
                    $("#companyIdSelect").append(" <option value=\"\"></option>");
                    for (var i = 0; i < data.length; i++) {
                        $("#companyIdSelect").append(" <option value=\"" + data[i].id + "\">" + data[i].companyName + "</option>");
                    }
                }
            );
        }

        $.getTableData = function () {
            if (
                inputCheck($("#serviceNameSelect").val()) &&
                inputCheck($("#industrySelect").val())
            ) {
                $.post("${pageContext.request.contextPath}/insuranceOrder/selectLike",
                    {
                        pageNum: pageNum,
                        pageSize: pageSize,
                        serviceName: $("#serviceNameSelect").val(),
                        companyId: $("#companyIdSelect").val(),
                        industry: $("#industrySelect").val(),
                        isActive: $("#isActiveSelect").val(),
                        expireTimeFrom: $("#expireTimeFromSelect").val(),
                        expireTimeTo: $("#expireTimeToSelect").val(),
                        createTimeFrom: $("#createTimeFromSelect").val(),
                        createTimeTo: $("#createTimeToSelect").val(),
                        orderByOne: $("#orderByOne").val(),
                        orderByTwo: $("#orderByTwo").val(),
                        orderByThree: $("#orderByThree").val()
                    },
                    function (data, status) {
                        $("tbody").empty();
                        console.info(JSON.stringify(data));
                        $.appendPageInfo(data);
                        $.setStaMap(data.list);
                        $.appendTable(data.list);
                        // $.appendSelector();
                    }
                );
            }
        }
        $.setStaMap = function (data) {        //设置dateStaMap的数据
            industryStaMap.clear();
            dateStaMap.clear();
            for (var i = 0; i < data.length; i++) {
                var dateStr = data[i].createTime.year + "-" + data[i].createTime.monthValue + "-" + data[i].createTime.dayOfMonth;
                if (dateStaMap.has(dateStr)) {
                    // console.info("num of "+dateStr+" is "+dateStaMap.get(dateStr));
                    dateStaMap.set(dateStr, dateStaMap.get(dateStr) + 1);
                } else
                    dateStaMap.set(dateStr, 1);
                var industry = data[i].insuranceService.industry;
                if (industryStaMap.has(industry))
                    industryStaMap.set(industry, industryStaMap.get(industry) + 1);
                else
                    industryStaMap.set(industry, 1);
            }
        }
        //把当前页面的表格涂满
        $.appendTable = function (data) {
            // alert("appendTable："+data);
            $("tbody").empty();
            for (var i = 0; i < data.length; i++) {
                $("tbody").append("<tr></tr>");
                $("tbody tr:last-child").append("   <td class=\"center no-print\">\n" +
                    "                            <label>\n" +
                    "                            <input type=\"checkbox\" class=\"ace\" id=\"data[i].id\">\n" +
                    "                            <span class=\"lbl\"></span>\n" +
                    "                            </label>\n" +
                    "                            </td>");

                $("tbody tr:last-child").append("<td>" + data[i].insuranceService.serviceName + "</td>");
                $("tbody tr:last-child").append("<td>" + data[i].insuranceService.insuranceCompany.companyName + "</td>");
                $("tbody tr:last-child").append("<td>" + data[i].insuranceService.industry + "</td>");
                if (data[i].isActive == true)
                    $("tbody tr:last-child").append("<td class=\"hidden-480\"><span class=\"label label-sm label-primary\">未到期</span></td>");
                else
                    $("tbody tr:last-child").append("<td class=\"hidden-480\"> <span class=\"label label-sm label-danger\">已过期</span></td>");

                $("tbody tr:last-child").append("<td>" + data[i].expireTime.year + "-" + data[i].expireTime.monthValue + "-" + data[i].expireTime.dayOfMonth + "</td>");
                $("tbody tr:last-child").append("<td>" + data[i].createTime.year + "-" + data[i].createTime.monthValue + "-" + data[i].createTime.dayOfMonth + "</td>");

                $("tbody tr:last-child").append("\n" +
                    "                                    <td  class=\"no-print\"><a class=\"tooltip-success updateById\" data-rel=\"tooltip\"\n" +
                    "                               id=\"updateById?id=" + data[i].id + "\"" +
                    " data-toggle=\"modal\"\n" +
                    "                               data-target=\"#updateModal\"\n" +
                    "                               data-original-title=\"修改\">\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"green\">\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"icon-edit bigger-120\"></i>\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\n" +
                    "                            </a>\n" +
                    "                            <a class=\"tooltip-error deleteById\" data-rel=\"tooltip\"\n" +
                    "                               id=\"deleteById?id=" + data[i].id + "\"" +
                    "                               data-original-title=\"删除\">\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"red\">\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"icon-trash bigger-120\"></i>\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\n" +
                    "                            </a>" +
                    "</td>");

                let tmp = {
                    id: data[i].insuranceService.insuranceCompany.id,
                    companyName: data[i].insuranceService.insuranceCompany.companyName
                };
            }
        }

/////////////////////////////页标操作////////////////////////////////
        //把页标信息涂上
        $.appendPageInfo = function (data) {
            $("#goToPage").empty();
            $("#goToPage").append("<li class=\"prev\"><a  id=\"prevPage\"><i class=\"icon-double-angle-left\"></i></a></li>");
            $("#goToPage").append("<li class=\"active\"><a >" + data.pageNum + "</a></li>");
            $("#goToPage").append("<li class=\"next\"><a id=\"nextPage\"><i class=\"icon-double-angle-right\"></i></a></li>");
            pageNum = parseInt(data.pageNum);
            if (data.pageNum > 1) {
                $(".prev").removeClass("disabled");
            } else $(".prev").addClass("disabled");
            if (data.pageNum < data.pages) {
                $(".next").removeClass("disabled");
            } else $(".next").addClass("disabled");
            console.info("current pageNum is " + pageNum);
        }

        $(document).on("click", "#setOrder", function () {//排序 从第一页开始
            pageNum = 1;
            $.getTableData();
        });
        $(document).on("click", "#prevPage", function () {
            pageNum--;
            $.getTableData();
        });
        $(document).on("click", "#nextPage", function () {
            pageNum++;
            $.getTableData();
        });
        $(document).on("click", "#goToPage", function () {
            pageNum = $("#targetPageNum").val();
            $.getTableData();
        });
        $(document).on("change", "#pageSize", function () { //更改了页面记录数量从第一页开始
            pageNum = 1;
            pageSize = $("#pageSize").val();
            $.getTableData();
        });
        $(document).on("click", "#selectLike", function () {//查询从第一页开始
            pageNum = 1;
            $.getTableData();
        });
        $.getAllCompany();
        $.getTableData();
///////////////////////////////页标操作结束///////////////////////////////


        $(document).on("click", ".updateById", function () {
            // 动作触发后执行的代码!!
            id = $(this).attr("id").split("?")[1].split("=")[1];
            console.info("id in updateById is " + id);
            $.get("${pageContext.request.contextPath}/insuranceOrder/selectById?id=" + id, function (data, status) {
                $("#serviceNameUpdate").val(data.insuranceService.serviceName);
                $("#companyNameUpdate").val(data.insuranceService.insuranceCompany.companyName);
                $("#industryUpdate").val(data.insuranceService.industry);
                $("#isActiveUpdate").val(data.isActive.toString());
                let day = (String(data.expireTime.dayOfMonth).length < 2) ? ("0" + data.expireTime.dayOfMonth) : (data.expireTime.dayOfMonth);
                let month = (String(data.expireTime.monthValue).length < 2) ? ("0" + data.expireTime.monthValue) : (data.expireTime.monthValue);
                let year = data.expireTime.year;
                $("#expireTimeUpdate").val(year + "-" + month + "-" + day);

                // $("#openIdUpdate").val(data.openId);
            });
        });
        $(document).on("click", "#submitUpdate", function () {
            console.info("id selected to update is " + id);
            $.post("${pageContext.request.contextPath}/insuranceOrder/updateAjax",
                {
                    id: id,
                    isActive: $("#isActiveUpdate").val(),
                    expireTime: $("#expireTimeUpdate").val()
                },
                function (data, status) {
                    if (data == true) {
                        alert("更改成功");
                        location.reload();
                    } else
                        alert("更改失败");
                    $('#updateModal').modal('hide');
                    // $(".modal-backdrop.fade").hide();
                    // $("#myModal").trigger("click");
                }
            );
        });
        $(document).on("click", ".deleteById", function () {
            id = $(this).attr("id").split("?")[1].split("=")[1];
            if (confirm("确认要删除吗？")) {
                console.info("id selected is " + id);
                $.post("${pageContext.request.contextPath}/insuranceOrder/deleteById",
                    {
                        id: id
                    },
                    function (data, status) {
                        if (data == "true") {
                            alert("删除成功");
                            location.reload();
                        } else
                            alert("删除失败");
                    }
                );
            }
        });

        $(document).on("click", "#exportData", function () {
            window.location.href = "${pageContext.request.contextPath}/insuranceOrder/exportData?"
                + "companyName=" + $("#companyNameSelect").val() + "&"
                + "industry=" + $("#industrySelect").val() + "&"
                + "isActive=" + $("#isActiveSelect").val();
        });

        $(document).on("click", "#printData", function () {
            $(".table").print({
                globalStyles: true,//是否包含父文档的样式，默认为true
                mediaPrint: false,//是否包含media='print'的链接标签。会被globalStyles选项覆盖，默认为false
                stylesheet: null,//外部样式表的URL地址，默认为null
                noPrintSelector: ".no-print",//不想打印的元素的jQuery选择器，默认为".no-print"
                iframe: true,//是否使用一个iframe来替代打印表单的弹出窗口，true为在本页面进行打印，false就是说新开一个页面打印，默认为true
                append: null,//将内容添加到打印内容的后面
                prepend: null,//将内容添加到打印内容的前面，可以用来作为要打印内容
                deferred:
                    $.Deferred()//回调函数
            });
        });
        $(document).on("change", "#staTarget", function () {
            var myChart = echarts.init(document.getElementById('staModalContent'));
            let staTarget = $("#staTarget").val();
            if (staTarget == "date") staByDate();
            else if (staTarget == "industry") staByIndustry();
            myChart.setOption(option);
        });

        $(document).on("click", "#openStaModal", function () {
            // $.getAllData();
            var myChart = echarts.init(document.getElementById('staModalContent'));
            let staTarget = $("#staTarget").val();
            if (staTarget == "date") staByDate();
            else if (staTarget == "industry")
                staByIndustry();
            myChart.setOption(option);
        });

        function staByIndustry() {
            let industryStrs = new Array();//存放日期字符串的数组
            let industryNum = new Array();//存放个数的数组
            //遍历map并取key 和 value
            for (key of industryStaMap.keys()) {
                industryStrs.push(key); // map.get(key)可得value值。
            }
            industryStrs.sort();
            industryStrs.forEach(function (item, idnex, array) {
                console.log(item)     // 1 2 3 4 5 6
                // console.log(array)    // [1, 2, 3, 4, 5, 6]
                industryNum.push(industryStaMap.get(item));
            })
            console.info("industryStrs is " + industryStrs);
            console.info("industryNum is " + industryNum);
            option = {
                //标题
                title: {
                    text: '订单情况'
                },
                //工具箱
                //保存图片
                toolbox: {
                    show: true,
                    feature: {
                        saveAsImage: {
                            show: true
                        }
                    }
                },
                //图例-每一条数据的名字叫注册用户数量
                legend: {
                    data: ['订单总数']
                },
                //x轴
                xAxis: {
                    // data: ["苹果", "橘子", "橙子", "香蕉", "菠萝", "榴莲"]//数组
                    data: industryStrs
                },
                //y轴没有显式设置，根据值自动生成y轴
                yAxis: {},
                //数据-data是最终要显示的数据
                series: [{
                    name: '该行业订单数',
                    type: 'line',
                    data: industryNum
                    // data: [40, 20, 35, 60, 55, 10]//data是数组
                }]
            };
            // 使用刚指定的配置项和数据显示图表。
        }

        function staByDate() {
            let dateStrs = new Array();//存放日期字符串的数组
            let dateNum = new Array();//存放个数的数组
            //遍历map并取key 和 value
            for (key of dateStaMap.keys()) {
                dateStrs.push(key); // map.get(key)可得value值。
            }
            dateStrs.sort();
            dateStrs.forEach(function (item, idnex, array) {
                console.log(item)     // 1 2 3 4 5 6
                // console.log(array)    // [1, 2, 3, 4, 5, 6]
                dateNum.push(dateStaMap.get(item));
            })
            console.info("dateStrs is " + dateStrs);
            console.info("dateNum is " + dateNum);
            option = {
                //标题
                title: {
                    text: '订单情况'
                },
                //工具箱
                //保存图片
                toolbox: {
                    show: true,
                    feature: {
                        saveAsImage: {
                            show: true
                        }
                    }
                },
                //图例-每一条数据的名字叫注册用户数量
                legend: {
                    data: ['订单总数']
                },
                //x轴
                xAxis: {
                    // data: ["苹果", "橘子", "橙子", "香蕉", "菠萝", "榴莲"]//数组
                    data: dateStrs
                },
                //y轴没有显式设置，根据值自动生成y轴
                yAxis: {},
                //数据-data是最终要显示的数据
                series: [{
                    name: '当日订单数',
                    type: 'line',
                    data: dateNum
                    // data: [40, 20, 35, 60, 55, 10]//data是数组
                }]
            };
            // 使用刚指定的配置项和数据显示图表。
        }
    });

</script>
</body>
</html>