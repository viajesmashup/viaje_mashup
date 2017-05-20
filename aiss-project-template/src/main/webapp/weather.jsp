<%@include file="includes/header.jsp"%>


	<nav>
    <div class="nav-wrapper">
      <a href="#!" class="brand-logo">TIEMPO</a>
      <a href="#" data-activates="mobile-demo" class="button-collapse" ><i class="material-icons">menu</i></a>
      <ul class="right hide-on-med-and-down">
      <li><a href="/">Inicio </a></li>
        <li><a href="/videos?destino=${busqueda.destino}">V�deos</a></li>
        <li><a href="/restaurantes?destino=${busqueda.destino}">Restaurantes</a></li>
        <li><a href="/imagenes?destino=${busqueda.destino}">Im�genes</a></li>
        <li><a href="/editPost.jsp?destino=${busqueda.destino}">Facebook</a></li>
      </ul>
      <ul class="side-nav" id="mobile-demo">
      <li><a href="/">Inicio </a></li>
        <li><a href="/videos?destino=${busqueda.destino}">V�deos</a></li>
        <li><a href="/weather?destino=${busqueda.destino}">Tiempo</a></li>
        <li><a href="/imagenes?destino=${busqueda.destino}">Im�genes</a></li>
        <li><a href="/editPost.jsp?destino=${busqueda.destino}">Facebook</a></li>
      </ul>
    </div>
    </nav>
    
   
	
	<table class="striped">	
	
     
    
	<thead >
          <tr>
	
		<h5 > CIUDAD: <c:out value="${weathers.city.name}"></c:out> </h5>
		<h5> PA�S: <c:out value="${weathers.city.country}"></c:out> </h5>
		
		 </tr>
        </thead>
       
        
        <tbody>
		
		<c:forEach items="${requestScope.weathers.list}" var="lista">
			<div>
				
				<tr>
				 <td>
				<p> Fecha y hora: <c:out value="${lista.dt_txt}"></c:out> </p>
				<p> Temperatura: <c:out value="${lista.main.temp}"></c:out> C� </p>
				<p> Temperatura min: <c:out value="${lista.main.temp_min}"></c:out> C� </p>
				<p> Temperatura max: <c:out value="${lista.main.temp_max}"></c:out> C� </p>
				</td>
				</tr>
				
			</div>
				
		</c:forEach>
		</tr>
		</tbody>
	</tr>
	</table>
	</div>

<%@include file="includes/footer.jsp"%>