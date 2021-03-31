<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>测试成功</h1>
    <c:forEach items="${requestScope.list}" var="account">
        ${account.name}
        ${account.money}
        <br/>
    </c:forEach>
</body>
</html>
