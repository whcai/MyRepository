<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<base href=request.getScheme()+"://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/">
</head>
<body>
	<jsp:forward page="admin/login"></jsp:forward>
</body>
</html>