<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register to Cart Connect</title>
</head>
<body>
    <h2>Sign Up / Login</h2>
    <button onclick="showSignUp()">Create a account</button>
    <button onclick="showLogin()">Login to a account</button>
    <div id="signup-form" style="display:block;">
        <h3>Sign Up</h3>
        <form action="/auth/signup" method="post">
            <div>
                <label for="pseudo">Pseudo:</label>
                <input type="text" id="pseudo" name="pseudo" required>
            </div>
            <div>
                <label for="emailSignUp">Email:</label>
                <input type="email" id="emailSignUp" name="email" required>
            </div>
            <div>
                <label for="passwordSignUp">Password:</label>
                <input type="password" id="passwordSignUp" name="password" required>
            </div>
            <button type="submit">Sign Up</button>
        </form>
    </div>

    <div id="login-form" style="display:none;">
        <h3>Login</h3>
        <form action="/auth/login" method="post">
            <div>
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
            </div>
            <div>
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <button type="submit">Login</button>
        </form>
    </div>

    <div th:if="${error}">
        <p th:text="${error}" style="color: #df0000"></p>
    </div>

    <script>
        function showSignUp() {
            document.getElementById('signup-form').style.display = 'block';
            document.getElementById('login-form').style.display = 'none';
        }

        function showLogin() {
            document.getElementById('signup-form').style.display = 'none';
            document.getElementById('login-form').style.display = 'block';
        }
    </script>
</body>