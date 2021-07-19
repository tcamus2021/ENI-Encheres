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
<link href="index.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Modification</title>
<meta name="Profil">
</head>

<!-- Modification du profil -->

<body>
	<header class="offset-2 col-10">
		<h1>ENI-Enchères</h1>
	</header>
	<main class="d-flex flex-wrap justify-content-center">
		<form>
			<div class="d-flex flex-wrap justify-content-center">
				<h4>Mon profil</h4>
			</div>

			<!-- Modification du pseudo -->
			<div style="margin-top: 1em">
				<label class="col-4" type="text" for="edit-pseudo"> Pseudo :
				</label> <input class="col-7" id="edit-pseudo">
			</div>

			<!-- Modification du nom -->
			<div style="margin-top: 1em">
				<label class="col-4" type="text" for="edit-name"> Nom : </label> <input
					class="col-7" id="edit-name">
			</div>

			<!-- Modification du prénom -->
			<div style="margin-top: 1em">
				<label class="col-4" type="text" for="edit-first-name">
					Prénom : </label> <input class="col-7" id="edit-first-name">
			</div>

			<!-- Modification de l'email -->
			<div style="margin-top: 1em">
				<label class="col-4" type="text" for="edit-email"> Email : </label>
				<input class="col-7" id="edit-email">
			</div>

			<!-- Modification du numéro de téléphone -->
			<div style="margin-top: 1em">
				<label class="col-4" type="text" for="edit-telephone">
					Téléphone : </label> <input class="col-7" id="profile-telephone">
			</div>

			<!-- Modification de la rue -->
			<div style="margin-top: 1em">
				<label class="col-4" type="text" for="profile-street"> Rue :
				</label> <input class="col-7" id="edit-street">
			</div>

			<!-- Modification du code postal -->
			<div style="margin-top: 1em">
				<label class="col-4" type="text" for="edit-zip-code">Code
					postal : </label> <input class="col-7" id="edit-zip-code">
			</div>

			<!-- Modification de la ville-->
			<div style="margin-top: 1em">
				<label class="col-4" type="text" for="edit-city"> Ville : </label> <input
					class="col-7" id="edit-city">
			</div>

			<!-- Modification du mot de passe -->
			<div style="margin-top: 1em">
				<label class="col-4 control-label" type="text" for="edit-password">
					Mot de passe atcuel : </label> <input class="col-7" id="edit-password">
			</div>

			<!-- Nouveau mot de passe-->
			<div style="margin-top: 1em">
				<label class="col-4 control-label" type="text"
					for="edit-new-password"> Nouveau mot de passe : </label> <input
					class="col-7" id="edit-new--password">
			</div>

			<!-- Confirmation nouveau mot de passe -->
			<div style="margin-top: 1em">
				<label class="col-4" type="text" for="edit-confirmation">
					Confirmation : </label> <input class="col-7" id="edit-confirmation">
			</div>

			<!-- Crédit -->
			<div style="margin-top: 1em">
				<label class="col-4" for="edit-credit"> Crédit : </label> <input
					type="text" id="edit-credit" class="col-7" value="000" readonly>
				<br>
				<br>
				<!-- Récupérer le crédit de l'utilisateur dans value  -->
			</div>

			<!-- Enregistrer et supprimer le compte -->
			<div class="d-flex flex-wrap justify-content-center">
				<div style="margin-top: 1em">
					<input type="submit" value="Enregistrer"
						class="btn-modifier d-flex flex-wrap justify-content-center shadow p-3 mb-5 bg-white rounded ">
				</div>
				<div style="margin-top: 1em">
					<button
						class="btn-modifier d-flex flex-wrap justify-content-center shadow p-3 mb-5 bg-white rounded ">
						Supprimer mon compte</button>
				</div>
			</div>
		</form>
	</main>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>

</html>