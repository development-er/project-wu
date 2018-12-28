<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/insertUserInformation">
		用户名<input type="text" name="userName" value="" />
		性别<input type="text" name="gender" value="" />
		id<input type="text" name="id" value="" />
		简介<input type="text" name="introduce" value="" />
		系部<input type="text" name="department" value="" />
		图片路径<input type="text" name="photoPath" value="" />
		电话<input type="text" name="phone" value="" />
		密&emsp;码<input type="password" name="password" value="" />
		<input type="submit" value="插入"/>
	</form>

</body>
</html>