<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.rays.paymentdto.PaymentDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%PaymentDTO dto=new PaymentDTO(); 
List list=(List)request.getAttribute("List");
Iterator it=list.iterator();

%>
<form action="PaymentListCtl" method="post">

<table>
<!-- <tr ><td><input type="text" name="payer" ></td> -->

<td>
<!-- <input type="submit" name="operation" value="search"> -->
</td>
</tr>
</table>
<table border="2"   >
<tr >
<th>SelectAll</th>
<th>Id</th>
<th>PaymentDate</th>
<th>Description</th>
<th>Amount</th>
<th>PaymentMethod</th>
<th>Status</th>
<th>Payer</th>
<th>Edit</th>

</tr>


<%while(it.hasNext()){ 
dto=(PaymentDTO)it.next();
%>


<tr>
<td><input type="checkbox" name="ids" value="<%=dto.getId() %>"></td>
<td><%=dto.getId() %></td>
<td><%=dto.getPaymentDate() %></td>
<td><%=dto.getDescription() %></td>
<td><%=dto.getAmount() %></td>
<td><%=dto.getPaymentMethod() %></td>
<td><%=dto.getStatus() %></td>
<td><%=dto.getPayer() %></td>
<td><a href="PaymentCtl?id=<%=dto.getId()%>">edit</a></td>

<%} %>
</tr>

</table>
<table>
<tr>
<td>
<input type="submit" name="operation" value="delete">
</td>

</tr>
</table>
</form>
</body>
</html>