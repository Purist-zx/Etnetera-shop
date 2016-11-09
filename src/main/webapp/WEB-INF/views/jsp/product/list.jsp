<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>etnShop</title>

    <spring:url value="/resources/core/css/hello.css" var="coreCss"/>
    <spring:url value="/resources/core/css/bootstrap.min.css"
                var="bootstrapCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>
    <link href="${coreCss}" rel="stylesheet"/>
</head>

<div class="container">
    <h2>Products</h2>
    <form action="search" method="post">
        <p>Fulltext search: <input name="text"/><input type="submit" value="Submit"/></p>
    </form>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Serial number</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${products}" var="product">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.serialNumber}</td>
                <td><a href="${product.id}/edit">Edit</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <h1>Add new product</h1>
    <form action="" method="post" name="product">
        <p>Name: <input name="name"/></p>
        <p>Serial number: <input name="serialNumber"/></p>
        <p><input type="submit" value="Submit"/> <input type="reset" value="Reset"/></p>
    </form>
    <hr>
    <p>
        <a class="btn btn-primary btn-lg" href="/etnshop" role="button">Back to homepage</a>
    </p>
    <footer>
        <p>&copy; Etnetera a.s. 2015</p>
    </footer>
</div>

<spring:url value="/resources/core/css/bootstrap.min.js"
            var="bootstrapJs"/>

<script src="${bootstrapJs}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</body>
</html>