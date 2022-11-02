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
    <div class="text-lg bg-gray-50 p-3 rounded-md flex items-center justify-between"><span class="text-gray-800 flex items-center"><i class="mx-2 fa-solid fa-calendar-days"></i> <p class="font-semibold">Available until:</p></span> <p class="text-gray-600"> ${promotion.getAvUntile()}</p></div>
    <div class="text-lg bg-gray-50 p-3 rounded-md flex items-center justify-between"><span class="text-gray-800 flex items-center"><i class="mx-2 fa-sharp fa-solid fa-circle-check"></i> <p class="font-semibold">Loyalty points:</p></span> <p class="text-gray-600"> ${promotion.getLoyaltyPts()}</p></div>
    <div class="col-span-full text-lg bg-gray-50 p-3 rounded-md"><span class="text-gray-800 flex items-center"><i class="mx-2 fa-solid fa-comment"></i> <p class="font-semibold">Comment:</p></span> <p class="text-gray-600 mt-2"> ${promotion.getDeptmanagercomment()}</p></div>
  </div>
</div>
<%@ include file="/layout/footer.jsp" %>