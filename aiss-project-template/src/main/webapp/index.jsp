
<%@include file="includes/header.jsp"%>
	<div class="parallax-container">
		<div class="parallax">
			<img src="images/parallax1.jpg">
		</div>
	</div>



	<h1 class="header center black-text">Búsqueda de Restaurantes</h1>

	<nav class="black">
		<div class="nav-wrapper">
			<form id="searchForm" action="/imagenes" method="get">
				<div class="input-field">
					<input id="destino" type="search" id="destino" name="destino"
						placeholder="Destino" required /> <label
						 class="label-icon" for="search"><i class="material-icons">search</i></label>
					<i class="material-icons">close</i>
				</div>
			</form>
		</div>
	</nav>

	<div class="container">
		<div class="section">

			<!--   Icon Section   -->
			<div class="row">
				<div class="col s12 m3">
					<div class="icon-block">
						<h2 class="center">
							<i class="material-icons medium">perm_media</i>
						</h2>
						<h5 class="center">Mejores Imágenes</h5>

						<p class="light">Te ofrecemos las mejores imágenes de tu destino para que tengas una idea y lo mas importante, ¡que no te pierdas ni un solo detalle!</p>
					</div>
				</div>

				<div class="col s12 m3">
					<div class="icon-block">
						<h2 class="center">
							<i class="material-icons medium">videocam</i>
						</h2>
						<h5 class="center">Videos Relacionados</h5>

						<p class="light">Están a tu disposición videos relacionados con tu destino .</p>
					</div>
				</div>

				<div class="col s12 m3">
					<div class="icon-block">
						<h2 class="center">
							<i class="material-icons medium">my_location</i>
						</h2>
						<h5 class="center">Localiza Tu Restaurante</h5>

						<p class="light">Si necesitas saber restaurantes donde comer tendras una amplia lista de restaurantes con su localización y un enlace donde podras ver imágenes, opiniones, etc..</p>
					</div>
				</div>

				<div class="col s12 m3">
					<div class="icon-block">
						<h2 class="center">
							<i class="material-icons medium">settings_brightness</i>
						</h2>
						<h5 class="center">Tiempo</h5>

						<p class="light">Podras ver el tiempo de los días que te interesen y en el lugar que quieras.</p>
					</div>
				</div>
			</div>
		</div>
	</div>

	<br>

	<div class="parallax-container">
		<div class="parallax">
			<img src="images/restaurante.jpg">
		</div>
	</div>

<%@include file="includes/footer.jsp"%>
