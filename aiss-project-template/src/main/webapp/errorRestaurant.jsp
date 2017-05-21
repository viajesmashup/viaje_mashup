<%@include file="includes/header.jsp"%>

<nav>
	<div class="nav-wrapper">


		<a href="#!" class="brand-logo">ERROR</a> <a href="#"
			data-activates="mobile-demo" class="button-collapse"><i
			class="material-icons">menu</i></a>
		<ul class="right hide-on-med-and-down">
			<li><a href="/">Inicio </a></li>
			<li><a href="/imagenes?destino=${busqueda.destino}">Imágenes</a></li>
			<li><a href="/videos?destino=${busqueda.destino}">Vídeos</a></li>
			<li><a href="/weather?destino=${busqueda.destino}">Tiempo</a></li>
			<li><a href="/restaurantes?destino=${busqueda.destino}">Restaurantes</a></li>
			<li><a href="/editPost.jsp?destino=${busqueda.destino}">Facebook</a></li>

		</ul>
		<ul class="side-nav" id="mobile-demo">
			<li><a href="/">Inicio </a></li>       
			 <li><a href="/imagenes?destino=${busqueda.destino}">Imágenes</a></li>			
			<li><a href="/videos?destino=${busqueda.destino}">Vídeos</a></li>
			<li><a href="/weather?destino=${busqueda.destino}">Tiempo</a></li>
			<li><a href="/restaurantes?destino=${busqueda.destino}">Restaurantes</a></li>
			<li><a href="/editPost.jsp?destino=${busqueda.destino}">Facebook</a></li>
		</ul>

	</div>
</nav>
<h1>ERROR</h1>
<p>El restaurante de su destino, aún no está en nuestra base de datos. Estamos trabajando para ello, aún así puede buscar otro destino. Disculpe las molestias. </p>

<%@include file="includes/footer.jsp"%>