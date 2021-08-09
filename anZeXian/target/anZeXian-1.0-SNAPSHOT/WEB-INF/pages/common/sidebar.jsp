<%--
  Created by IntelliJ IDEA.
  User: 24852
  Date: 2021/3/13
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<a class="menu-toggler" id="menu-toggler" href="#">
    <span class="menu-text"></span>
</a>
<div class="sidebar" id="sidebar">
    <script type="text/javascript">
        try {
            ace.settings.check('sidebar', 'fixed')
        } catch (e) {
        }
    </script>
    <ul class="nav nav-list">
        <li class="sidebar-li" id="user_my">
            <a href="#">
                <i class="icon-dashboard"></i>
                <span class="menu-text"> 个人中心 </span>
            </a>
        </li>
        <c:if test="${sessionScope.curUser.userRole==0 ||sessionScope.curUser.userRole==1}">
          <li class="sidebar-li" id="insurance_claim">
                <a href="#">
                    <i class="icon-dashboard"></i>
                    <span class="menu-text"> 理赔业务 </span>
                </a>
            </li>
            <li class="sidebar-li" id="order_business">
                <a href="#">
                    <i class="icon-dashboard"></i>
                    <span class="menu-text"> 订单业务 </span>
                </a>
            </li>
        </c:if>
        <%--        <c:if test="${ sessionScope.curUser.userName=='shen' }"> --%>
        <%--        <p>沈警官 <p>--%>
        <%--        </c:if>--%>
        <c:if test="${sessionScope.curUser.userRole==-1}">
            <li class="sidebar-li" id="user">
                <a href="#">
                    <i class="icon-dashboard"></i>
                    <span class="menu-text"> 用户管理 </span>
                </a>
            </li>
        </c:if>

        <%--        <li class="sidebar-li" id="insurance">--%>
        <%--            <a href="#">--%>
        <%--                <i class="icon-dashboard"></i>--%>
        <%--                <span class="menu-text">  </span>--%>
        <%--            </a>--%>
        <%--        </li>--%>
        <li>
            <a href="#" class="dropdown-toggle">
                <i class="icon-list"></i>
                <span class="menu-text"> 保险管理 </span>

                <b class="arrow icon-angle-down"></b>
            </a>
            <ul class="submenu">
                <li id="insurance_order">
                    <a href="#">
                        <i class="icon-double-angle-right"></i>
                        订单管理
                    </a>
                </li>
                <li id="insurance_wxpay">
                    <a href="#">
                        <i class="icon-double-angle-right"></i>
                        支付管理
                    </a>
                </li>
                <li id="insurance_service">
                    <a href="#">
                        <i class="icon-double-angle-right"></i>
                        套餐管理
                    </a>
                </li>
                <li id="insurance_news">
                    <a href="#">
                        <i class="icon-double-angle-right"></i>
                        新闻管理
                    </a>
                </li>
            </ul>
        </li>

    </ul><!-- /.nav-list -->

<%--    <div class="sidebar-collapse" id="sidebar-collapse">--%>
<%--        <i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>--%>
<%--    </div>--%>

    <script type="text/javascript">
        try {
            ace.settings.check('sidebar', 'collapsed')
        } catch (e) {
        }
    </script>
</div>
<%--<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>--%>

<!-- <![endif]-->

<!--[if IE]>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>-->


<!--[if !IE]> -->

<%--<script type="text/javascript">--%>
<%--    window.jQuery || document.write("<script src='${pageContext.request.contextPath}/static/assets/js/jquery-2.0.3.min.js'>" + "<" + "/script>");--%>
<%--</script>--%>

<%--<!-- <![endif]-->--%>

<%--<!--[if IE]>--%>
<%--<script type="text/javascript">--%>
<%--    window.jQuery || document.write("<script src='${pageContext.request.contextPath}/static/assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");--%>
<%--</script>--%>
<%--<![endif]-->--%>

<%--<script type="text/javascript">--%>
<%--    if ("ontouchend" in document) document.write("<script src='${pageContext.request.contextPath}/static/assets/js/jquery.mobile.custom.min.js'>" + "<" + "/script>");--%>
<%--</script>--%>
<%--<script src="${pageContext.request.contextPath}/static/assets/js/bootstrap.min.js"></script>--%>
<%--<script src="${pageContext.request.contextPath}/static/assets/js/typeahead-bs2.min.js"></script>--%>

