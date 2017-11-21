<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<title>员工管理系统</title>
</head>
<frameset rows="80,*">
	<frame name="top" src="frame/top.jsp">
	<frameset cols="150,*" id="main">
		<frame src="frame/left.jsp">
		<frame name="right" src="frame/right.jsp">
	</frameset>
</frameset>
</html>