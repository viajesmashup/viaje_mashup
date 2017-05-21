<%@include file="includes/header.jsp"%>



<nav>
	    <div class="nav-wrapper">
	      <a href="/restaurantes?destino=${busqueda.destino}" class="brand-logo">RESTAURANTES</a>
	      <a href="#" data-activates="mobile-demo" class="button-collapse" ><i class="material-icons">menu</i></a>
	      <ul class="right hide-on-med-and-down">
	      <li><a href="/">Inicio </a></li>
	        <li><a href="/videos?destino=${busqueda.destino}">Vídeos</a></li>
	        <li><a href="/weather?destino=${busqueda.destino}">Tiempo</a></li>
	        <li><a href="/imagenes?destino=${busqueda.destino}">Imágenes</a></li>
	        <li><a href="/editPost.jsp?destino=${busqueda.destino}">Facebook</a></li>
	      </ul>
	      <ul class="side-nav" id="mobile-demo">
	      <li><a href="/">Inicio </a></li>
	        <li><a href="/videos?destino=${busqueda.destino}">Vídeos</a></li>
	        <li><a href="/weather?destino=${busqueda.destino}">Tiempo</a></li>
	        <li><a href="/imagenes?destino=${busqueda.destino}">Imágenes</a></li>
	        <li><a href="/editPost.jsp?destino=${busqueda.destino}">Facebook</a></li>
	      </ul>
	    </div>
	    </nav>
    
   <div class="preloader-background">
	<div class="preloader-wrapper big active">
		<div class="spinner-layer spinner-red-only">
			<div class="circle-clipper left">
				<div class="circle"></div>
			</div>
			<div class="gap-patch">
				<div class="circle"></div>
			</div>
			<div class="circle-clipper right">
				<div class="circle"></div>
			</div>
		</div>
	</div>
</div>
  	<main>
		<table class="striped">	
			<tr>		
				<c:forEach items="${requestScope.zomato.restaurants}" var="lista">
					<tr>
					   <td>	<h5>Nombre del restaurante: <c:out value="${lista.restaurant.name}"> </c:out> </h5>
							<p>Calle: <c:out value="${lista.restaurant.location.address}"> </c:out> </p>
							<p>Localidad: <c:out value="${lista.restaurant.location.locality}"> </c:out> </p>
							<p>Ciudad: <c:out value="${lista.restaurant.location.city}"> </c:out> </p>
						    <a href="${lista.restaurant.url}">Url del sitio</a><br>	
					   </td>
	
				</c:forEach>
			</tr>
		</table>	
	</main>		
<%@include file="includes/footer.jsp"%>