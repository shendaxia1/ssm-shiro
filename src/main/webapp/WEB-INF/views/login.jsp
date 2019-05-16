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
<!-- <script type="text/javascript">
	function upload(){
        $.ajax({
            //几个参数需要注意一下
                type: "POST",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                url: "${pageContext.request.contextPath}/tuiguang/upLoad",//url
                data: $('#form1').serialize(),
                success: function (result) {
                    console.log(result);//打印服务端返回的数据(调试用)
                    if (result.resultCode == 200) {
                        alert("SUCCESS");
                    };
                },
                error : function() {
                    alert("异常！");
                }
            });
	}
</script> -->
</head>
<body>
<form id="form1"  action="${pageContext.request.contextPath}/tuiguang/upLoad" method="post" enctype="multipart/form-data">
<!-- 选择你要上传的文件： <input name="file" type="file"> -->
		<div style="margin-bottom:20px">
			<div>File1:</div>
			<input class="easyui-filebox" name="file" data-options="prompt:'请选择文件'" style="width:15%">
		</div>
<input type="button" value="上传" onclick="upload()">
</form>
<form action="${pageContext.request.contextPath}/tuiguang/conFind" method="post">
关键字：<input name="pa_name" type="text">
 开始日期：<input name="begin_time" type="text" value="2019-01-10 01:01:01">
截止日期：<input name="end_time" type="text" value="2019-01-10 01:01:01">
推广计划：<input name="pa_plan" type="text">
登陆名：<input name="pa_login" type="text" >
微信：<input name="pa_wx" type="text"> 
<input type="submit">
</form>
<div>
<table>
<thead>
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
</thead>
	<c:forEach items="${pageUtile.list}" var="list">
	<thead>
	<tr>
		<th>${list.pa_name}</th>
		<th><fmt:formatDate value="${list.pa_data }" type="date" pattern="yyyy-MM-dd HH:mm:ss"/></th>
		<th>${list.pa_plan}</th>
		<th>${list.pa_show}</th>
		<th>${list.pa_click}</th>
		<th>${list.pa_payamount}</th>
		<th>${list.pa_avage}</th>
		<th>${list.pa_click_rate}</th>
		<th>${list.pa_login}</th>
		<th>${list.pa_wx}</th>
	</tr>
	</thead>
	</c:forEach>



</table>
</div>
<div class='page all'>
            <b>共${pageUtile.pageNumber}</b>条,当前第<span>${pageUtile.pageIndex}</span>页
               <a href="${pageContext.request.contextPath}/tuiguang/findAll" class='first'>首页</a> 
                <a href="${pageContext.request.contextPath}/tuiguang/findAll?pageIndex=${pageUtile.pageIndex>1?pageUtile.pageIndex-1:1}" class='pre'>上一页</a>
                <c:forEach begin="1" end="${pageUtile.pageCount}" var="i">  
                <a href="${pageContext.request.contextPath}/tuiguang/findAll?pageIndex=${i}" style="text-decoration: none;">${i}</a>
                </c:forEach>
                    <a href="${pageContext.request.contextPath}/tuiguang/findAll?pageIndex=${pageUtile.pageIndex<pageUtile.pageCount?pageUtile.pageIndex+1:pageUtile.pageCount}" class='next'>下一页</a>
                <a href="${pageContext.request.contextPath}/tuiguang/findAll?pageIndex=${pageUtile.pageCount}" class='last'>末页</a>
        </div>
</body>
</html>