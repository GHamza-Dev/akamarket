<%@ include file="/layout/header.jsp" %>
<div class="mx-auto w-full">
    <h1 class="text-xl font-semibold text-blue-800 mb-5 text-2xl">Add promotion</h1>
    <form action="<%=url%>market-admin/add-promotion" method="post">
        <div class="-mx-3 flex flex-wrap">
            <div class="w-full px-3 sm:w-1/2">
                <div class="mb-5">
                    <label for="category" class="mb-3 block text-base font-medium text-[#07074D]">Category</label>
                    <select name="category_id" type="text"
                            name="category"
                            id="category"
                            placeholder="Select category"
                            class="w-full rounded-md border border-[#e0e0e0] bg-white py-3 px-6 text-base font-medium text-[#6B7280] outline-none focus:border-[#6A64F1] focus:shadow-md">
                        <c:forEach var="cat" items="${categories}" >
                            <option value="${cat.getId()}">${cat.getCategoryName()}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="w-full px-3 sm:w-1/2">
                <div class="mb-5">
                    <label
                            for="percentage"
                            class="mb-3 block text-base font-medium text-[#07074D]"
                    >
                        Percentage
                    </label>
                    <input
                            type="number"
                            max="50"
                            name="percentage"
                            id="percentage"
                            placeholder="Enter promotion percentage"
                            required
                            class="w-full rounded-md border border-[#e0e0e0] bg-white py-3 px-6 text-base font-medium text-[#6B7280] outline-none focus:border-[#6A64F1] focus:shadow-md"
                    />
                    <small class="text-red-600">${errors['percentage_err']}</small>
                </div>
            </div>
        </div>

        <div>
            <div class="w-full">
                <div class="mb-5">
                    <label for="date" class="mb-3 block text-base font-medium text-[#07074D]">
                        Available until?
                    </label>
                    <input
                            type="date"
                            name="av_until"
                            id="date"
                            required
                            class="w-full rounded-md border border-[#e0e0e0] bg-white py-3 px-6 text-base font-medium text-[#6B7280] outline-none focus:border-[#6A64F1] focus:shadow-md"
                    />
                </div>
            </div>
        </div>

        <div class="flex justify-end">
            <button class="hover:shadow-form rounded-md bg-blue-800 py-3 px-8 text-center text-base font-semibold text-yellow-300 outline-none">
                Confirm
            </button>
        </div>
    </form>
</div>
</div>
<%@ include file="/layout/footer.jsp" %>