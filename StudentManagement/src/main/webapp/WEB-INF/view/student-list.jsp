<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.cdac.studentmanagement.model.Student" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>student data</title>
<link rel="stylesheet" href="/studentmanagement/resources/static/css/student-list.css">
</head>
<body>

<h1>Student Information</h1>

    <table>
        <thead>
            <tr>
                <th>Student Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Gender</th>
                <th>Course</th>
                <th>action</th>
                <th>delete</th>
            </tr>
        </thead>
        <tbody>
        <% 
        List <Student> studentlist=(List<Student>) request.getAttribute("stud");
        for (Student studs:studentlist){
        %>
        
        
            <tr>
                <td><%=studs.getStudId()    %></td>
                <td><%=studs.getFirstName()    %></td>
                <td><%=studs.getLastName()  %></td>
                <td><%=studs.getGender()    %></td>
                <td><%=studs.getCourse()    %></td>
                <td>
      <a href="/studentmanagement/update/<%=studs.getStudId()%>">Update</a> </td><!-- /studentsoft/edit/1007 -->
     <td> <a href="/studentmanagement/delete/<%=studs.getStudId()%>">Delete</a> <!-- /studentsoft/delete/1007 -->
        </td>
               
            </tr>
             <%
        }
                %>
        </tbody>
    </table>
    <br><br>
    <a href="/studentmanagement/new">Add New Student</a>	&nbsp;&nbsp;&nbsp;
	<a href="/studentmanagement/">Home page</a>
    
</body>
</html>