<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ru">
<head>

    <title>My first text game</title>
</head>
<body>
<h1>Добро пожаловать в каталог приключений!
</h1>
<c:set var = "user" scope="session" value="${user}"/>
<c:if test="${user == null}">
    <h2>Представьтесь, пожалуйста!</h2>
<form action="hello-servlet">
    <p><input name="name"></p>
    <p><input type="submit"></p>
</form>
</c:if>
<c:if test="${user != null}">
<p>Выбери то, что тебе больше подходит!</p>
<br/>

<form action="hello-servlet" method="post">
    <p><select size="2"  name="journey">
        <option disabled>Выберите приключениe</option>
        <option value="LiftToNowhere.json">Лифт в никуда</option>
        <option selected value="VampireInCan.json">Вампира, просим, не кормить</option>
    </select></p>
    <p><input type="submit" value="Выбрать"></p>
</form>
</c:if>

</body>
</html>