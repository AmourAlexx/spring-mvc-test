<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>

<sec:authorize access="isAuthenticated()">
    <h1>Hello, <sec:authentication property="principal.username" /></h1>
</sec:authorize>
<sec:authorize access="!isAuthenticated()">
    <h1>Hello, Guest</h1>
</sec:authorize>
</body>
</html>