<%@ include file="/layout/header.jsp" %>
<div>
  <div class="flex justify-between items-center my-5">
    <h1 class="text-xl font-semibold text-blue-800 text-2xl">Managers</h1>
    <a href="<%=url+"admin/add-manager-form"%>" class="h-12 w-34 rounded-lg bg-blue-200 font-semibold text-gray-600 flex items-center justify-center px-2">
      <span class="text-blue-800">Add manager <i class="text-blue-800 fa-solid fa-user-plus"></i></span>
    </a>
  </div>
  <table class="w-full rounded-md overflow-hidden">
    <thead>
    <tr class="bg-blue-50">
      <th class="p-4 font-semibold text-start">#</th>
      <th class="p-4 font-semibold text-start">Username</th>
      <th class="p-4 font-semibold text-start">Email</th>
      <th class="p-4 font-semibold text-start">Market City</th>
      <th class="p-4 font-semibold text-start">Market Address</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="manager" items="${managers}">
      <tr class="h-10 even:bg-gray-50">
        <td class="p-3">${manager.getId()}</td>
        <td class="p-3">${manager.getUsername()}</td>
        <td class="p-3">${manager.getEmail()}</td>
        <td class="p-3">${manager.getMarket().getCity()}</td>
        <td class="p-3">${manager.getMarket().getAddress()}</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
<%@ include file="/layout/footer.jsp" %>