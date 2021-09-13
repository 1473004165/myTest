<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script>
        window.onload = function () {
            const checkbox = document.getElementById("checkbox");
            checkbox.onclick = function () {
                const checked = document.getElementsByClassName("check_box");
                for(let i = 0; i<checked.length; i++){
                    checked[i].checked = checkbox.checked;
                }
            };
        };

    </script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
        #button_float{
            float: right;
            margin: 5px;
        }
        #input_float{
            float: left;
            margin-top: 5px;
            margin-bottom: 5px;
            margin-right: 5px;
        }
        #tag{
            font-size: 25px;
            margin-left: 5px;
        }
    </style>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>
    <div id="input_float">
        <form class="form-inline" action="${pageContext.request.contextPath}/findUserByPageServlet" method="post">
            <div class="form-group">
                <label for="exampleInputName2">姓名</label>
                <input type="text" class="form-control" id="exampleInputName2" name="name" value="${requestScope.condition.name[0]}">
            </div>
            <div class="form-group">
                <label for="exampleInputName3">籍贯</label>
                <input type="text" class="form-control" id="exampleInputName3" name="address" value="${requestScope.condition.address[0]}">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail2">邮箱</label>
                <input type="email" class="form-control" id="exampleInputEmail2" name="email" value="${requestScope.condition.email[0]}">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>
    <div id="button_float">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加信息</a>
        <a class="btn btn-primary" href="javascript:void(0);" onclick="deleteUsers()">删除选中</a>
    </div>
    <form action="${pageContext.request.contextPath}/delUserServlet?rows=5&currentPage=1" method="post" id="form">
        <table style="border: 1px" class="table table-bordered table-hover">
            <tr class="success">
                <th>
                    <label>
                        <input type="checkbox" id="checkbox">
                    </label>
                </th>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>籍贯</th>
                <th>QQ</th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${requestScope.pageBean.list}" var="userBean" varStatus="s">
                <tr>
                    <td><label>
                        <input type="checkbox" class="check_box" name="id" value="${userBean.id}">
                    </label></td>
                    <td>${s.count}</td>
                    <td>${userBean.name}</td>
                    <td>${userBean.gender}</td>
                    <td>${userBean.age}</td>
                    <td>${userBean.address}</td>
                    <td>${userBean.qq}</td>
                    <td>${userBean.email}</td>
                    <td>
                        <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/findUserServlet?id=${userBean.id}">修改</a>&nbsp;
                        <a class="btn btn-default btn-sm" href = "javascript:deleteUser(${userBean.id});">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>
    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <c:if test="${requestScope.pageBean.currentPage==1}">
                    <li class="disabled">
                        <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${requestScope.pageBean.currentPage}&rows=5&name=${requestScope.condition.name[0]}&address=${requestScope.condition.address[0]}&email=${requestScope.condition.email[0]}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:if test="${requestScope.pageBean.currentPage!=1}">
                    <li>
                        <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${requestScope.pageBean.currentPage-1}&rows=5&name=${requestScope.condition.name[0]}&address=${requestScope.condition.address[0]}&email=${requestScope.condition.email[0]}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>

                <c:forEach begin="1" end="${requestScope.pageBean.totalPage}" var="i">
                    <c:if test="${i == requestScope.pageBean.currentPage}">
                        <li class="active"><a href="">${i}</a></li>
                    </c:if>
                    <c:if test="${i != requestScope.pageBean.currentPage}">
                        <li><a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${i}&rows=5&name=${requestScope.condition.name[0]}&address=${requestScope.condition.address[0]}&email=${requestScope.condition.email[0]}">${i}</a></li>
                    </c:if>
                </c:forEach>
                <c:if test="${requestScope.pageBean.currentPage==requestScope.pageBean.totalPage}">
                    <li class="disabled">
                        <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${requestScope.pageBean.currentPage}&rows=5&name=${requestScope.condition.name[0]}&address=${requestScope.condition.address[0]}&email=${requestScope.condition.email[0]}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>.
                        </a>
                    </li>
                </c:if>
                <c:if test="${requestScope.pageBean.currentPage!=requestScope.pageBean.totalPage}">
                    <li>
                        <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${requestScope.pageBean.currentPage+1}&rows=5&name=${requestScope.condition.name[0]}&address=${requestScope.condition.address[0]}&email=${requestScope.condition.email[0]}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>.
                        </a>
                    </li>
                </c:if>
                <span id="tag">共${requestScope.pageBean.totalCount}条记录，共${requestScope.pageBean.totalPage}页</span>
            </ul>
        </nav>
    </div>
</div>
<script>
    function deleteUser(id) {
        if(confirm("警告：此操作会删除本条记录，确定要执行吗？")){
            location.href = "${pageContext.request.contextPath}/delUserServlet?id="+id;
        }
    }
    function deleteUsers() {
        if(confirm("警告：此操作会删除所有选中记录，确定要执行吗？")){
            const form = document.getElementById("form");
            form.submit();
        }
    }
</script>
</body>
</html>