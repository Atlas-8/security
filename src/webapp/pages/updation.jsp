<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Update user</title>
</head>
<body>

<br/>
<form action="/updateUser" method="post">
    <table>
        <caption>
            Редактировать данные пользователя ${param.name} (id: ${param.id})
            <br><br>
        </caption>
        <tr>
            <td>
                User id:
            </td>
            <td>
                <input type="text" name="id" value="${param.id}">
            </td>
        </tr>
        <tr>
            <td>
                User name:
            </td>
            <td>
                <input type="text" name="name" value="${param.name}">
            </td>
        </tr>
        <tr>
            <td>
                User adress:
            </td>
            <td>
                <input type="text" name="adress" value="${param.adress}">
            </td>
        </tr>
        <tr>
            <td>
                User email:
            </td>
            <td>
                <input type="text" name="email" value="${param.email}">
            </td>
        </tr>
        <tr>
            <td>
                <br><br>
                <input type="hidden" name="oldId" value="${param.id}">
            </td>
            <td align="right">
                <input type="submit" value="Обновить">
            </td>
        </tr>
    </table>
</form>

</body>
</html>