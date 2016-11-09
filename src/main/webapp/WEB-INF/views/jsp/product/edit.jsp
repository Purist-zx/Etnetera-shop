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
    <h1>Edit product</h1>
    <form action="" method="post">
        <p>New name: <input name="newName"/></p>
        <p>New serial number: <input name="newSerialNumber"/></p>
        <p><input type="submit" value="Submit"/> <input type="reset" value="Reset"/></p>
    </form>
    <hr>
    <p>
        <a class="btn btn-primary btn-lg" href="/etnshop" role="button">Back to homepage</a>
        <a class="btn btn-primary btn-lg" href="/etnshop/product/list" role="button">Back to list of products</a>
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