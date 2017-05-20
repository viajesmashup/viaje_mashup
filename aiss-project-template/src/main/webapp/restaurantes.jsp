<%@include file="includes/header.jsp"%>



<nav>
    <div class="nav-wrapper">
      <a href="#!" class="brand-logo">RESTAURANTES</a>
      <a href="#" data-activates="mobile-demo" class="button-collapse" ><i class="material-icons">menu</i></a>
      <ul class="right hide-on-med-and-down">
      <li><a href="/">Inicio </a></li>
        <li><a href="/videos?&destino=${busqueda.destino}">V�deos</a></li>
        <li><a href="/weather?&destino=${busqueda.destino}">Tiempo</a></li>
        <li><a href="/imagenes?destino=${busqueda.destino}">Im�genes</a></li>
        <li><a href="/editPost.jsp?&destino=${busqueda.destino}">facebook</a></li>
      </ul>
      <ul class="side-nav" id="mobile-demo">
      <li><a href="/">Inicio </a></li>
        <li><a href="/videos?&destino=${busqueda.destino}">V�deos</a></li>
        <li><a href="/weather?&destino=${busqueda.destino}">Tiempo</a></li>
        <li><a href="/imagenes?destino=${busqueda.destino}">Im�genes</a></li>
        <li><a href="/editPost.jsp?&destino=${busqueda.destino}">facebook</a></li>
      </ul>
    </div>
    </nav>
    
   
  			
		<table class="striped">	
		<tr>		
		<c:forEach items="${requestScope.zomato.restaurants}" var="lista">
					<tr>
						<!--  <div class="divider"style="border: 2px solid black" ></div>
						<div class="section">-->
						   <td>	<h5>Nombre del restaurante: <c:out value="${lista.restaurant.name}"> </c:out> </h5>
							<p>Calle: <c:out value="${lista.restaurant.location.address}"> </c:out> </p>
							<p>Localidad: <c:out value="${lista.restaurant.location.locality}"> </c:out> </p>
							<p>Ciudad: <c:out value="${lista.restaurant.location.city}"> </c:out> </p>
						    <a href="${lista.restaurant.url}">Url del sitio</a><br>	
						    </td>
						</div>
				
					</c:forEach>
					</tr>
					</table>			
<%@include file="includes/footer.jsp"%>