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
	<h2>
		<a href="PaymentListCtl">Back</a>
	</h2>
	<%
		PaymentDTO dto = (PaymentDTO) request.getAttribute("dto");
	String msg=(String)request.getAttribute("msg");
	%>
	<form action="PaymentCtl" method="post">
		<center>
			<%
				if (dto != null) {
			%>
			<h1>Edit User</h1>
			<%
				} else {
			%>
			<h1>Add User</h1>
			<%
				}
			%>
			<%
			if(msg!=null){%>
<%=msg %>
<%} %>


			<table>
				<input type="hidden" name="id"
					value="<%=(dto != null) ? dto.getId() : ""%>">
				<tr>
					<th>PaymentDate:</th>
					<td><input type="date" name="PaymentDate"
						value="<%=(dto != null) ? dto.getPaymentDate() : ""%>"></td>
				</tr>
				
				<tr>
					<th>Description:</th>
					<td><input type="text" name="Description"
						value="<%=(dto != null) ? dto.getDescription() : ""%>"></td>
				</tr>

				<tr>
					<th>Amount:</th>
					<td><input type="text" name="amount"
						value="<%=(dto != null) ? dto.getAmount() : ""%>"></td>
				</tr>
				
				<tr>
					<th>PaymentMethod:</th>
					<td><input type="text" name="paymentmethod"
						value="<%=(dto != null) ? dto.getPaymentMethod() : ""%>"></td>
				</tr>
				
				<tr>
					<th>Status:</th>
					<td><input type="text" name="Status"
						value="<%=(dto != null) ? dto.getStatus() : ""%>"></td>
				</tr>
				
				<tr>
					<th>Payer:</th>
					<td><input type="text" name="payer"
						value="<%=(dto != null) ? dto.getPayer() : ""%>"></td>
				</tr>
				
			</table>
			<table>
				<%
					if (dto != null) {
				%>
				<tr>
					<td><input type="submit" name="operation" value="update"></td>
                    <td><input type="submit" name="operation" value="AddUser"></td>

				</tr>
				<%
					} else {
				%>
				<tr>
					<td><input type="submit" name="operation" value="save"></td>
					 <td><input type="submit" name="operation" value="cancel"></td>	
				</tr>
				<%
					}
				%>
			</table>
		</center>
	</form>
</html>