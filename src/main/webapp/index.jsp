<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World! По русски"%>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<h2>${book.getTitle()}</h2>
<p>${book.getBlockById("4")}</p>

</body>
</html>