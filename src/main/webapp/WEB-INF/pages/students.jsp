<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Students Page</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<a href="../../index.jsp">Back to main menu</a>

<br/>
<br/>

<h1>Student list</h1>

<c:if test="${!empty listStudents}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Name</th>
            <th width="120">Email</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listStudents}" var="student">
            <tr>
                <td>${student.id}</td>
                <td><a href="/studentdata/${student.id}" target="_blank">${student.bookTitle}</a></td>
                <td>${student.name}</td>
                <td>${student.email}</td>
                <td><a href="<c:url value='/edit/${book.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/${book.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a Book</h1>

<c:url var="addAction" value="/students/add"/>

<form:form action="${addAction}" commandName="student">
    <table>
        <c:if test="${!empty student.name}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="studentName">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="studentName"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="studentEmail">
                    <spring:message text="Email"/>
                </form:label>
            </td>
            <td>
                <form:input path="studentEmail"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty student.studentName}">
                    <input type="submit"
                           value="<spring:message text="Edit Student"/>"/>
                </c:if>
                <c:if test="${empty student.studentLogin}">
                    <input type="submit"
                           value="<spring:message text="Add Student"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
