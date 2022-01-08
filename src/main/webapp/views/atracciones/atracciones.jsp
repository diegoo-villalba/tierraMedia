<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link href="https://fonts.googleapis.com/css2?family=Staatliches&display=swap" rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<jsp:include page="/ini.jsp"></jsp:include>


<style>
:root { -
	-primarioOscuro: #a9b7d4;
	--fuentePrincipal: 'Staatliches', cursive;
}

html {
    box-sizing: border-box;
    font-size: 100.0%;
}

*, *:before, *:after {
    box-sizing: inherit;
}

.grid {
	display: grid;
	grid-template-columns: repeat(2, 1fr);
	gap: 1rem; /*Column-gap y row-gap todo en 1 */
}

@media (min-width: 768px) {
    .grid{
        grid-template-columns: repeat(3, 1fr); /* Si quiero CENTRAR cotenido lo HAGO CON FLEXBOX, SI VOY A POSICIONAR ELEMENTOs lo HAGO CON GRID*/
    }
}

img {
    width: 100%;
}

p {
    font-size: 1.8rem;
    font-family: Arial, Helvetica, sans-serif;

}

a { /* Para sacar el interlineado de la parte inferior de los enlaces*/
    text-decoration: none;
}

h1 {
    text-align: center;
    color: var(--secundario);
    font-size: 4rem;
    font-family: var(--fuentePrincipal);
}

.container {
	max-width: 120rem;
	margin: 0 auto; /* Para centrar el contenido */
}

.product {
	background-color: var(- -primarioOscuro);
	padding: 1rem;
}

.product__name {
	font-size: 1.75rem;
}

.product__info {
	font-size: 1.25rem;
	color: rgb(0, 0, 0);
}

.product_image {
	text-align: center;
}

.product__name, .product__button, .product__info {
	font-family: var(- -fuentePrincipal);
	margin: 1rem 0;
	text-align: center;
}
</style>
<title>Turismo en la Tierra Media</title>
</head>



