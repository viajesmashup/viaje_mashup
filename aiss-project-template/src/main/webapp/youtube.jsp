<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vídeos</title>
</head>
<body>
	<h1>ESTAMOS EN YOUTUBE</h1>
	
<a href="/">Inicio </a><br>
<a href="/imagenes?&destino=${busqueda.destino}">Imágenes de su destino </a><br>
<a href="/weather?&destino=${busqueda.destino}">Tiempo de su destino </a><br>
<a href="/restaurantes?&destino=${busqueda.destino}">Restaurantes de su destino </a><br>
<a href="/facebookPostCreation?&destino=${busqueda.destino}">Postear en facebook </a>







	<c:forEach items="${requestScope.videos}" var="video">
		<div>
			<iframe width="50%" height="50%"
				src="https://www.youtube.com/embed/<c:out value="${video.id.videoId}"></c:out>"
				frameborder="1" allowfullscreen></iframe>

		</div>
		<br>
	</c:forEach>

</body>
</html>