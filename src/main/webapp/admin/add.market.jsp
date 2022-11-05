<%@ include file="/layout/header.jsp" %>
<div class="bg-gray-50 mx-auto p-6 rounded-md">
    <form action="<%=url+"admin/add-market"%>" method="post">
        <div class="flex item-center gap-3">
            <div class="border p-2 h-12 relative flex-1 overflow-hidden rounded-md">
                <label class="text-lg px-2" for="city">City</label>
                <input required class="h-full focus:left-0 focus:outline-blue-500 absolute w-full top-0 p-2 rounded-md" id="city" name="city" placeholder="Enter market city">
                <c:out value="${errors['city_err']}"></c:out>
            </div>
            <div class="border p-2 h-12 relative flex-1 overflow-hidden rounded-md">
                <label class="text-lg px-2" for="address">Address</label>
                <input required class="h-full focus:left-0 focus:outline-blue-500 absolute w-full top-0 p-2 rounded-md" id="address" name="address" placeholder="Enter market address">
            </div>
        </div>
        <div class="flex items-center justify-end mt-4">
            <button class="hover:shadow-form rounded-md bg-[#6A64F1] py-3 px-8 text-center text-base font-semibold text-white outline-none">
                Submit
            </button>
        </div>
    </form>
</div>
<%@ include file="/layout/footer.jsp" %>