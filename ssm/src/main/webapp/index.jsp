<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>测试</h1>
    <a href="account/findAll">查询所有</a>
    <br/>
    <form method="post" action="account/insert">
        <span>用户名:</span>
        <label>
            <input type="text" name="name">
        </label>
        <span>金额:</span>
        <label>
            <input type="text" name="money">
        </label>
        <input type="submit" value="存储">
    </form>
</body>
</html>
