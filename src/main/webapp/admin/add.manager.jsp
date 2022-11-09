<%@ include file="/layout/header.jsp" %>
<h1 class="text-xl font-semibold text-blue-800 text-2xl">Add Manager</h1>
<div class="bg-gray-50 mx-auto p-6 rounded-md mt-4 border border-blue-100">
    <form action="<%=url+"admin/add-manager"%>" method="post">
        <div class="flex item-center gap-3">
            <div class="border p-2 h-12 relative flex-1 overflow-hidden rounded-md">
                <label class="text-lg px-2" for="email">Email</label>
                <input required class="h-full focus:left-0 focus:outline-blue-500 absolute w-full top-0 p-2 rounded-md" id="email" name="email" type="email" placeholder="Enter email">
            </div>
            <div class="border p-2 h-12 relative flex-1 overflow-hidden rounded-md">
                <label class="text-lg px-2" for="username">Username</label>
                <input required class="h-full focus:left-0 focus:outline-blue-500 absolute w-full top-0 p-2 rounded-md" id="username" name="username" placeholder="Enter username">
            </div>
            <div class="border p-2 h-12 relative flex-1 overflow-hidden rounded-md">
                <label class="text-lg px-2" for="market">Market</label>
                <select id="market" name="market-id" class="h-full focus:left-0 focus:outline-blue-500 absolute w-full top-0 p-2 rounded-md">
                    <c:forEach items="${markets}" var="market">
                        <option value="${market.getId()}">${market.getAddress()} - ${market.getCity()}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="flex items-center justify-end mt-4">
            <button class="hover:shadow-form rounded-md bg-blue-800 py-3 px-8 text-center text-base font-semibold text-yellow-300 outline-none">
                Submit
            </button>
        </div>
    </form>
</div>
<%@ include file="/layout/footer.jsp" %>