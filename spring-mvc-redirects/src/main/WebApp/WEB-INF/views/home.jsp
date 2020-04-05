<%--
  Created by IntelliJ IDEA.
  User: komp
  Date: 2020-04-05
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h1>Event Registration</h1>
    <form action="register" method="post" >
        <input name="firstName" type="text"/>
        <input name="lastName" type="text"/>
        <input value="Register" type="submit"/>
    </form>

    <h3><a href="show">Print Participants</a></h3>
</body>
</html>
