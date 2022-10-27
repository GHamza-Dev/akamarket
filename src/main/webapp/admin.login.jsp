<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Admin login</title>
</head>
<body>
<h1><%= "Admin login" %></h1>

<form action="admin/login" method="post">
  <input name="email" type="email" placeholder="Enter you email...">
  <input name="password" type="password" placeholder="Enter your password...">
  <input hidden name="role" type="radio" value="admin">
  <button>Submit</button>
</form>

<br/>
<a href="admin/hello-servlet">admin/hello-servlet [ADMIN]</a><br>
<a href="market-admin/market-admin-servlet">market-admin/market-admin-servlet [MARKET ADMIN]</a><br>
<a href="dept-admin/dept-manager-servlet">dept-admin/dept-manager-servlet [DEPT MANAGER SERVLET]</a>
</body>
</html>