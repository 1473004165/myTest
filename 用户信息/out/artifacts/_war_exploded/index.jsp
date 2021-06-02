<%--
      1. 需求：用户信息的增删改查操作
      2. 设计：
              1. 技术选型：Servlet+JSP+MySQL+JDBCTempleat+Duird+BeanUtilS+tomcat
              2. 数据库设计：
                    create database day17; -- 创建数据库
                    use day17;             -- 使用数据库
                    create table user(   -- 创建表
                        id int primary key auto_increment,
                        name varchar(20) not null,
                        gender varchar(5),
                        age int,
                        address varchar(32),
                        qq  varchar(20),
                        email varchar(50)
                    );

              3. 开发：
                  1. 环境搭建
                      1. 创建数据库环境
                      2. 创建项目，导入需要的jar包

                  2. 编码


              4. 测试
              5. 部署运维
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html lang="zh-CN">
<head>
  <meta charset="utf-8"/>
  <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
  <meta name="viewport" content="width=device-width, initial-scale=1"/>
  <title>首页</title>

  <!-- 1. 导入CSS的全局样式 -->
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
  <script src="js/jquery-2.1.0.min.js"></script>
  <!-- 3. 导入bootstrap的js文件 -->
  <script src="js/bootstrap.min.js"></script>
  <script type="text/javascript">
  </script>
</head>
<body>
<div style="text-align: center">

  <a
          href="${pageContext.request.contextPath}/login.jsp" style="text-decoration:none;font-size:33px">查询所有用户信息
  </a>
</div>
</body>
</html>