<body background="/TierraMedia/img/regul.jpg">
<jsp:include page="/barra/navi.jsp"></jsp:include> 
	<main class="container">
		<h1>Estas son las atracciones de la tierra media</h1>
		
		<div class="grid">
			
			<div class="product">
				<img class="img-thumbnail product_image"
					src="/TierraMedia/img/moria2.jpg" alt="Imagen atraccion" width="140"
					height="140">
				<div>
					<p class="product__name">Moria</p>
					<p class="product__info">Lorem ipsum dolor sit amet,
						consectetur adipiscing elit. Cras consectetur pulvinar risus eget
						placerat. Etiam consectetur elementum hendrerit. Donec id
						tincidunt orci.</p>
				</div>
				<p class="product__button">
					<a class="btn btn-secondary product__button"
						href="/TierraMedia/atracciones/index.do">Comprar</a>
				</p>
			</div>


			<div class="product">
				<img class="img-thumbnail product_image"
					src="/TierraMedia/img/minasTirith.jpg" alt="Imagen atraccion"
					width="140" height="140">
				<p class="product__name">Minas Tirith</p>
				<p class="product__info">Lorem ipsum dolor sit amet, consectetur
					adipiscing elit. Cras consectetur pulvinar risus eget placerat.
					Etiam consectetur elementum hendrerit. Donec id tincidunt orci.</p>

				<p class="product__button">
					<a class="btn btn-secondary"
						href="/TierraMedia/atracciones/index.do">Comprar</a>
				</p>
			</div>

			<div class="product">
				<img class="img-thumbnail product_image" src="/TierraMedia/img/comarca.jpg"
					alt="Imagen atraccion" width="140" height="140">
				<p class="product__name">La Comarca</p>
				<p class="product__info">Lorem ipsum dolor sit amet, consectetur
					adipiscing elit. Cras consectetur pulvinar risus eget placerat.
					Etiam consectetur elementum hendrerit. Donec id tincidunt orci.</p>

				<p class="product__button">
					<a class="btn btn-secondary product__button"
						href="/TierraMedia/atracciones/index.do">Comprar</a>
				</p>
			</div>

			<div class="product">
				<img class="img-thumbnail product_image" src="/TierraMedia/img/mordor.jpg"
					alt="Imagen atraccion" width="140" height="140">
				<p class="product__name">Mordor</p>
				<p class="product__info">Lorem ipsum dolor sit amet, consectetur
					adipiscing elit. Cras consectetur pulvinar risus eget placerat.
					Etiam consectetur elementum hendrerit. Donec id tincidunt orci.</p>

				<p class="product__button">
					<a class="btn btn-secondary product__button"
						href="/TierraMedia/atracciones/index.do">Comprar</a>
				</p>
			</div>

			<div class="product">
				<img class="img-thumbnail product_image" src="/TierraMedia/img/abismo.jpg"
					alt="Imagen atraccion" width="140" height="140">
				<p class="product__name">Abismo de Helm</p>
				<p class="product__info">Lorem ipsum dolor sit amet, consectetur
					adipiscing elit. Cras consectetur pulvinar risus eget placerat.
					Etiam consectetur elementum hendrerit. Donec id tincidunt orci.</p>

				<p class="product__button">
					<a class="btn btn-secondary product__button"
						href="/TierraMedia/atracciones/index.do">Comprar</a>
				</p>
			</div>

			<div class="product">
				<img class="img-thumbnail product_image" src="/TierraMedia/img/lothlorien.jpg"
					alt="Imagen atraccion" width="140" height="140">
				<p class="product__name">Lothlorien</p>
				<p class="product__info">Lorem ipsum dolor sit amet, consectetur
					adipiscing elit. Cras consectetur pulvinar risus eget placerat.
					Etiam consectetur elementum hendrerit. Donec id tincidunt orci.</p>

				<p class="product__button">
					<a class="btn btn-secondary product__button"
						href="/TierraMedia/atracciones/index.do">Comprar</a>
				</p>
			</div>

			<div class="product">
				<img class="img-thumbnail product_image" src="/TierraMedia/img/erebor.jpg"
					alt="Imagen atraccion" width="140" height="140">
				<p class="product__name">Erebor</p>
				<p class="product__info">Lorem ipsum dolor sit amet, consectetur
					adipiscing elit. Cras consectetur pulvinar risus eget placerat.
					Etiam consectetur elementum hendrerit. Donec id tincidunt orci.</p>

				<p class="product__button">
					<a class="btn btn-secondary product__button"
						href="/TierraMedia/atracciones/index.do">Comprar</a>
				</p>
			</div>

			<div class="product">
				<img class="img-thumbnail product_image" src="/TierraMedia/img/bosqueNegro.jpg"
					alt="Imagen atraccion" width="140" height="140">
				<p class="product__name">Bosque Negro</p>
				<p class="product__info">Lorem ipsum dolor sit amet, consectetur
					adipiscing elit. Cras consectetur pulvinar risus eget placerat.
					Etiam consectetur elementum hendrerit. Donec id tincidunt orci.</p>

				<p class="product__button">
					<a class="btn btn-secondary product__button"
						href="/TierraMedia/atracciones/index.do">Comprar</a>
				</p>
			</div>
			
			<div class="product">
				<img class="img-thumbnail product_image" src="/TierraMedia/img/tierramedia.jpg"
					alt="Imagen atraccion" width="140" height="140">
				<p class="product__name">Far West</p>
				<p class="product__info">Lorem ipsum dolor sit amet, consectetur
					adipiscing elit. Cras consectetur pulvinar risus eget placerat.
					Etiam consectetur elementum hendrerit. Donec id tincidunt orci.</p>

				<p class="product__button">
					<a class="btn btn-secondary product__button"
						href="/TierraMedia/atracciones/index.do">Comprar</a>
				</p>
			</div>

		</div>
	</main>
	
	<footer class="page-footer font-small teal pt-4 bg-dark text-white"
		style="background-color: rgba(0, 0, 0, 0.2);">
	<jsp:include page="/foot.jsp"></jsp:include>
	</footer>
</body>
</html>