<%@include file="includes/header.jsp"%>
	<nav>
    <div class="nav-wrapper">
      <a href="#!" class="brand-logo">PUBLICAR POST EN FACEBOOK</a>
      <a href="#" data-activates="mobile-demo" class="button-collapse" ><i class="material-icons">menu</i></a>
      <ul class="right hide-on-med-and-down">
      <li><a href="/">Inicio </a></li>
        <li><a href="/videos?destino=${busqueda.destino}">Vídeos</a></li>
        <li><a href="/weather?destino=${busqueda.destino}">Tiempo</a></li>
        <li><a href="/restaurantes?destino=${busqueda.destino}">Restaurantes</a></li>
        <li><a href="/imagenes?destino=${busqueda.destino}">Imágenes</a></li>
      </ul>
      <ul class="side-nav" id="mobile-demo">
      <li><a href="/">Inicio </a></li>
        <li><a href="/videos?destino=${busqueda.destino}">Vídeos</a></li>
        <li><a href="/weather?destino=${busqueda.destino}">Tiempo</a></li>
        <li><a href="/restaurantes?destino=${busqueda.destino}">Restaurantes</a></li>
        <li><a href="/imagenes?destino=${busqueda.destino}">Imágenes</a></li>
      </ul>
    </div>
  </nav>
	
	
	
	
        
<main>
	
	<div class="container">
	
		<p class="message"></p>
				
	
			
		 <div class="row">
		  	<form action="/facebookPostCreation" method="post"  class="col s12">
		      <div class="row">
		        <div class="input-field col s6">
		          <i class="material-icons prefix">mode_edit</i>
		          <textarea name ="message" id="icon_prefix2" class="materialize-textarea"></textarea>
		          <label for="icon_prefix2"></label>
		          
		          <br>
					<div class="bottom_links">
						<button type="submit" class="waves-effect waves-light btn"><i class="material-icons left">mode_edit</i>Publicar en Facebook</button>
						<button type="button" onClick="javascript:window.location.href='index.jsp'" class="waves-effect waves-light btn"><i class="material-icons left">mode_edit</i>Cancelar</button>
					</div>
		          
		        </div>
		      </div>
		    </form>
		  </div>
			
	
	</div>
</main>
<%@include file="includes/footer.jsp"%>
