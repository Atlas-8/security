<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%request.setCharacterEncoding("UTF-8");%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>
        Users list
    </title>
</head>
<body>

<table border="2" hight="auto">

    <caption align="center">
        <h4>Users list</h4>
    </caption>

    <tr>
        <td bgcolor="gray">ID</td>
        <td bgcolor="gray">Name</td>
        <td bgcolor="gray">Adress</td>
        <td bgcolor="gray">Email</td>
        <td bgcolor="gray">Actions</td>
    </tr>

    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.getId()}</td>
            <td>${user.getName()}</td>
            <td>${user.getAdress()}</td>
            <td>${user.getEmail()}</td>

            <td  bgcolor="gray">
                <form action = "pages/updation.jsp" method="post">
                    <input type="hidden" name="id" value="${user.getId()}">
                    <input type="hidden" name="name" value="${user.getName()}">
                    <input type="hidden" name="adress" value="${user.getAdress()}">
                    <input type="hidden" name="email" value="${user.getEmail()}">
                    <input type="submit" value="Изменить" style="float:left; font-size:x-small">
                </form>
                <form action="/deleteUser" method="get">
                    <input type="hidden" name="id" value="${user.getId()}">
                    <input type="submit" value="Удалить" style="float:left; font-size:x-small">
                </form>
            </td>
        </tr>
    </c:forEach>

    <tr>
        <td bgcolor="gray" colspan="4"></td>
        <td bgcolor="gray"  align="center" valign="center" bgcolor="gray">
            <form action="pages/addition.jsp" method="get">
                <input type="submit" value="Add new user" style="float:left; font-size:x-small">
            </form>
        </td>
    </tr>

</table>
</body>
</html>