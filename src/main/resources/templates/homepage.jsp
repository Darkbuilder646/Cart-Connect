<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Home</title>
</head>
<body>
<div class="top">
    <header>
        <h1>Cart Connect</h1>
        <button class="user-cart">
            <span>Cart</span>
            <div class="notif">
                <span class="notif-text">0</span>
            </div>
        </button>
    </header>

    <form action="/homepage/products/search" method="post" class="form-Search">
        <div class="form-group">
            <label for="category-select">Category</label>
            <select name="category" id="category-select" class="form-control">
                <option value="">-- Select a product --</option>
                <option value="Fruits">Fruits</option>
                <option value="Legumes">Légumes</option>
                <option value="Produits Laitier">Produits Laitier</option>
                <option value="Boissons">Boissons</option>
                <option value="Alcools">Alcools</option>
            </select>
        </div>
        <div class="form-group">
            <label for="name-Search">Name of product</label>
            <input type="text" id="name-Search" name="productName" class="form-control"/>
        </div>
        <div class="form-group">
            <button class="search-Btn form-control">Search</button>
        </div>
    </form>

    <div class="separator"></div>
</div>
<div class="grid-container">

    <div class="card" th:each="product : ${allProducts}">
        <div class="card-item">
            <p class="name-text" th:utext="${product.name}">...</p>
            <p class="desc-text" th:utext="${product.description}">...</p>
            <p class="price-text" th:utext="${product.price}">...</p>
            <button>Add to cart</button>
        </div>
    </div>

    <div class="card" th:if="${not #lists.isEmpty(filteredProducts)}" th:each="product : ${filteredProducts}">
        <div class="card-item">
            <p class="name-text" th:text="${product.name}">...</p>
            <p class="desc-text" th:text="${product.description}">...</p>
            <p class="price-text" th:text="${product.price}">...</p>
            <button>Add to cart</button>
        </div>
    </div>

    <div th:if="${#lists.isEmpty(filteredProducts)}">
        <p>No products found.</p>
    </div>


</div>

</body>

<style>
    body {
        margin: 0;
        padding: 12px;
    }

    h1 {
        flex: 1;
        margin-left: 24px;
        font-family: Arial, Helvetica, sans-serif;
    }

    header {
        display: flex;
        align-items: center;
    }

    p, button, label, input, span {
        font-family: Arial, Helvetica, sans-serif;
        font-size: medium;
    }

    .top {
        position: sticky;
        top: 0;
        z-index: 10;
        background-color: white;
    }

    .user-cart {
        display: flex;
        position: relative;
        width: 50px;
        height: 50px;
        background-color: #c4ffbc;
        border: 2px solid #8cde81;
        border-radius: 100%;
        justify-content: center;
        align-items: center;
    }

    .notif {
        position: absolute;
        display: flex;
        justify-content: center;
        align-items: center;
        top: 0;
        right: 0;
        transform: translate(25%, -25%);
        height: 20px;
        width: 20px;
        background-color: rgb(222, 55, 55);
        border: 2px solid red;
        border-radius: 100%;
    }

    .notif-text {
        text-align: center;
        color: white;
    }

    .form-Search {
        display: flex;
        flex-direction: row;
        flex-wrap: wrap;
        margin: 0 auto;
        padding: 12px;
        border: 2px solid #ccc;
        border-radius: 8px;
        background-color: white;
    }
    .form-group {
        display: flex;
        flex-direction: column;
        flex: 1;
        margin-right: 12px;
    }

    .form-group:last-child {
        justify-content: center;
        margin-right: 0;
    }

    .form-group label {
        display: flex;
        margin-bottom: 5px;
        font-weight: bold;
    }

    .form-control {
        width: 100%;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    .search-Btn {
        padding: 10px 20px;
        background-color: #c4ffbc;
        border: 1.5px solid #8cde81;
        cursor: pointer;
        border-radius: 4px;
        transition: background-color 0.3s ease;
    }

    .search-Btn:hover {
        background-color: #ace0a5;
    }

    .separator {
        display: flex;
        flex: 1;
        height: 2px;
        background-color: black;
        margin: 10px 0;
    }

    .grid-container {
        display: grid;
        grid-template-columns: repeat(4, 1fr);
        gap: 12px;
        justify-items: center;
        align-items: center;
    }

    /* Pour les PC */
    @media screen and (min-width: 1024px) {
        .grid-container {
            grid-template-columns: repeat(4, 1fr);
        }
    }

    /* Pour les tablettes */
    @media screen and (max-width: 1023px) and (min-width: 768px) {
        .grid-container {
            grid-template-columns: repeat(3, 1fr);
        }
    }

    /* Pour les appareils mobiles */
    @media screen and (max-width: 767px) {
        .grid-container {
            grid-template-columns: repeat(2, 1fr);
        }
        .form-Search {
            flex-direction: column;
        }
        .form-group {
            margin-right: 0;
            margin-bottom: 12px;
        }
        .form-group:last-child {
            margin-bottom: 0;
        }

    }
    .card {
        height: 100px;
        min-height: 200px;
        width: calc(100% - 32px);
        border: 2px solid #ccc;
        border-radius: 8px;
        overflow: hidden;
        padding: 12px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.15);
        background-color: #fafafa;
    }

    .card-item {
        display: flex;
        flex-direction: column;
        justify-content: space-between;
        align-items: center;
        height: 100%;
    }

    .card-item p {
        font-size: 16px;
        line-height: 1.5;
        margin: 0 0 10px;
    }

    .price-text, .name-text {
        font-weight: bold;
    }

    .desc-text {
        flex: 1;
    }

    .card-item button {
        height: 42px;
        padding: 10px 20px;
        border: 2px solid #8cde81;
        border-radius: 4px;
        background-color: #c4ffbc;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    .card-item button:hover {
        background-color: #ace0a5;
    }
</style>