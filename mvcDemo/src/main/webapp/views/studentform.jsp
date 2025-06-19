<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Form</title>
</head>
<body>

<h1>Student Details</h1>

<h1>${msg}</h1>

    <form:form modelAttribute="student" action="submitForm" method="post">
    <table border="1">
        <tr>
            <td>ID:</td>
            <td><form:input path="id"/></td>
        </tr>
        <tr>
            <td>NAME:</td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td>EMAIL:</td>
            <td><form:input path="email"/></td>
        </tr>
        <tr>
            <td>COURSE:</td>
            <td>
                <form:select path="course">
                    <form:options items="${courses}" />
                </form:select>
            </td>
        </tr>
        <tr>
            <td>TIMINGS:</td>
            <td>
                <form:checkboxes path="timings" items="${timings}" />
            </td>
        </tr>
        
         <tr>
           
            <td colspan="2" align="center">
                <input type="submit" value="Register">
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>
