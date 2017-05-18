<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Restaurantes</title>
</head>
<body>



<h1> ESTAMOS EN RESTAURANTE</h1>

<a href="/">Inicio </a><br>
<a href="/videos?destino=${busqueda.destino}">Vídeos de su destino </a><br>
<a href="/weather?destino=${busqueda.destino}">Tiempo de su destino </a><br>
<a href="/imagenes?destino=${busqueda.destino}">Restaurantes de su destino </a><br>
<a href="/facebookPostCreation?destino=${busqueda.destino}">Postear en facebook </a>

					<c:forEach items="${requestScope.zomato.restaurants}" var="lista">
					
						<div style="border: 2px solid black">
							<p>Nombre del restaurante: <c:out value="${lista.restaurant.name}"> </c:out> </p>
							<p>Calle: <c:out value="${lista.restaurant.location.address}"> </c:out> </p>
							<p>Localidad: <c:out value="${lista.restaurant.location.locality}"> </c:out> </p>
							<p>Ciudad: <c:out value="${lista.restaurant.location.city}"> </c:out> </p>
							<a href="${lista.restaurant.url}">Url del sitio</a><br>	
						</div>
				
					</c:forEach>

</body>
</html>