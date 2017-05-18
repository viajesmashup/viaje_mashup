<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Imagenes</title>
</head>
<body>
	<h1>ESTAMOS EN IMÁGENES</h1>
	
<a href="/">Inicio </a><br>
<a href="/videos?destino=${busqueda.destino}">Vídeos de su destino </a><br>
<a href="/weather?destino=${busqueda.destino}">Tiempo de su destino </a><br>
<a href="/restaurantes?destino=${busqueda.destino}">Restaurantes de su destino </a><br>
<a href="/facebookPostCreation?destino=${busqueda.destino}">Postear en facebook </a>


	<c:forEach items="${requestScope.photos.value}" var="foto">
		<div>
			<img src="<c:out value="${foto.contentUrl}"></c:out>"
				alt="FotosCiudad" height="40%" width="50%">
		</div>
	</c:forEach>



</body>
</html>