<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<h2><a href="helloworld">Hello World!</a></h2>

<a href="helloworld1/1">pathvariable</a>

<a href="helloworld2?username=huanfion&age=28">RequestParam</a>
<form action="/springmvc/testpojo" method="post">
    username: <input type="text" name="username"><br>
    password: <input type="password" name="password"><br>
    email: <input type="text" name="email"><br>
    age: <input type="text" name="age"><br>
    city: <input type="text" name="address.city"><br>
    province: <input type="text" name="address.province"><br>
    <input type="submit" value="submit">
</form><br/><br/>

<a href="emps">员工列表</a>
</body>
</html>
