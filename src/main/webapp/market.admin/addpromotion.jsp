<%@ include file="/layout/header.jsp" %>
<form action="<%=url%>market-admin/add-promotion" method="post">
    <select name="category_id" class="bg-slate-300 p-3">
        <c:forEach var="cat" items="${categories}" >
            <option value="${cat.getId()}">${cat.getCategoryName()}</option>
        </c:forEach>
    </select>
    <input name="percentage" type="number" placeholder="Enter promotion percentage" class="p-3 bg-slate-300 p-3">
    <input name="loyalty_pts" type="number" placeholder="Enter loyalty points" class="p-3 bg-slate-300 p-3">
    <input name="av_until" type="date" placeholder="Available until" class="p-3 bg-slate-300 p-3">

    <button class="bg-black text-white p-2">Submit</button>
</form>
<%@ include file="/layout/footer.jsp" %>