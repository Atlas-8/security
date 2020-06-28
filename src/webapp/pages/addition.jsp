<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Adding user</title>
</head>
<body>
Adding new user<br><br>
<form action = "/saveUser" method="get">
    <input required type="text" name="name" placeholder="Name"><br><br>
    <input required type="text" name="adress" placeholder="Adress"><br><br>
    <input required type="text" name="email" placeholder="Email"><br><br>
    <input type="submit" value="Save user">
</form>
</body>
</html>