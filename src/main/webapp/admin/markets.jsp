<%@ include file="/layout/header.jsp" %>
<div>
  <div class="flex justify-between items-center my-5">
    <h1 class="text-xl font-semibold text-blue-800 text-2xl">Markets</h1>
    <a href="<%=url+"admin/add-market-form"%>" class="h-12 w-32 rounded-lg bg-blue-200 font-semibold text-gray-600 flex items-center justify-center">
      <span class="text-blue-800">Add Market <i class="text-blue-800 fa-solid fa-cart-plus"></i></span>
    </a>
  </div>
  <table class="w-full rounded-md overflow-hidden">
    <thead>
    <tr class="bg-blue-50">
      <th class="p-4 font-semibold text-start">#</th>
      <th class="p-4 font-semibold text-start">City</th>
      <th class="p-4 font-semibold text-start">Address</th>
      <th class="p-4 font-semibold text-start">Market admin</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="market" items="${markets}">
      <tr class="h-10 even:bg-gray-50">
        <td class="p-3">${market.getId()}</td>
        <td class="p-3">${market.getCity()}</td>
        <td class="p-3">${market.getAddress()}</td>
        <td class="p-3">
            ${market.getMarketAdmin().getUsername() != null ? market.getMarketAdmin().getUsername() : "not assigned"}
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
<%@ include file="/layout/footer.jsp" %>