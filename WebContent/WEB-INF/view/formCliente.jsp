<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario Cliente</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/estilo.css">
</head>
<body>
Es un formulario para insertar datos del cliente
<form:form action="insertaCliente" modelAttribute="nuevoCliente" method="POST">
	<table>
		<tr>
			<td>Nombre:</td>
			<td><form:input path="nombre"/> </td>
		</tr>
		<tr>
			<td>Apellido:</td>
			<td><form:input path="apellido"/> </td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><form:input path="email"/> </td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Insertar"></td>
		</tr>

	</table>
</form:form>
</body>
</html>