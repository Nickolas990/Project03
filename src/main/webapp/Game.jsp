<%--
  Created by IntelliJ IDEA.
  User: hrom_
  Date: 27.08.2022
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${book.getTitle()}</title>
</head>
<body>
<form method="get" action="hello-servlet">
    <p><i>${text}</i></p>
    <p>${answers}</p>
</form>
</body>
</html>
