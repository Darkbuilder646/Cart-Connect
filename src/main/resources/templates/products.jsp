<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List of Products</title>
</head>
<body>
<h1>List of Products in DB</h1>
<ul th:each = "product : ${allProduct}">
    <li th:utext="${product.name}">...</li>
    <li th:utext="${product.description}">...</li>
    <li th:utext="${product.price}">...</li>
    <li th:utext="${product.category_ID}">...</li>
</ul>
</body>