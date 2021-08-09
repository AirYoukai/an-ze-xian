<%--
  Created by IntelliJ IDEA.
  User: 24852
  Date: 2021/3/13selectById
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>支付列表</title>
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
                        <h3 class="header smaller lighter blue center">支付列表</h3>
                    </div>

                    <div class="col-xs-3">
                        <%--                        </no--%>
                        <%--                        </no--%>
                        <%--                        </nobr>--%>
                        <%--                        </nob--%>
                        <%--                        </nobr--%>
                        <%--                        </nob--%>
                        <%--                        </nobr--%>
                        <%--                        </nobr--%>
                        <%--                        </nobr--%>
                        <%--                        </nobr--%>
                        <%--                        </nob--%>
                        <%--                        </nobr--%>
                        <%--                        </nob--%>
                        <%--                        </nobr--%>
                        <%--                        </nobr>--%>
                        <%--                        </nobr--%>
                        <%--                        </nobr--%>
                        <%--                        </nobr--%>
                        <nobr>第一字段</nobr>
                        <select id="orderByOne">
                            <option value="">&nbsp;</option>
                            <option value="open_id">唯一用户标识</option>
                            <option value="mch_id">商户号</option>
                            <option value="body">商品描述</option>
                            <option value="out_trade_no">商户订单号</option>
                            <option value="total_fee">标价金额</option>
                            <option value="trade_type">交易类型</option>
                            <%--                            <option value="unifiedorder_succeed">下单结果</option>--%>
                            <%--                            <option value="pay_succeed">支付结果</option>--%>
                            <option value="unifiedOrder_time">下单时间</option>
                            <option value="pay_time">支付时间</option>
                            <option value="create_time">创建时间</option>
                        </select>
                    </div>
                    <div class="col-md-3">
                        <nobr>第二字段</nobr>
                        <select id="orderByTwo">
                            <option value="">&nbsp;</option>
                            <option value="open_id">唯一用户标识</option>
                            <option value="mch_id">商户号</option>
                            <option value="body">商品描述</option>
                            <option value="out_trade_no">商户订单号</option>
                            <option value="total_fee">标价金额</option>
                            <option value="trade_type">交易类型</option>
                            <%--                            <option value="unifiedorder_succeed">下单结果</option>--%>
                            <%--                            <option value="pay_succeed">支付结果</option>--%>
                            <option value="unifiedOrder_time">下单时间</option>
                            <option value="pay_time">支付时间</option>
                            <option value="create_time">创建时间</option>
                        </select>
                    </div>
                    <div class="col-md-3">
                        <nobr>第三字段</nobr>
                        <select id="orderByThree">
                            <option value="">&nbsp;</option>
                            <option value="open_id">唯一用户标识</option>
                            <option value="mch_id">商户号</option>
                            <option value="body">商品描述</option>
                            <option value="out_trade_no">商户订单号</option>
                            <option value="total_fee">标价金额</option>
                            <option value="trade_type">交易类型</option>
                            <%--                            <option value="unifiedorder_succeed">下单结果</option>--%>
                            <%--                            <option value="pay_succeed">支付结果</option>--%>
                            <option value="unifiedOrder_time">下单时间</option>
                            <option value="pay_time">支付时间</option>
                            <option value="create_time">创建时间</option>
                        </select>
                    </div>
                    <div class="col-md-3">
                        <button class="btn btn-sm btn-primary" id="setOrder">排序</button>
                    </div>
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
                                    <nobr>唯一用户标识</nobr>
                                </th>
                                <%--                                <th>--%>
                                <%--                                    <nobr>公众账号ID</nobr>--%>
                                <%--                                </th>--%>
                                <th>
                                    <nobr>商户号</nobr>
                                </th>
                                <%--                                <th>--%>
                                <%--                                    <nobr>随机字符串</nobr>--%>
                                <%--                                </th>--%>
                                <th>
                                    <nobr>商品描述</nobr>
                                </th>
                                <th>
                                    <nobr>商户订单号</nobr>
                                </th>
                                <th>
                                    <nobr>标价金额</nobr>
                                </th>
                                <%--                                <th>--%>
                                <%--                                    <nobr>终端IP</nobr>--%>
                                <%--                                </th>--%>
                                <%--                                <th>--%>
                                <%--                                    <nobr>通知地址</nobr>--%>
                                <%--                                </th>--%>
                                <th>
                                    <nobr>交易类型</nobr>
                                </th>
                                <%--                                <th>--%>
                                <%--                                    <nobr>返回状态码</nobr>--%>
                                <%--                                </th>--%>
                                <%--                                <th>--%>
                                <%--                                    <nobr>返回信息</nobr>--%>
                                <%--                                </th>--%>
                                <%--                                <th>--%>
                                <%--                                    <nobr>预支付ID</nobr>--%>
                                <%--                                </th>--%>
                                <%--                                <th>--%>
                                <%--                                    <nobr>签名类型</nobr>--%>
                                <%--                                </th>--%>
                                <%--                                <th>--%>
                                <%--                                    <nobr>时间戳</nobr>--%>
                                <%--                                </th>--%>
                                <%--                                <th>--%>
                                <%--                                    <nobr>支付签名</nobr>--%>
                                <%--                                </th>--%>
                                <th>
                                    <nobr>下单结果</nobr>
                                </th>
                                <th>
                                    <nobr>支付结果</nobr>
                                </th>
                                <th>
                                    <nobr>
                                        <i class="icon-time bigger-110 hidden-480"></i>
                                        下单时间
                                    </nobr>
                                </th>
                                <th>
                                    <nobr>
                                        <i class="icon-time bigger-110 hidden-480"></i>
                                        支付时间
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
                                    <input class="col-xs-12" type="text" id="openIdSelect">
                                </td>
                                <%--                                <td>--%>
                                <%--                                    <input class="col-xs-12" type="text" id="appIdSelect">--%>
                                <%--                                </td>--%>
                                <td>
                                    <input class="col-xs-12" type="text" id="mchIdSelect">
                                </td>
                                <%--                                <td>--%>
                                <%--                                    <input class="col-xs-12" type="text" id="nonceStrSelect">--%>
                                <%--                                </td>--%>
                                <td>
                                    <input class="col-xs-12" type="text" id="bodySelect">
                                </td>
                                <td>
                                    <input class="col-xs-12" type="text" id="outTradeNoSelect">
                                </td>
                                <td>
                                    <input class="col-xs-12" type="text" id="totalFeeSelect">
                                </td>

                                <%--                                <td>--%>
                                <%--                                    <input class="col-xs-12" type="text" id="spbillCreateIpSelect">--%>
                                <%--                                </td>--%>
                                <%--                                <td>--%>
                                <%--                                    <input class="col-xs-12" type="text" id="notifyUrlSelect">--%>
                                <%--                                </td>--%>
                                <td>
                                    <input class="col-xs-12" type="text" id="tradeTypeSelect">
                                </td>
                                <%--                                <td>--%>
                                <%--                                    <input class="col-xs-12" type="text" id="returnCodeSelect">--%>
                                <%--                                </td>--%>
                                <%--                                <td>--%>
                                <%--                                    <input class="col-xs-12" type="text" id="resultCodeSelect">--%>
                                <%--                                </td>--%>
                                <%--                                <td>--%>
                                <%--                                    <input class="col-xs-12" type="text" id="prepayIdSelect">--%>
                                <%--                                </td>--%>
                                <%--                                <td>--%>
                                <%--                                    <input class="col-xs-12" type="text" id="signTypeSelect">--%>
                                <%--                                </td>--%>

                                <%--                                <td>--%>
                                <%--                                    <input class="col-xs-12" type="text" id="timeStampSelect">--%>
                                <%--                                </td>--%>
                                <%--                                <td>--%>
                                <%--                                    <input class="col-xs-12" type="text" id="paySignSelect">--%>
                                <%--                                </td>--%>
                                <td>
                                    <%--                                    <input class="col-xs-12" type="text" id="unifiedorderSucceedSelect">--%>
                                </td>
                                <td>
                                    <%--                                    <input class="col-xs-12" type="text" id="paySucceedSelect">--%>
                                </td>
                                <td>
                                    <input class="col-xs-5" type="date" id="unifiedorderTimeFromSelect">
                                    <div class="col-xs-2">至</div>
                                    <input class="col-xs-5" type="date" id="unifiedorderTimeToSelect">
                                </td>
                                <td>
                                    <input class="col-xs-5" type="date" id="payTimeFromSelect">
                                    <div class="col-xs-2">至</div>
                                    <input class="col-xs-5" type="date" id="payTimeToSelect">
                                </td>
                                <td>
                                    <input class="col-xs-5" type="date" id="createTimeFromSelect">
                                    <div class="col-xs-2">至</div>
                                    <input class="col-xs-5" type="date" id="createTimeToSelect">
                                </td>

                                <td>
                        <span class="input-group-btn">
                            <button type="button" class="btn btn-purple btn-sm" id="selectLike">
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
                            <nobr><label>显示
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

                        <%--                        </span>--%>
                    </div>
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


            <!-- 按钮触发模态框 -->
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
                            <div id="staModalContent" style="width: 600px;height:400px;"></div>
                            <%--                            <div class="row">--%>
                            <%--                                <input class="col-xs-5" type="date" id="createTimeFromSelect">--%>
                            <%--                                <div class="col-xs-2">至</div>--%>
                            <%--                                <input class="col-xs-5" type="date" id="createTimeToSelect">--%>
                            <%--                            </div>--%>
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
                            <h4 class="modal-title" id="updateModalLabel">修改信息</h4>
                        </div>
                        <div class="modal-body">
                            <div class="row">
                                <div class="col-sm-12">
                                    <nobr>唯一用户标识</nobr>
                                    <input class="input-xxlarge" type="text" id="openIdUpdate">
                                </div>
                                <div class="col-sm-12">
                                    <nobr>公众账号ID</nobr>
                                    <input class="input-xxlarge" type="text" id="appIdUpdate">
                                </div>
                                <div class="col-sm-12">
                                    <nobr>商户号</nobr>
                                    <input class="input-xxlarge" type="text" id="mchIdUpdate">
                                </div>
                                <div class="col-sm-12">
                                    <nobr>随机字符串</nobr>
                                    <input class="input-xxlarge" type="text" id="nonceStrUpdate">
                                </div>
                                <div class="col-sm-12">
                                    <nobr>商品描述</nobr>
                                    <input class="input-xxlarge" type="text" id="bodyUpdate">
                                </div>
                                <div class="col-sm-12">
                                    <nobr>商户订单号</nobr>
                                    <input class="input-xxlarge" type="text" id="outTradeNoUpdate">
                                </div>
                                <div class="col-sm-12">
                                    <nobr>标价金额</nobr>
                                    <input class="input-xxlarge" type="text" id="totalFeeUpdate">
                                </div>
                                <div class="col-sm-12">
                                    <nobr>终端IP</nobr>
                                    <input class="input-xxlarge" type="text" id="spbillCreateIpUpdate">
                                </div>
                                <div class="col-sm-12">
                                    <nobr>通知地址</nobr>
                                    <input class="input-xxlarge" type="text" id="notifyUrlUpdate"></div>
                                <div class="col-sm-12">
                                    <nobr>交易类型</nobr>
                                    <input class="input-xxlarge" type="text" id="tradeTypeUpdate"></div>
                                <div class="col-sm-12">
                                    <nobr>返回状态码</nobr>
                                    <input class="input-xxlarge" type="text" id="returnCodeUpdate"></div>
                                <div class="col-sm-12">
                                    <nobr>返回信息</nobr>
                                    <input class="input-xxlarge" type="text" id="resultCodeUpdate"></div>
                                <div class="col-sm-12">
                                    <nobr>预支付ID</nobr>
                                    <input class="input-xxlarge" type="text" id="prepayIdUpdate"></div>
                                <div class="col-sm-12">
                                    <nobr>签名类型</nobr>
                                    <input class="input-xxlarge" type="text" id="signTypeUpdate"></div>
                                <div class="col-sm-12">
                                    <nobr>时间戳</nobr>
                                    <input class="input-xxlarge" type="text" id="timeStampUpdate"></div>
                                <div class="col-sm-12">
                                    <nobr>支付签名</nobr>
                                    <input class="input-xxlarge" type="text" id="paySignUpdate"></div>
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
        var staMap = new Map();//存放 日期-记录数 的键值对
        var pageSize = $("#pageSize").val();
        var pageNum = 1;

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

        $.getTableData = function () {
            if (
                inputCheck($("#openIdSelect").val()) &&
                inputCheckNumber($("#mchIdSelect").val()) &&
                inputCheck($("#bodySelect").val()) &&
                inputCheck($("#outTradeNoSelect").val()) &&
                inputCheckNumber($("#totalFeeSelect").val()) &&
                inputCheck($("#tradeTypeSelect").val())
            ) {
                $.post("${pageContext.request.contextPath}/insuranceWxpay/selectLike",
                    {
                        pageNum: pageNum,
                        pageSize: pageSize,
                        openId: $("#openIdSelect").val(),
                        mchId: $("#mchIdSelect").val(),
                        // nonceStr: $("#nonceStrSelect").val(),
                        body: $("#bodySelect").val(),
                        outTradeNo: $("#outTradeNoSelect").val(),
                        totalFee: $("#totalFeeSelect").val(),
                        // spbillCreateIp: $("#spbillCreateIpSelect").val(),
                        // notifyUrl: $("#notifyUrlSelect").val(),
                        tradeType: $("#tradeTypeSelect").val(),
                        // returnCode: $("#returnCodeSelect").val(),
                        // resultCode: $("#resultCodeSelect").val(),
                        // prepayId: $("#prepayIdSelect").val(),
                        // signType: $("#signTypeSelect").val(),
                        // timeStamp: $("#timeStampSelect").val(),
                        // paySign: $("#paySignSelect").val(),
                        unifiedorderSucceed: $("#unifiedorderSucceedSelect").val(),
                        paySucceed: $("#paySucceedSelect").val(),
                        createTimeFrom: $("#createTimeFromSelect").val(),
                        createTimeTo: $("#createTimeToSelect").val(),
                        payTimeFrom: $("#payTimeFromSelect").val(),
                        payTimeTo: $("#payTimeToSelect").val(),
                        unifiedorderTimeFrom: $("#unifiedorderTimeFromSelect").val(),
                        unifiedorderTimeTo: $("#unifiedorderTimeToSelect").val(),
                        orderByOne: $("#orderByOne").val(),
                        orderByTwo: $("#orderByTwo").val(),
                        orderByThree: $("#orderByThree").val()
                    },
                    function (data, status) {
                        $("tbody").empty();
                        console.info(JSON.stringify(data));
                        $.appendPageInfo(data);
                        data = data.list;
                        staMap.clear();
                        $.setStaMap(data);
                        $.appendTable(data);
                    }
                );
            }
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
                $("tbody tr:last-child").append("<td><textarea rows=\"3\" cols=\"10\" disabled=\"true\">" + data[i].openId + "</textarea></td>");

                // $("tbody tr:last-child").append("<td><textarea rows=\"3\" cols=\"10\" disabled=\"true\">" + data[i].appId + "</textarea></td>");

                $("tbody tr:last-child").append("<td>" + data[i].mchId + "</td>");
                // $("tbody tr:last-child").append("<td><textarea rows=\"3\" cols=\"15\" disabled=\"true\">" + data[i].nonceStr + "</textarea></td>");

                $("tbody tr:last-child").append("<td>" + data[i].body + "</td>");
                $("tbody tr:last-child").append("<td><textarea rows=\"3\" cols=\"15\" disabled=\"true\">" + data[i].outTradeNo + "</textarea></td>");

                $("tbody tr:last-child").append("<td>" + data[i].totalFee + "</td>");

                // $("tbody tr:last-child").append("<td>" + data[i].spbillCreateIp + "</td>");
                // $("tbody tr:last-child").append("<td><textarea rows=\"3\" cols=\"10\" disabled=\"true\">" + data[i].notifyUrl + "</textarea></td>");

                $("tbody tr:last-child").append("<td>" + data[i].tradeType + "</td>");
                // $("tbody tr:last-child").append("<td>" + data[i].returnCode + "</td>");
                // $("tbody tr:last-child").append("<td>" + data[i].resultCode + "</td>");
                // $("tbody tr:last-child").append("<td><textarea rows=\"3\" cols=\"15\" disabled=\"true\">" + data[i].prepayId + "</textarea></td>");

                // $("tbody tr:last-child").append("<td>" + data[i].signType + "</td>");
                // $("tbody tr:last-child").append("<td>" + data[i].timeStamp + "</td>");
                // $("tbody tr:last-child").append("<td><textarea rows=\"3\" cols=\"15\" disabled=\"true\">" + data[i].paySign + "</textarea></td>");

                if (data[i].unifiedorderSucceed == true)
                    $("tbody tr:last-child").append("<td class=\"hidden-480\"><span class=\"label label-sm label-primary\">下单成功</span></td>");
                else
                    $("tbody tr:last-child").append("<td class=\"hidden-480\"> <span class=\"label label-sm label-danger\">下单失败</span></td>");

                if (data[i].paySucceed == true)
                    $("tbody tr:last-child").append("<td class=\"hidden-480\"><span class=\"label label-sm label-primary\">支付成功</span></td>");
                else
                    $("tbody tr:last-child").append("<td class=\"hidden-480\"> <span class=\"label label-sm label-danger\">支付失败</span></td>");

                $("tbody tr:last-child").append("<td>" + data[i].unifiedorderTime.year + "-" + data[i].unifiedorderTime.monthValue + "-" + data[i].unifiedorderTime.dayOfMonth + "</td>");
                if (data[i].payTime != null)
                    $("tbody tr:last-child").append("<td>" + data[i].payTime.year + "-" + data[i].payTime.monthValue + "-" + data[i].payTime.dayOfMonth + "</td>");
                else $("tbody tr:last-child").append("<td></td>");
                $("tbody tr:last-child").append("<td>" + data[i].createTime.year + "-" + data[i].createTime.monthValue + "-" + data[i].createTime.dayOfMonth + "</td>");
                // $("tbody tr:last-child").append("<td></td>");
                $("tbody tr:last-child").append("\n" +
                    "                                    <td  class=\"no-print\"><a class=\"tooltip-success updateById\" data-rel=\"tooltip\"\n" +
                    "                               id=\"updateById?id=" + data[i].id + "\"" +
                    " data-toggle=\"modal\"\n" +
                    "                               data-target=\"#updateModal\"\n" +
                    "                               data-original-title=\"修改\">\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"green\">\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"icon-edit bigger-120\"></i>\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\n" +
                    "                            </a>" +
                    //     "                            <a class=\"tooltip-error deleteById\" data-rel=\"tooltip\"\n" +
                    //     "                               id=\"deleteById?id=" + data[i].id + "\"" +
                    //     "                               data-original-title=\"删除\">\n" +
                    //     "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"red\">\n" +
                    //     "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"icon-trash bigger-120\"></i>\n" +
                    //     "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\n" +
                    // "                            </a>" +
                    "</td>");
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
        $.getTableData();
///////////////////////////////页标操作结束///////////////////////////////

        $(document).on("click", ".updateById", function () {
            // 动作触发后执行的代码!!
            id = $(this).attr("id").split("?")[1].split("=")[1];
            console.info("id in updateById is " + id);
            $.get("${pageContext.request.contextPath}/insuranceWxpay/selectById?id=" + id, function (data, status) {
                $("#openIdUpdate").val(data.openId);
                $("#appIdUpdate").val(data.appId);
                $("#mchIdUpdate").val(data.mchId);
                $("#nonceStrUpdate").val(data.nonceStr);
                $("#bodyUpdate").val(data.body);
                $("#outTradeNoUpdate").val(data.outTradeNo);
                $("#totalFeeUpdate").val(data.totalFee);
                $("#spbillCreateIpUpdate").val(data.spbillCreateIp);
                $("#notifyUrlUpdate").val(data.notifyUrl);
                $("#tradeTypeUpdate").val(data.tradeType);
                $("#returnCodeUpdate").val(data.returnCode);
                $("#resultCodeUpdate").val(data.resultCode);
                $("#prepayIdUpdate").val(data.prepayId);
                $("#signTypeUpdate").val(data.signType);
                $("#timeStampUpdate").val(data.timeStamp);
                $("#paySignUpdate").val(data.paySign)
            });
        });
        <%--$(document).on("click", "#submitUpdate", function () {--%>
        <%--    console.info("id selected to update is " + id);--%>
        <%--    $.post("${pageContext.request.contextPath}/insuranceWxpay/updateAjax",--%>
        <%--        {--%>
        <%--            id: id,--%>
        <%--            openId: $("#openIdUpdate").val(),--%>
        <%--            appId: $("#appIdUpdate").val(),--%>
        <%--            mchId: $("#mchIdUpdate").val(),--%>
        <%--            nonceStr: $("#nonceStrUpdate").val(),--%>
        <%--            body: $("#bodyUpdate").val(),--%>
        <%--            utTradeNo: $("#outTradeNoUpdate").val(),--%>
        <%--            totalFee: $("#totalFeeUpdate").val(),--%>
        <%--            spbillCreateIp: $("#spbillCreateIpUpdate").val(),--%>
        <%--            notifyUrl: $("#notifyUrlUpdate").val(),--%>
        <%--            tradeType: $("#tradeTypeUpdate").val(),--%>
        <%--            returnCode: $("#returnCodeUpdate").val(),--%>
        <%--            resultCode: $("#resultCodeUpdate").val(),--%>
        <%--            prepayId: $("#prepayIdUpdate").val(),--%>
        <%--            signType: $("#signTypeUpdate").val(),--%>
        <%--            timeStamp: $("#timeStampUpdate").val(),--%>
        <%--            paySign: $("#paySignUpdate").val()--%>
        <%--        },--%>
        <%--        function (data, status) {--%>
        <%--            if (data == true) {--%>
        <%--                alert("更改成功");--%>
        <%--                location.reload();--%>
        <%--            } else--%>
        <%--                alert("更改失败");--%>
        <%--            $('#updateModal').modal('hide');--%>
        <%--        }--%>
        <%--    );--%>
        <%--});--%>
        $(document).on("click", ".deleteById", function () {
            id = $(this).attr("id").split("?")[1].split("=")[1];
            if (confirm("确认要删除吗？")) {
                console.info("id selected is " + id);
                $.post("${pageContext.request.contextPath}/insuranceWxpay/deleteById",
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
            window.location.href = "${pageContext.request.contextPath}/insuranceWxpay/exportData?"
                + "pageNum=" + pageNum + "&"
                + "pageSize=" + pageSize + "&"
                + "openId=" + $("#openIdSelect").val() + "&"
                + "appId=" + $("#appIdSelect").val() + "&"
                + "mchId=" + $("#mchIdSelect").val() + "&"
                + "nonceStr=" + $("#nonceStrSelect").val() + "&"
                + "body=" + $("#bodySelect").val() + "&"
                + "outTradeNo=" + $("#outTradeNoSelect").val() + "&"
                + "totalFee=" + $("#totalFeeSelect").val() + "&"
                + "spbillCreateIp=" + $("#spbillCreateIpSelect").val() + "&"
                + "notifyUrl=" + $("#notifyUrlSelect").val() + "&"
                + "tradeType=" + $("#tradeTypeSelect").val() + "&"
                + "returnCode=" + $("#returnCodeSelect").val() + "&"
                + "resultCode=" + $("#resultCodeSelect").val() + "&"
                + "prepayId=" + $("#prepayIdSelect").val() + "&"
                + "signType=" + $("#signTypeSelect").val() + "&"
                + "timeStamp=" + $("#timeStampSelect").val() + "&"
                + "paySign=" + $("#paySignSelect").val();
            // + "pageNum=" + pageNum + "&"
            // + "pageSize=" + pageSize + "&"
            // + "userName=" + $("#userNameSelect").val() + "&"
            // + "password=" + $("#passwordSelect").val() + "&"
            // + "phoneNumber=" + $("#phoneNumberSelect").val() + "&"
            // + "userRole=" + $("#userRoleSelect").val() + "&"
            // + "userRealName=" + $("#userRealNameSelect").val() + "&"
            // + "userAge=" + $("#userAgeSelect").val() + "&"
            // + "userSex=" + $("#userSexSelect").val();
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
        $(document).on("click", "#openStaModal", function () {
            // $.getAllData();
            var myChart = echarts.init(document.getElementById('staModalContent'));
            //遍历map并取key 和 value
            let dateStrs = new Array();//存放日期字符串的数组
            let dateNum = new Array();//存放个数的数组
            for (key of staMap.keys()) {
                dateStrs.push(key); // map.get(key)可得value值。
            }
            dateStrs.sort();
            dateStrs.forEach(function (item, idnex, array) {
                console.log(item)     // 1 2 3 4 5 6
                // console.log(array)    // [1, 2, 3, 4, 5, 6]
                dateNum.push(staMap.get(item));
            })
            console.info("dateStrs is " + dateStrs);
            console.info("dateNum is " + dateNum);
            var option = {
                //标题
                title: {
                    text: '下单支付情况'
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
                    data: ['下单总数']
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
                    name: '当日下单数',
                    type: 'line',
                    data: dateNum
                    // data: [40, 20, 35, 60, 55, 10]//data是数组
                }]
            };
            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
        });
    });
</script>
</body>
</html>