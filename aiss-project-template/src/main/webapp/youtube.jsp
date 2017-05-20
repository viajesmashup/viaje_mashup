<%@include file="includes/header.jsp"%>
	

<nav>
    <div class="nav-wrapper">
      <a href="#!" class="brand-logo">VIDEOS</a>
      <a href="#" data-activates="mobile-demo" class="button-collapse" ><i class="material-icons">menu</i></a>
      <ul class="right hide-on-med-and-down">
      <li><a href="/">Inicio </a></li>
        <li><a href="/imagenes?destino=${busqueda.destino}">Imágenes</a></li>
        <li><a href="/weather?destino=${busqueda.destino}">Tiempo</a></li>
        <li><a href="/restaurantes?destino=${busqueda.destino}">Restaurantes</a></li>
        <li><a href="/editPost.jsp?destino=${busqueda.destino}">Facebook</a></li>
      </ul>
      <ul class="side-nav" id="mobile-demo">
      <li><a href="/">Inicio </a></li>
        <li><a href="/imagenes?destino=${busqueda.destino}">Imágenes</a></li>
        <li><a href="/weather?destino=${busqueda.destino}">Tiempo</a></li>
        <li><a href="/restaurantes?destino=${busqueda.destino}">Restaurantes</a></li>
        <li><a href="/editPost.jsp?destino=${busqueda.destino}">Facebook</a></li>
      </ul>
    </div>
  </nav>

<%@include file="includes/footer.jsp"%>




	<c:forEach items="${requestScope.videos}" var="video">
		<div>
			<iframe width="100%" height="400px"
				src="https://www.youtube.com/embed/<c:out value="${video.id.videoId}"></c:out>"
				frameborder="1" allowfullscreen></iframe>

		</div>
		<br>
	</c:forEach>

