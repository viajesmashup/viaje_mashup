<%@include file="includes/header.jsp"%>

<main>

 <nav>
    <div class="nav-wrapper">
      <a href="/imagenes?destino=${busqueda.destino}" class="brand-logo"> IMÁGENES</a>
      <a href="#" data-activates="mobile-demo" class="button-collapse" ><i class="material-icons">menu</i></a>
      <ul class="right hide-on-med-and-down">
      <li><a href="/">Inicio </a></li>
        <li><a href="/videos?destino=${busqueda.destino}">Vídeos</a></li>
        <li><a href="/weather?destino=${busqueda.destino}">Tiempo</a></li>
        <li><a href="/restaurantes?destino=${busqueda.destino}">Restaurantes</a></li>
        <li><a href="/editPost.jsp?destino=${busqueda.destino}">Facebook</a></li>
      </ul>
      <ul class="side-nav" id="mobile-demo">
      <li><a href="/">Inicio </a></li>
        <li><a href="/videos?destino=${busqueda.destino}">Vídeos</a></li>
        <li><a href="/weather?destino=${busqueda.destino}">Tiempo</a></li>
        <li><a href="/restaurantes?destino=${busqueda.destino}">Restaurantes</a></li>
        <li><a href="/editPost.jsp?destino=${busqueda.destino}">Facebook</a></li>
      </ul>
    </div>
  </nav>

 
     <c:forEach items="${requestScope.photos.value}" var="foto">
		<div class= center>
			<img  src="<c:out value="${foto.contentUrl}"></c:out>"
				alt="FotosCiudad" width=100% height=100%s>
				
		</div>
	</c:forEach>
</main>
	
<%@include file="includes/footer.jsp"%>