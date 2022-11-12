<%@ page import="com.akamarket.akamarket.helper.AlertSession" %>
<%@ page import="com.akamarket.akamarket.helper.Alert" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String url=application.getInitParameter("url"); %>
<html>

<head>
    <title>Marjane | Welcome</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
        integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <script src="//unpkg.com/alpinejs" defer></script>
</head>

<body>
    <div class="w-screen">

        <% if (AlertSession.isSet(session)){ %>
            <% Alert alert = AlertSession.alert(session); %>
            <div x-data="{ open: true,type: '<%=alert.getType()%>' }" x-show="open" x-bind:class="type == 'error' ? 'bg-red-50 text-red-600' : type == 'success' ? 'bg-green-50 text-green-600' : 'bg-blue-50 text-blue-600' " class="border-current border rounded-md p-5 py-3 top-1 left-1/2 -translate-x-1/2 z-50 w-[450px] max-w-11/12 absolute">
                <div class="flex items-center justify-between animate-pulse">
                    <p><%=alert.getMessage()%></p>
                    <span class="cursor-pointer" x-on:click="open = ! open"><i class="text-xl text-current fa-solid fa-circle-xmark"></i></span>
                </div>
            </div>
        <% } %>


        <section class="h-screen">
            <div class="mx-auto px-6 py-12 h-full w-full max-w-[550px]">
                <div class="flex justify-center flex-col items-center h-full text-gray-800">
                    <div class="w-32 border rounded-md">
                        <img src="<%=url%>assets/marjane_logo1.png">
                    </div>
                    <div class="w-full mt-10">
                        <form action="login" method="post">
                            <!-- Email input -->
                            <div class="mb-6">
                                <input name="email" type="email" placeholder="Enter you email..."
                                    class="form-control block w-full px-4 py-2 text-xl font-normal text-gray-700 bg-white bg-clip-padding border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none" />
                            </div>

                            <!-- Password input -->
                            <div class="mb-6">
                                <input name="password" type="password" placeholder="Enter your password..."
                                    class="form-control block w-full px-4 py-2 text-xl font-normal text-gray-700 bg-white bg-clip-padding border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none" />
                            </div>

                            <div class="flex items-center">
                                <div class="form-check">
                                    <label for="mkt-admin"><i>Market Admin</i></label>
                                    <input name="role" type="radio" value="mkt-admin" id="mkt-admin"
                                        class="form-check-input appearance-none rounded-full h-4 w-4 border border-gray-300 bg-white checked:bg-blue-600 checked:border-blue-600 focus:outline-none transition duration-200 my-1 align-top bg-no-repeat bg-center bg-contain float-left mr-2 cursor-pointer"
                                        checked>
                                </div>
                                <div class="form-check mx-2">
                                    <label for="dept-admin"><i>Dept Manager</i></label>
                                    <input name="role" type="radio" value="dept-admin" id="dept-admin"
                                        class="form-check-input appearance-none rounded-full h-4 w-4 border border-gray-300 bg-white checked:bg-blue-600 checked:border-blue-600 focus:outline-none transition duration-200 my-1 align-top bg-no-repeat bg-center bg-contain float-left mr-2 cursor-pointer">
                                </div>
                            </div>

                            <button type="submit"
                                class="inline-block mt-4 px-7 py-3 bg-blue-600 text-white font-medium text-sm leading-snug uppercase rounded shadow-md hover:bg-blue-700 hover:shadow-lg focus:bg-blue-700 focus:shadow-lg focus:outline-none focus:ring-0 active:bg-blue-800 active:shadow-lg transition duration-150 ease-in-out w-full"
                                data-mdb-ripple="true" data-mdb-ripple-color="light">
                                Login
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </section>
    </div>
</body>

</html>