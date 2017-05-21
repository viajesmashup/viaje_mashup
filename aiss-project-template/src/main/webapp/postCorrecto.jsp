<%@include file="includes/header.jsp"%>

<nav>
	<div class="nav-wrapper">


		<a href="#!" class="brand-logo">Post Creado</a> <a href="#"
			data-activates="mobile-demo" class="button-collapse"><i
			class="material-icons">menu</i></a>
		<ul class="right hide-on-med-and-down">
			<li><a href="/">Inicio </a></li>
			<li><a href="/imagenes?destino=${busqueda.destino}">Im�genes</a></li>
			<li><a href="/videos?destino=${busqueda.destino}">V�deos</a></li>
			<li><a href="/weather?destino=${busqueda.destino}">Tiempo</a></li>
			<li><a href="/restaurantes?destino=${busqueda.destino}">Restaurantes</a></li>
			<li><a href="/editPost.jsp?destino=${busqueda.destino}">Facebook</a></li>

		</ul>
		<ul class="side-nav" id="mobile-demo">
			<li><a href="/">Inicio </a></li>       
			 <li><a href="/imagenes?destino=${busqueda.destino}">Im�genes</a></li>			
			<li><a href="/videos?destino=${busqueda.destino}">V�deos</a></li>
			<li><a href="/weather?destino=${busqueda.destino}">Tiempo</a></li>
			<li><a href="/restaurantes?destino=${busqueda.destino}">Restaurantes</a></li>
			<li><a href="/editPost.jsp?destino=${busqueda.destino}">Facebook</a></li>
		</ul>

	</div>
</nav>
<main>

<h1>�El post ha sido enviado correctamente!</h1>


</main>
<%@include file="includes/footer.jsp"%>