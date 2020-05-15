<%--
  Created by IntelliJ IDEA.
  User: zhqiran
  Date: 2020/5/15.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Index page</title>
  </head>
  <body>
  <form action="registerServlet" method="post">
    姓名：<input type="text" name="name"><br>
    年龄：<input type="text" name="age"><br>
    分数：<input type="text" name="score">
    <input type="submit" value="注册">
  </form>
  </body>
</html>
