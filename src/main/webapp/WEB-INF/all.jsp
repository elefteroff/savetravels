<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Expenses</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
	<h3>All Expenses</h3>
		<table>
			<tbody>
				<tr>
					<th>Expense</th>
					<th>Vendor</th>
					<th>Amount</th>
					<th>Actions</th>
				</tr>
				<c:forEach items="${allExpenses }" var="e">
					<tr>
						<td>
							<a href="/details/${e.id }">${e.expenseName }</a>
						<td>
						<td>${e.vendor }</td>
						<td>${e.amount }</td>
						<td>${e.description }</td>
						<td>
							<form action="/edit/${e.id}" method="post">
								<input type="hidden" name="_method" value="put">
								<input type="submit" value="Update">
							</form>
						</td>
						<td>
							<form action="/index/${e.id}" method="post">
								<input type="hidden" name="_method" value="delete">
								<input type="submit" value="Delete">
							</form>
						</td>
					</tr>
					<hr/>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
