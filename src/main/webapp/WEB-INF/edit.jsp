<%@ page isErrorPage="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Expenses</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h3>Edit Expense</h3>
		<p>${thisExpense.id }</p>
	   	<form:form method="post" action="/prod/${thisExpense.id}/edit" modelAttribute="thisExpense">
			<input type="hidden" name="_method" value="put">
			<form:errors path="*" />
			<p>
				Expense Name:
				<form:input path="expenseName"/>
			</p>
			<p>
				Vendor:
				<form:input path="vendor"/>
			</p>
			<p>
				Amount:
				<form:input type="number" path="amount"/>
			</p>
			<p>
				Description:
				<form:input path="description"/>
			</p>
			<button>Submit</button>
		</form:form>
		<a href="/all">Go back</a>
	</div>
</body>
</html>

