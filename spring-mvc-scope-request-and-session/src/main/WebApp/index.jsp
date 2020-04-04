<%--
  Created by IntelliJ IDEA.
  User: komp
  Date: 2020-04-04
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
</head>
<body>
    <h3>Test działania odczytu czasu w konsoli, oraz symulatora koszyka z zakupami</h3>
    <h4><a href="time">Wyswietl czas w konsoli</a></h4> <br/>
    <h2>***** Koszyk zakupowy ******</h2>
    <form action="add" method="post">
        <input name="product" type="text">
        <input value="Dodaj produkt" type="submit"><br/>
    </form>

    <h4><a href="print">Wydrukuj liste zakupow w konsoli</a></h4>
</body>
</html>
