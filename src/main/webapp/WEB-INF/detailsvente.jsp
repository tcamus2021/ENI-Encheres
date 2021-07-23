<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">

<link href="index.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Détail vente</title>
<meta name="details">
</head>

<body>
	<header class="offset-2 col-10">
		<h1>ENI-Enchères</h1>
	</header>

	<main class="d-flex flex-wrap justify-content-center">
		<div class="container" style="margin-top: 1em">
			<div class="d-flex flex-wrap justify-content-center">
				<h4>Détail vente</h4>
			</div>
		</div>

		<dl class="row">
			<div class="d-flex flex-wrap justify-content-center">
				<dd class="col-9" style="margin-top: 1em; margin-left: 1em">
					Licorne à vendre</dd>
			</div>
			<!-- Photo de l'article à gauche de l'écran  ppur le desktop -->
			<!-- Photo de l'article -->
			<div class="col-12" style="margin-top: 1em">
				<img class="img-responsive center-block d-block mx-auto"
					src="licorne.jpg" alt="Licorne">
			</div>

			<!--Description -->
			<div class="d-flex flex-wrap justify-content-center">
				<dd class="col-2" style="margin-top: 1em; margin-left: 2em">
					Description :</dd>
				<dd class="col-7" style="margin-top: 1em">Licorne à vendre,
					1000 ans, prix non négotiable</dd>
			</div>

			<!--Catégorie-->
			<div class="d-flex flex-wrap justify-content-center">
				<dd class="col-2" style="margin-top: 1em; margin-left: 2em">
					Catégories :</dd>
				<dd class="col-7" style="margin-top: 1em">Sport & loisirs</dd>
			</div>

			<!-- Meilleure offre, récupérer nom de l'utilisateur-->
			<div class="d-flex flex-wrap justify-content-center">
				<dd class="col-2" style="margin-top: 1em; margin-left: 2em">
					Meilleure offre :</dd>
				<dd class="col-7" style="margin-top: 1em">600 points par
					Georgette</dd>
			</div>

			<!-- prix inital-->
			<div class="d-flex flex-wrap justify-content-center">
				<dd class="col-2" style="margin-top: 1em; margin-left: 2em">
					Mise à prix :</dd>
				<dd class="col-7" style="margin-top: 1em">300 points</dd>
			</div>

			<!-- Fin de l'enchère -->
			<div class="d-flex flex-wrap justify-content-center">
				<dd class="col-2" style="margin-top: 1em; margin-left: 2em">
					Fin de l'enchère :</dd>
				<dd class="col-7" style="margin-top: 1em">21/09/2021</dd>
			</div>

			<!-- Retrait, par défaut adresse du vendeur-->
			<div class="d-flex flex-wrap justify-content-center">
				<dd class="col-2" style="margin-top: 1em; margin-left: 2em">
					Retrait :</dd>
				<dd class="col-7" style="margin-top: 1em">
					10 chemin des pêcheurs <br> 29000 Quimper
				</dd>
			</div>

			<!-- Vendeur-->
			<div class="d-flex flex-wrap justify-content-center">
				<dd class="col-2" style="margin-top: 1em; margin-left: 2em">
					Vendeur :</dd>
				<dd class="col-7" style="margin-top: 1em">René</dd>
			</div>
		</dl>

		<!-- Ma proposition-->
		<div class="col-12 d-flex flex-wrap">
			<dd class="col-2" style="margin-top: 1em; margin-left: 6em">Ma
				proposition :</dd>
			<input class="col-1" type="number" min="0">
		</div>

		<!-- Enchérir -->
		<div class="d-flex flex-wrap justify-content-center"
			style="margin-top: 1em">
			<button class="btn-modifier shadow p-3 mb-5 bg-white rounded">Enchérir
			</button>
		</div>

		<!--Bouton retour pour la version mobile-->
		<div class="d-flex flex-wrap justify-content-center"
			style="margin-top: 1em">
			<button class="btn-modifier shadow p-3 mb-5 bg-white rounded">Retour
			</button>
		</div>
	</main>
</body>

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>

</html>