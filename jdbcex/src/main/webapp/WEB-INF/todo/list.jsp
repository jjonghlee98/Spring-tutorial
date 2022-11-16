<%--
  Created by IntelliJ IDEA.
  User: jhwanl
  Date: 2022-11-16
  Time: 오후 5:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Todo List</h1>

<ul>
    <c:forEach var="dto" items="${dtoList}">
        <li>
            <span><a href="/todo/read?tno=${dto.tno}">${dto.tno}</a></span>
            <span>${dto.title}</span>
            <span>${dto.dueDate}</span>
            <span>${dto.finished ? "DONE" : "NOT YET"}</span>
        </li>
    </c:forEach>
</ul>
</body>
</html>
