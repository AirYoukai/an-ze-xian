<%--
  Created by IntelliJ IDEA.
  User: 24852
  Date: 2021/4/30
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>支付结果页面</title>
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
<body>
<h1>支付成功</h1>
<button class="btn btn-app btn-warning">
    <a href="${pageContext.request.contextPath}/insuranceClaim/toClaimList">
        <i class="icon-undo bigger-230"></i>
        返回
    </a>
</button>
</body>
</html>
