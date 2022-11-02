<%@ include file="/layout/header.jsp" %>
<h1 class="text-xl font-semibold text-gray-500 mb-5 text-2xl">Review promotion</h1>
<div>
    <div class="flex justify-center items-center relative" x-data="{status: '${promotion.getStatus()}'}">
        <span x-bind:class="status == 'refused' ? 'bg-red-100 text-red-600' : status == 'accepted' ? 'bg-green-100 text-green-600 animate-pulse' : status == 'pending' ? 'bg-blue-100 text-blue-600' : 'bg-[#d8b4fe] text-[#6b21a8]'" class="rounded-full px-4 py-1 text-center w-fit font-normal block z-50">
            ${promotion.getStatus()}
        </span>
        <span class="p-1 absolute w-full top-1/2 bg-gray-50 rounded-full" x-bind:class="status == 'refused' ? 'bg-red-100 text-red-600' : status == 'accepted' ? 'bg-green-100 text-green-600 animate-pulse' : status == 'pending' ? 'bg-blue-100 text-blue-600' : 'bg-[#d8b4fe] text-[#6b21a8]'"></span>
    </div>
    <div class="grid grid-cols-2 gap-2 mt-4">
        <div class="text-lg bg-gray-50 p-3 rounded-md flex items-center justify-between"><span class="text-gray-800 flex items-center"><i class="mx-2 fa-solid fa-genderless"></i> <p class="font-semibold">Category:</p></span> <p class="text-gray-600"> ${promotion.getCategory().getCategoryName()}</p></div>
        <div class="text-lg bg-gray-50 p-3 rounded-md flex items-center justify-between"><span class="text-gray-800 flex items-center"><i class="mx-2 fa-solid fa-percent"></i> <p class="font-semibold">Percentage:</p></span> <p class="text-gray-600"> ${promotion.getPercentage()}</p></div>
        <div class="text-lg bg-gray-50 p-3 rounded-md flex items-center justify-between"><span class="text-gray-800 flex items-center"><i class="mx-2 fa-solid fa-calendar-days"></i> <p class="font-semibold">Available until:</p></span> <p class="text-gray-600"> 05/06/2022</p></div>
        <div class="text-lg bg-gray-50 p-3 rounded-md flex items-center justify-between"><span class="text-gray-800 flex items-center"><i class="mx-2 fa-sharp fa-solid fa-circle-check"></i> <p class="font-semibold">Loyalty points:</p></span> <p class="text-gray-600"> 40</p></div>
    </div>
    <div>
        <h1 class="text-xl font-semibold text-gray-500 mb-5 text-lg mt-4">Decision</h1>
        <div>
            <form action="<%=url+"dept-admin/promotions"%>" method="post" x-data="{decision:null}">
                <input name="promotion-id" value="${promotion.getId()}" hidden>
                <div>
                    <label class="text-lg text-gray-400" for="comment">Comment</label>
                    <textarea required id="comment" name="comment" class="placeholder:italic placeholder:text-slate-400 block bg-white w-full border border-slate-300 rounded-md py-2 pl-9 pr-3 shadow-sm focus:outline-none focus:border-sky-500 focus:ring-sky-500 focus:ring-1 sm:text-sm" placeholder="I accept/reject this promotion because some....."></textarea>
                </div>
                <div class="flex items-center gap-1 mt-4">
                    <div class="flex-1">
                        <label x-on:click="decision = 'accepted'" x-bind:class="decision == 'accepted' ?  'bg-blue-600' : 'bg-blue-300'" class="py-3 px-4 text-white font-bold rounded-lg bg-blue-300 block text-center cursor-pointer" for="accept">Accept</label>
                        <input required id="accept" type="radio" name="decision" hidden value="accepted">
                    </div>
                    <div class="flex-1">
                        <label x-on:click="decision = 'refused'" x-bind:class="decision == 'refused' ?  'bg-red-600' : 'bg-red-300'" class="py-3 px-4 text-white font-bold rounded-lg bg-red-300 block text-center cursor-pointer" for="reject">Refuse</label>
                        <input required id="reject" type="radio" name="decision" hidden value="refused">
                    </div>
                </div>
                <div class="flex justify-end mt-3">
                    <button name="request-for" value="update-status" class="hover:shadow-form rounded-md bg-[#6A64F1] py-3 px-8 text-center text-base font-semibold text-white outline-none">
                        Confirm
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>

<%@ include file="/layout/footer.jsp" %>