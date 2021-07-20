<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
		<a href="accueil" style="color: black; text-decoration: none;"><h1>ENI-Enchères</h1></a>
	</header>
	<main class="d-flex flex-wrap justify-content-center">
		<form method="post" action="compte">
			<div class="d-flex flex-wrap justify-content-center">
				<h4>Mon profil</h4>
			</div>

			<!-- Modification du pseudo -->
			<div style="margin-top: 1em">
				<label class="col-4" type="text" for="edit-pseudo"> Pseudo :
				</label> <input class="col-7" id="edit-pseudo" value="${login.pseudo }">
			</div>

			<!-- Modification du nom -->
			<div style="margin-top: 1em">
				<label class="col-4" type="text" for="edit-name"> Nom : </label> <input
					class="col-7" id="edit-name" value="${login.nom }">
			</div>

			<!-- Modification du prénom -->
			<div style="margin-top: 1em">
				<label class="col-4" type="text" for="edit-first-name">
					Prénom : </label> <input class="col-7" id="edit-first-name" value="${login.prenom }">
			</div>

			<!-- Modification de l'email -->
			<div style="margin-top: 1em">
				<label class="col-4" type="text" for="edit-email"> Email : </label>
				<input class="col-7" id="edit-email" value="${login.email }">
			</div>

			<!-- Modification du numéro de téléphone -->
			<div style="margin-top: 1em">
				<label class="col-4" type="text" for="edit-telephone">
					Téléphone : </label> <input class="col-7" id="profile-telephone" type="tel" value="${login.telephone }">
			</div>

			<!-- Modification de la rue -->
			<div style="margin-top: 1em">
				<label class="col-4" type="text" for="profile-street"> Rue :
				</label> <input class="col-7" id="edit-street" value="${login.rue }">
			</div>

			<!-- Modification du code postal -->
			<div style="margin-top: 1em">
				<label class="col-4" type="text" for="edit-zip-code">Code
					postal : </label> <input class="col-7" id="edit-zip-code" type="number" value="${login.codePostal }">
			</div>

			<!-- Modification de la ville-->
			<div style="margin-top: 1em">
				<label class="col-4" type="text" for="edit-city"> Ville : </label> <input
					class="col-7" id="edit-city" value="${login.ville }">
			</div>

			<!-- Modification du mot de passe -->
			<div style="margin-top: 1em">
				<label class="col-4 control-label" type="text" for="edit-password">
					Mot de passe actuel : </label> <input class="col-7" id="edit-password" type="password">
			</div>

			<!-- Nouveau mot de passe-->
			<div style="margin-top: 1em">
				<label class="col-4 control-label" type="text"
					for="edit-new-password"> Nouveau mot de passe : </label> <input
					class="col-7" id="edit-new--password" type="password">
			</div>

			<!-- Confirmation nouveau mot de passe -->
			<div style="margin-top: 1em">
				<label class="col-4" type="text" for="edit-confirmation">
					Confirmation : </label> 
					<input class="col-7" id="edit-confirmation" type="password">
			</div>
				<br>
				<!-- Récupérer le crédit de l'utilisateur dans value  -->
			</div>

			<!-- Enregistrer et supprimer le compte -->
			<div class="d-flex flex-wrap justify-content-center">
				<div style="margin-top: 1em">
					<input type="submit" value="Enregistrer"
						class="btn-modifier d-flex flex-wrap justify-content-center shadow p-3 mb-5 bg-white rounded ">
				</div>
		</form>
		<form method="post" action="accueil">
				<div style="margin-top: 1em">
				<input type="hidden" name="suppression-compte" value="true">
					<input type="submit" 
					class="btn-modifier d-flex flex-wrap justify-content-center shadow p-3 mb-5 bg-white rounded "
					value="Supprimer mon compte">
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