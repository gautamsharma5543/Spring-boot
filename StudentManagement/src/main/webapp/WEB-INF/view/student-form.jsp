<%@page import="com.cdac.studentmanagement.model.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="com.cdac.studentmanagement.model.Student" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>student registration</title>
<link  rel="stylesheet" href="/studentmanagement/resources/static/css/student-form.css">
</head>
<body>

<% 

Student student= (Student)request.getAttribute("student");
%>>

<div class="form-container">
    <h2>Student Registration</h2>
    
    <form action="/studentmanagement/student" method="post">
    
        <div class="form-group">
            <label for="firstName">First Name:</label>
            <input type="text" id="firstName" name="firstName" value="${student.firstName}" required>
        </div>
        
        
        <div class="form-group">
            <label for="lastName">Last Name:</label>
            <input type="text" id="lastName" name="lastName" value="${student.lastName}" required>
        </div>
        
        <div class="form-group">
            <label for="gender">Gender:</label>
            <select id="gender" name="gender" required>
                <option value="">Select Gender</option>
                <option value="Male" ${student.gender=='Male'?'checked':' '}>Male</option>
                <option value="Female" ${student.gender=='Female'?'checked':' '}>Female</option>
            </select>
        </div>
        
        <div class="form-group">
            <label for="course">Course:</label>
            <input type="text" id="course" name="course" value="${student.course}" required>
        </div>
        <div class="form-group">
            <button type="submit">Register</button>
        </div>
        <div>
               <a href="/studentmanagement/">Cancel</a>
               </div>
        </div>
    </form>
</div>
</body>
</html>