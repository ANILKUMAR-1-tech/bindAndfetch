<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Registration Result</title>
</head>
<body>
    <h2>Student Details</h2>
    
    <c:forEach var="student" items="${student}">
    
        <p><strong>Id:</strong> ${student.id}</p>
        <p><strong>Email:</strong> ${student.email}</p>
        <p><strong>Course:</strong> ${student.course}</p>
        <p><strong>Timings:</strong>
           <c:forEach var="time" items="${student.timings}">
              ${time}&nbsp;
           </c:forEach>
        </p>
    
    </c:forEach>
   
</body>
</html>
