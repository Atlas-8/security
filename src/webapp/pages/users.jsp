<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>
        Users list
    </title>
</head>
<body>
<table border="2">

    <caption align="center">
        <h3>Users list</h3>
    </caption>

    <tr>
        <td bgcolor="gray">ID</td>
        <td bgcolor="gray">Name</td>
        <td bgcolor="gray">Adress</td>
        <td bgcolor="gray">Email</td>
    </tr>

    <c:forEach var="user" items="${users}">

        <tr>
            <td>${user.getId()}</td>
            <td>${user.getName()}</td>
            <td>${user.getAdress()}</td>
            <td>${user.getEmail()}</td>

        </tr>

    </c:forEach>
</table>
</body>
</html>