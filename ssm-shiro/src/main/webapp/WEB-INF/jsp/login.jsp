<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/easyui/themes/gray/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/easyui/themes/default/easyui.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/jquery.easyui.min.js"></script>
<style type="text/css">
	#loginForm tr{
		display: block;
		margin-top: 5px;
	}
</style>
</head>
<%
	String message = (String) request.getAttribute("message");
	if (message == null) {
		message = "";
	}
	if (!message.trim().equals("")) {
		out.println("<script language='javascript'>");
		out.println("alert('" + message + "')");
		out.println("</script>");
	}
	//request.removeAttribute("message");
%>
<body>
	<div id="login" class="easyui-window"
		style="padding-top: 30px;padding-left: 25px">
		<span style="margin-left: 55px;color: red;" id="showMsg"></span>
		<form id="loginForm" action="${pageContext.request.contextPath }/login/login.action"
			method="post">
			<table>
				<tr>
					<td>用户名</td>
					<td><input class="easyui-validatebox" id="username"
						name="username" type="text" /></td>
					<td></td>
				</tr>
				<tr>
					<td>密　码</td>
					<td><input class="easyui-validatebox" id="password"
						name="password" type="password"></td>
					<td></td>
				</tr>
			</table>
		</form>
	</div>
	<script type="text/javascript">
		$(function() {
			$("#login").dialog({
				title : '登录',
				backcolor:'#00f',
				iconCls : 'icon-lock',	
				width : '420',
				height : '230',
				closable : false,
				minimizable : false,
				maximizable : false,
				resizable : false,
				modal : true,
				buttons : [ {
					text : '登录',
					iconCls : 'icon-ok',
					handler:function(){
					doLogin();
					}
				} ]
			});
		});
		function doLogin(){
			if($("#username").val()==""){
		        $("#showMsg").html("用户名不能为空，请输入");
		        $("#username").focus();
	        } else if($("#password").val()=="") {
	        	$("#showMsg").html("密码不能为空，请输入");
		        $("#password").focus();
	        } else{
				$("#login").dialog("close");
				$("#loginForm").get(0).submit();
			}
		}
	</script>
</body>
</html>
