<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LISTA CLIENTE</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/estilo.css">
</head>
<body>

HEMOS LLEGADO A LA LISTA DE FUTUROS CLIENTES!!!

<table>
<tr>
	<th> Id</th>
	<th> Nombre</th>
	<th> Apellido</th>
	<th> Email</th>
	<th> Modificar</th>
</tr>
	<c:forEach var="clienteT" items="${clientes }">
	<c:url var="linkModificar" value="/cliente/muestraFormularioActualizar">
		<c:param name="clienteID" value="${clienteT.id }">
		</c:param>
	</c:url>
	<tr>
			<td> ${clienteT.id }</td>
			<td> ${clienteT.nombre }</td>
			<td> ${clienteT.apellido }</td>
			<td> ${clienteT.email }</td>
			<td><a href="${linkModificar}"><input type="button" value="Modificar" /> </a></td>
		</tr> 
	</c:forEach>
</table>
	<br/>
<input type="button" value="Agregar CLIENTE" onclick="window.location.href='muestraFormularioAgregar';return false;"/>	
</body>
</html>