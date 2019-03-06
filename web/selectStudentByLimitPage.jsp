<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/30
  Time: 22:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <title>Title</title>
    <style type="text/css">
        table,tr,td,th{
            border: 1px solid black;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
<center>
    <a href="${pageContext.request.contextPath}/limitPageServlet?startPage=1">查询学生</a>

    <hr>

    <c:if test="${not empty page}">

        <c:if test="${not empty page.students}">
            <table>
                <thead>
                <tr>
                    <th>sid</th>
                    <th>sname</th>
                    <th>sage</th>
                    <th>ssex</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${page.students}" var="student">
                    <tr>
                        <td>${student.sid}</td>
                        <td>${student.sname}</td>
                        <td>${student.sage}</td>
                        <td>${student.ssex}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <c:if test="${page.thisPage!=1}">
                <a href="${pageContext.request.contextPath}/limitPageServlet?startPage=1">首页</a>
                <a href="${pageContext.request.contextPath}/limitPageServlet?startPage=${page.thisPage-1}">上一页</a>
            </c:if>

            <label>${page.thisPage}</label>

            <c:if test="${page.thisPage!=page.endPage}">
                <a href="${pageContext.request.contextPath}/limitPageServlet?startPage=${page.thisPage+1}">下一页</a>
                <a href="${pageContext.request.contextPath}/limitPageServlet?startPage=${page.endPage}">尾页</a>
            </c:if>
        </c:if>

        <c:if test="${empty page.students}">
            <span style="color:red">该学生表为空!!!</span>
        </c:if>
    </c:if>
</center>
</body>
</html>
