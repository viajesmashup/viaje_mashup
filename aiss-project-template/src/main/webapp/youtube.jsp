<%@include file="includes/header.jsp"%>
	

<nav>
    <div class="nav-wrapper">
      <a href="/videos?destino=${busqueda.destino}" class="brand-logo">VIDEOS</a>
      <a href="#" data-activates="mobile-demo" class="button-collapse" ><i class="material-icons">menu</i></a>
      <ul class="right hide-on-med-and-down">
      <li><a href="/">Inicio </a></li>
        <li><a href="/imagenes?destino=${busqueda.destino}">Im�genes</a></li>
        <li><a href="/weather?destino=${busqueda.destino}">Tiempo</a></li>
        <li><a href="/restaurantes?destino=${busqueda.destino}">Restaurantes</a></li>
        <li><a href="/editPost.jsp?destino=${busqueda.destino}">Facebook</a></li>
      </ul>
      <ul class="side-nav" id="mobile-demo">
      <li><a href="/">Inicio </a></li>
        <li><a href="/imagenes?destino=${busqueda.destino}">Im�genes</a></li>
        <li><a href="/weather?destino=${busqueda.destino}">Tiempo</a></li>
        <li><a href="/restaurantes?destino=${busqueda.destino}">Restaurantes</a></li>
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


	<c:forEach items="${requestScope.videos}" var="video">
		<div>
			<iframe width="100%" height="400px"
				src="https://www.youtube.com/embed/<c:out value="${video.id.videoId}"></c:out>"
				frameborder="1" allowfullscreen></iframe>

		</div>
		<br>
	</c:forEach>
</main>
<%@include file="includes/footer.jsp"%>