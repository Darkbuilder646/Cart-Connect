<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List of Users</title>
</head>
<body>
    <h1>List of Users in DB</h1>
    <ul th:each = "user : ${allUsers}">
        <li th:utext="${user.pseudo}">...</li>
        <li th:utext="${user.email}">...</li>
        <li th:utext="${user.password}">...</li>
    </ul>
</body>