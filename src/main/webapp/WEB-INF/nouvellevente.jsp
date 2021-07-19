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
<title>Nouvelle vente</title>
<meta name="sale">

</head>
<body>
	<header class="offset-2 col-10">
		<h1>ENI-Enchères</h1>
	</header>

	<main class="d-flex flex-wrap justify-content-center">
		<form>
			<div style="margin-top: 1em">
				<div class="d-flex flex-wrap">
					<h5>Nouvelle vente</h5>
				</div>

				<div class="corps-connexion-infos col-12">
					<div style="margin-top: 1em">
						<label class="col-5" type="text" for="sale-article">
							Article : </label> <input class="col-6" id="sale-article">
					</div>

					<!--  Catégorie-->
					<div class="input-group mb-3" style="margin-top: 1em">
						<label class="input-group-text" for="inputGroupSelect01">Catégories</label>
						<select class="form-select" id="inputGroupSelect01">
							<option selected>Toutes</option>
							<option value="1">Informatique</option>
							<option value="2">Ameublement</option>
							<option value="3">Vêtement</option>
							<option value="3">Sport & Loisirs</option>
						</select>
					</div>

					<div class="mb-3">
						<label for="exampleFormControlTextarea1" class="form-label">Description</label>
						<textarea class="form-control" id="exampleFormControlTextarea1"
							rows="3"></textarea>
					</div>
					<!--  -->

					<!-- Photo de l'article à gauche de l'écran  ppur le desktop-->
					<!-- Photo de l'article -->
					<div class="corps-connexion-infos col-12" style="margin-top: 1em">
						<label class="form-label" for="auction-picture"> Photo de
							l'article : </label> <input class="form-control" type="file"
							id="auction-picture" name="file">

					</div>
				</div>

				<!-- prix inital -->
				<div class="corps-connexion-infos col-12" style="margin-top: 1em">
					<label class="col-5" for="auction starting price"> Mise à
						prix :</label> <input class="col-6" type="number"
						id="auction starting price" min="0">
				</div>

				<!-- Début de l'enchère -->
				<div class="corps-connexion-infos col-12" style="margin-top: 1em">
					<label id="auction-start" for="auction-start"> Début de
						l'enchère : </label> <input type="date" class="col-6"
						class="bootstrap-datepicker" data-date-format="mm/dd/yyyy"
						id="auction-start">
				</div>

				<!-- Fin de l'enchère -->
				<div class="corps-connexion-infos col-12" style="margin-top: 1em">
					<label class="col-5" id="auction-end" for="auction-end">
						Fin de l'enchère : </label> <input type="date" class="col-6"
						class="bootstrap-datepicker" data-date-format="mm/dd/yyyy"
						id="auction-start">
				</div>

				<!-- Retrait, par défaut adresse du vendeur -->
				<section class="border" style="margin-top: 1em">
					<label class="col-5" for="auction-adress"> Retrait </label>
					<!-- Rue -->
					<div class="corps-connexion-infos col-12" style="margin-top: 1em">
						<label class="col-5" type="text" for="auction-street"> Rue
							: </label> <input class="col-6" id="auction-street">
					</div>

					<!-- Code postal -->
					<div class="corps-connexion-infos col-12" style="margin-top: 1em">
						<label class="col-5" type="text" for="auction-end"> Code
							postal : </label> <input class="col-6" id="auction-end">
					</div>

					<!-- Ville -->
					<div class="corps-connexion-infos col-12" style="margin-top: 1em">
						<label class="col-5" type="text" for="auction-end"> Ville
							: </label> <input class="col-6" id="auction-end"
							style="margin-bottom: 1em">
					</div>
				</section>

				<!-- Enregistrer nouvelle vente ou annuler -->
				<section>
					<form class="form-inline"></form>
					<div class="d-flex flex-wrap justify-content-center"
						style="margin-top: 1em">
						<input type="submit" value="Enregistrer"
							class="btn-modifier d-flex flex-wrap justify-content-center shadow p-3 mb-5 bg-white rounded ">
						<button
							class="btn-modifier d-flex flex-wrap justify-content-center shadow p-3 mb-5 bg-white rounded ">
							Annuler</button>
					</div>
				</section>
		</form>

	</main>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
</html>