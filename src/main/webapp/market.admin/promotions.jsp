<%@ include file="/layout/header.jsp" %>
<div>
  <h1 class="text-xl font-semibold text-blue-800 mb-5 text-2xl">Promotions</h1>
  <table class="w-full rounded-md overflow-hidden">
    <thead>
    <tr class="bg-blue-50">
      <th class="p-4 font-semibold text-start">#</th>
      <th class="p-4 font-semibold text-start">Percentage</th>
      <th class="p-4 font-semibold text-start">Loyalty points</th>
      <th class="p-4 font-semibold text-start">Created at</th>
      <th class="p-4 font-semibold text-start">Available until</th>
      <th class="p-4 font-semibold text-start">Comment</th>
      <th class="p-4 font-semibold text-start">Category</th>
      <th class="p-4 font-semibold text-start">Status</th>
      <th class="p-4 font-semibold text-center">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="promotion" items="${promotions}">
      <tr class="h-10 even:bg-gray-50">
        <td class="p-3">${promotion.getId()}</td>
        <td class="p-3">${promotion.getPercentage()}</td>
        <td class="p-3">${promotion.getLoyaltyPts()}</td>
        <td class="p-3">${promotion.getCreatedAt()}</td>
        <td class="p-3">${promotion.getAvUntile()}</td>
        <td class="p-3">${promotion.getDeptmanagercomment()}</td>
        <td class="p-3">${promotion.getCategory().getCategoryName()}</td>
        <td class="p-3" x-data="{status: '${promotion.getStatus()}'}">
          <div x-bind:class="status == 'refused' ? 'bg-red-100 text-red-600' : status == 'accepted' ? 'bg-green-100 text-green-600' : status == 'pending' ? 'bg-blue-100 text-blue-600 animate-pulse' : 'bg-[#d8b4fe] text-[#6b21a8]'" class="rounded-full px-4 py-1 text-center w-fit font-normal">
              ${promotion.getStatus()}
          </div>
        </td>
        <td class="py-3 px-6 text-center">
          <div class="flex item-center justify-center">
            <form action="<%=url+"market-admin/promotion"%>" method="post" class="m-0">
              <button name="promotion-id" value="${promotion.getId()}" class="w-4 mr-2 text-blue-600 transform hover:text-purple-500 hover:scale-110">
                <i class="fa-solid fa-eye"></i>
              </button>
            </form>
            <form class="m-0">
              <button type="button" class="w-4 mr-2 text-green-600 transform hover:text-purple-500 hover:scale-110">
                <i class="fa-solid fa-pen-to-square"></i>
              </button>
            </form>
            <form class="m-0">
              <button type="button" class="w-4 mr-2 text-red-600 transform hover:text-purple-500 hover:scale-110 disabled">
                <i class="fa-solid fa-trash-can"></i>
              </button>
            </form>
          </div>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
<%@ include file="/layout/footer.jsp" %>