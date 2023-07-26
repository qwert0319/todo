<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> 
<title>할일관리</title>
</head>
<body>
	<h1>로그인</h1>
	<form action="/auth-task" method="post">
		<input type="text" name="id" /> <input type="password" name="pass" />
		<button>로그인</button>
	</form>
</body>
</html>