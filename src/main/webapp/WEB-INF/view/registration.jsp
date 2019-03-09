<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Registration form</title>
</head>
<body>
<spring:message code="app.lang.title"/> : <a href="?lang=ru">Russian</a>|<a href="?lang=uk_UA">Ukrainian</a>
<h1>Enter data:</h1>
<%--@elvariable id="user" type="ua.com.levelup.test.springmvc.model.User"--%>
<f:form id="regForm" modelAttribute="user"  action="auth" method="post">
    <table align="center">
        <tr>
            <td>
                <label path="login">Username</label>
            </td>
            <td>
                <f:input path="login" name="login" />
            </td>
            <td>
                <f:errors path="login"/>
            </td>
        </tr>
        <tr>
            <td>
                <label path="password">Password</label>
            </td>
            <td>
                <f:input type="password" path="password" name="password" id="password" />
            </td>
            <td>
                <f:errors path="password"/>
            </td>
        </tr>
        <tr>
            <td>
                <label path="firstname"><spring:message code="user.name"/></label>
            </td>
            <td>
                <f:input path="firstname" name="firstname" id="firstname" />
            </td>
            <td>
                <f:errors path="firstname"/>
            </td>
        </tr>
        <tr>
            <td>
                <label path="lastname">LastName</label>
            </td>
            <td>
                <f:input path="lastname" name="lastname" id="lastname" />
            </td>
            <td>
                <f:errors path="lastname"/>
            </td>
        </tr>
        <tr>
            <td>
                <label path="email">Email</label>
            </td>
            <td>
                <f:input path="email" name="email" id="email" />
            </td>
            <td>
                <f:errors path="email"/>
            </td>
        </tr>
        <tr>
            <td>
                <label path="address">Address</label>
            </td>
            <td>
                <f:input path="address" name="address" id="address" />
            </td>
            <td>
                <f:errors path="address"/>
            </td>
        </tr>
        <tr>
            <td>
                <label path="phone">Phone</label>
            </td>
            <td>
                <f:input path="phone" name="phone" id="phone" />
            </td>
            <td>
                <f:errors path="phone"/>
            </td>
        </tr>

        <tr>
            <td></td>
            <td>
                <button id="register" name="register">Register</button>
            </td>
            <td>

            </td>
        </tr>
        <tr></tr>

    </table>
</f:form>
</body>
</html>