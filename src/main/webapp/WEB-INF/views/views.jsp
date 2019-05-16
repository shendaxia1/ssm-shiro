<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
 <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
  <!-- 引入EasyUI -->
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
  <!-- 引入EasyUI的中文国际化js，让EasyUI支持中文 -->
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/locale/easyui-lang-zh_CN.js"></script>
  <!-- 引入EasyUI的样式文件-->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/js/themes/default/easyui.css" type="text/css"/>
  <!-- 引入EasyUI的图标样式文件-->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/js/themes/icon.css" type="text/css"/>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <form action="${pageContext.request.contextPath}/tuiguang/upLoad" method="post" enctype="multipart/form-data">
<!-- 选择你要上传的文件： <input name="file" type="file"> -->
		<div style="margin-bottom:20px">
			<div>File1:</div>
			<input class="easyui-filebox" name="file" data-options="prompt:'请选择文件'" style="width:15%">
		</div>
<input type="submit">
</form> --%>
<form action="${pageContext.request.contextPath}/tuiguang/conFind" method="post">
账户：<input name="pa_name" type="text">
<!-- 开始日期：<input name="begin_time" type="text">
截止日期：<input name="end_time" type="text"> -->
推广计划：<input name="pa_plan" type="text">
登陆名：<input name="pa_login" type="text">
微信：<input name="pa_wx" type="text">
<input type="submit">
</form>
<table>
<div>
<tr>
	<th>账户</th>
	<th>日期</th>
	<th>推广计划</th>
	<th>展现</th>
	<th>点击</th>
	<th>消费</th>
	<th>平均点击价格</th>
	<th>点击率</th>
	<th>登录名</th>
	<th>微信</th>
	
</tr>
	<c:forEach items="${pageUtile.list}" var="list1">
	<tr>
		<th>${list1.pa_name}</th>
		<th><fmt:formatDate value="${list1.pa_data }" type="date" pattern="yyyy-MM-dd HH:mm:ss"/></th>
		<th>${list1.pa_plan}</th>
		<th>${list1.pa_show}</th>
		<th>${list1.pa_click}</th>
		<th>${list1.pa_payamount}</th>
		<th>${list1.pa_avage}</th>
		<th>${list1.pa_click_rate}</th>
		<th>${list1.pa_login}</th>
		<th>${list1.pa_wx}</th>
	</tr>
	
	</c:forEach>

</div>

</table>
 <div class='page all'>
            <b>共${pageUtile.pageNumber}</b>条,当前第<span>${pageUtile.pageIndex}</span>页
               <a href="${pageContext.request.contextPath}/tuiguang/conFind" class='first'>首页</a> 
                <a href="${pageContext.request.contextPath}/tuiguang/conFind?pageIndex=${pageUtile.pageIndex>1?pageUtile.pageIndex-1:1}" class='pre'>上一页</a>
                <c:forEach begin="1" end="${pageUtile.pageCount}" var="i">  
                <a href="${pageContext.request.contextPath}/tuiguang/conFind?pageIndex=${i}" style="text-decoration: none;">${i}</a>
                </c:forEach>
                    <a href="${pageContext.request.contextPath}/tuiguang/conFind?pageIndex=${pageUtile.pageIndex<pageUtile.pageCount?pageUtile.pageIndex+1:pageUtile.pageCount}" class='next'>下一页</a>
                <a href="${pageContext.request.contextPath}/tuiguang/conFind?pageIndex=${pageUtile.pageCount}" class='last'>末页</a>
        </div> 
</body>
</html>