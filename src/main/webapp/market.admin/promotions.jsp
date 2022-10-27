<%@ include file="/layout/header.jsp" %>
<table class="table-auto block">
  <thead>
  <tr class="bg-gray-100">
    <th class="p-3 border">#</th>
    <th class="p-3 border">Percentage</th>
    <th class="p-3 border">Loyalty points</th>
    <th class="p-3 border">Created at</th>
    <th class="p-3 border">Available until</th>
    <th class="p-3 border">Comment</th>
    <th class="p-3 border">Category</th>
    <th class="p-3 border">Status</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="promotion" items="${promotions}">
    <tr class="border border-blue-600 h-10 bg-lime-100">
      <td class="p-3 border">${promotion.getId()}</td>
      <td class="p-3 border">${promotion.getPercentage()}</td>
      <td class="p-3 border">${promotion.getLoyaltyPts()}</td>
      <td class="p-3 border">${promotion.getCreatedAt()}</td>
      <td class="p-3 border">${promotion.getAvUntile()}</td>
      <td class="p-3 border">${promotion.getDeptmanagercomment()}</td>
      <td class="p-3 border">${promotion.getCategory().getCategoryName()}</td>
      <td class="p-3 border">${promotion.getStatus()}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<%@ include file="/layout/footer.jsp" %>