<%--<!-- page specific plugin scripts -->--%>

<%--<script src="${pageContext.request.contextPath}/static/assets/js/jquery.dataTables.min.js"></script>--%>
<%--<script src="${pageContext.request.contextPath}/static/assets/js/jquery.dataTables.bootstrap.js"></script>--%>

<%--<!-- ace scripts -->--%>

<%--<script src="${pageContext.request.contextPath}/static/assets/js/ace-elements.min.js"></script>--%>
<%--<script src="${pageContext.request.contextPath}/static/assets/js/ace.min.js"></script>--%>

<%--<!-- inline scripts related to this page -->--%>

<%--<script type="text/javascript">--%>
<%--    jQuery(function ($) {--%>
<%--        var oTable1 = $('#sample-table-2').dataTable({--%>
<%--            "aoColumns": [--%>
<%--                {"bSortable": false},--%>
<%--                null, null, null, null, null,--%>
<%--                {"bSortable": false}--%>
<%--            ]--%>
<%--        });--%>


<%--        $('table th input:checkbox').on('click', function () {--%>
<%--            var that = this;--%>
<%--            $(this).closest('table').find('tr > td:first-child input:checkbox')--%>
<%--                .each(function () {--%>
<%--                    this.checked = that.checked;--%>
<%--                    $(this).closest('tr').toggleClass('selected');--%>
<%--                });--%>

<%--        });--%>


<%--        $('[data-rel="tooltip"]').tooltip({placement: tooltip_placement});--%>

<%--        function tooltip_placement(context, source) {--%>
<%--            var $source = $(source);--%>
<%--            var $parent = $source.closest('table')--%>
<%--            var off1 = $parent.offset();--%>
<%--            var w1 = $parent.width();--%>
<%--            var off2 = $source.offset();--%>
<%--            var w2 = $source.width();--%>
<%--            if (parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2)) return 'right';--%>
<%--            return 'left';--%>
<%--        }--%>
<%--    })--%>
<%--</script>--%>
<%--<div style="display:none">--%>
<%--    <script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script>--%>
<%--</div>--%>
<script type="text/javascript">
    window.jQuery || document.write("<script src='${pageContext.request.contextPath}/static/assets/js/jquery-2.0.3.min.js'>" + "<" + "/script>");
</script>
<script type="text/javascript">
    $(function () {
        // $(document).on("click", ".sidebar-li", function () {
        //     $(".sidebar-li").removeClass("active");
        //     $(this).addClass("active");
        // });

        $(document).on("click", "#user_my", function () {
            window.location.href = "${pageContext.request.contextPath}/user/toUserMy";
        });
        $(document).on("click", "#user", function () {
            window.location.href = "${pageContext.request.contextPath}/user/toUserList";
        });
        $(document).on("click", "#insurance_order", function () {
            window.location.href = "${pageContext.request.contextPath}/insuranceOrder/toOrderList";
        });
        $(document).on("click", "#insurance_applicant", function () {
            window.location.href = "${pageContext.request.contextPath}/insuranceApplicant/toApplicantList";
        });
        $(document).on("click", "#insurance_insured", function () {
            window.location.href = "${pageContext.request.contextPath}/insuranceInsured/toInsuredList";
        });
        $(document).on("click", "#insurance_service", function () {
            window.location.href = "${pageContext.request.contextPath}/insuranceService/toServiceList";
        });
        $(document).on("click", "#insurance_wxpay", function () {
            window.location.href = "${pageContext.request.contextPath}/insuranceWxpay/toWxpayList";
        });
        $(document).on("click", "#insurance_news", function () {
            window.location.href = "${pageContext.request.contextPath}/insuranceNews/toNewsList";
        });
        $(document).on("click", "#insurance_claim", function () {
            window.location.href = "${pageContext.request.contextPath}/insuranceClaim/toClaimBusiness";
        });
        $(document).on("click", "#order_business", function () {
            window.location.href = "${pageContext.request.contextPath}/insuranceOrder/toOrderBusiness";
        });
    });
</script>
</body>
</html>
