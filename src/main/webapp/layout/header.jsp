<%@ page import="com.akamarket.akamarket.controller.Auth" %>
<%@ page import="com.akamarket.akamarket.entity.MarketAdmin" %>
<%@ page import="com.akamarket.akamarket.entity.SuperAdmin" %>
<%@ page import="com.akamarket.akamarket.entity.DepartementManager" %>
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
<div class="flex min-h-screen bg-[#fafafa]">
        <% if(Auth.role(session).equals("SUPERADMIN")){ %>
            <%@ include file="/inc/admin/aside.jsp" %>
        <% }else if(Auth.role(session).equals("MARKETADMIN")){ %>
            <%@ include file="/inc/market.admin/aside.jsp" %>
        <% }else{ %>
            <%@ include file="/inc/dept.admin/aside.jsp" %>
        <% } %>
        <div class="flex-auto w-full">
        <nav class="h-16 bg-gray-100 drop-shadow-md flex items-center m-3 rounded-lg justify-between">
            <div>
                <c:choose>
                    <c:when test="${param.sectionTitle != null}">
                        <h2 class="title ml-4 text-xl">${param.sectionTitle}</h2>
                    </c:when>
                    <c:when test="${sectionTitle != null}">
                        <h2 class="title ml-4 text-xl">${sectionTitle}</h2>
                    </c:when>
                    <c:otherwise>
                        <h2 class="title ml-4 text-gray-300"></h2>
                    </c:otherwise>
                </c:choose>
            </div>
            <button x-data="{open:false}" @click="open = !open" class="flex items-center mr-2 bg-gray-50 p-2 rounded-full">
                <span class="uppercase font-semibold mr-1 transition-all" x-show="open">
                    <%=  Auth.role(session).equals("SUPERADMIN") ? Auth.<SuperAdmin>auth(session).getUsername() : Auth.role(session).equals("MARKETADMIN") ? Auth.<MarketAdmin>auth(session).getUsername() : Auth.<DepartementManager>auth(session).getUsername() %>
                </span>
                <span class="w-11 block">
                    <img src="<%=url%>assets/user.png" class="w-full">
                </span>
            </button>
        </nav>
        <div class="m-3">
