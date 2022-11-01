<%@ page import="com.akamarket.akamarket.controller.Auth" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String url = application.getInitParameter("url");
%>
<html>
<head>
    <title>AKA Market | Welcome</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <script src="//unpkg.com/alpinejs" defer></script>
</head>
<body>
<div class="flex min-h-screen">
        <% if(Auth.role(session).equals("ADMIN")){ %>
            <%@ include file="/inc/admin/aside.jsp" %>
        <% }else if(Auth.role(session).equals("ADMIN")){ %>
            <%@ include file="/inc/market.admin/aside.jsp" %>
        <% }else{ %>
            <%@ include file="/inc/dept.admin/aside.jsp" %>
        <% } %>
        <div class="flex-auto w-full">
        <nav class="h-16 bg-[#F9FAFB] flex items-center m-3 rounded-lg justify-between">
            <div>
                <c:choose>
                    <c:when test="${param.sectionTitle != null}">
                        <h2 class="title ml-4 text-xl">${param.sectionTitle}</h2>
                    </c:when>
                    <c:when test="${sectionTitle != null}">
                        <h2 class="title ml-4 text-xl">${sectionTitle}</h2>
                    </c:when>
                    <c:otherwise>
                        <h2 class="title ml-4 text-xl">[SECTION TITLE]</h2>
                    </c:otherwise>
                </c:choose>
            </div>
            <button x-data="{open:false}" @click="open = !open" class="">
                <%= Auth.role(session) %>
                <div x-show="open">
                    only when opened!!!!
                </div>
            </button>
        </nav>
        <div class="m-3">
