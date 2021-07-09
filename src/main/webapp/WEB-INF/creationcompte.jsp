<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link href="index.css" rel="stylesheet">
        <meta charset="UTF-8">
        <title>Création</title>
        <meta name ="Profil">
    </head>
    <body>
        <header class="offset-2 col-10">
            <h1>ENI-Enchères</h1>
        </header>
        
        <div class="col-12 d-flex flex-wrap justify-content-center">${ erreur }</div>
	<main class="d-flex flex-wrap justify-content-center">
	    <form method="post" action="compte-creation">
	        <div class="d-flex flex-wrap justify-content-center"> <h1>Créer un compte</h1>
	        </div>
	        <div class="corps-connexion-infos col-12">
	           <div style="margin-top:1em">
	          <label class="col-4" for="profile-pseudo"> Pseudo : </label>
	          <input type="text" class="col-7" id="profile-pseudo" name="create-pseudo">
	                </div>
	        <div class="corps-connexion-infos col-12">
	            <div style="margin-top:1em">
	            <label class="col-4" for="profile-name"> Nom : </label>
	            <input type="text" class="col-7" id="profile-name" name="create-nom">
	          </div>
	          <div class="corps-connexion-infos col-12r">
	            <div style="margin-top:1em">
	            <label class="col-4" for="profile-first-name"> Prénom : </label>
	             <input type="text" class="col-7" id="profile-first-name" name="create-prenom">
	          </div>
	          <div class="corps-connexion-infos col-12">
	            <div style="margin-top:1em">
	            <label class="col-4" for="profile-email"> Email : </label>
	            <input type="text" class="col-7" id="profile-email" name="create-email">
	          </div>
	          <div class="corps-connexion-infos col-12">
	            <div style="margin-top:1em">
	            <label class="col-4" for="profile-telephone"> Téléphone : </label>
	            <input type="tel" class="col-7" id="profile-telephone" name="create-telephone">
	          </div>
	          <div class="corps-connexion-infos col-12">
	            <div style="margin-top:1em">
	            <label class="col-4" for="profile-street"> Rue : </label>
	            <input type="text" class="col-7" id="profile-street" name="create-rue">
	          </div>
	          <div class="corps-connexion-infos col-12">
	            <div style="margin-top:1em">
	            <label class="col-4" for="profile-zip-code">Code postal : </label>
	            <input type="number" class="col-7" id="profile-zip-code" name="create-code-postal">
	          </div>
	          <div class="corps-connexion-infos col-12r">
	            <div style="margin-top:1em">
	            <label class="col-4" for="profile-city"> Ville : </label>
	             <input type="text" class="col-7" id="profile-city" name="create-ville">
	          </div>
	
	          <div class="corps-connexion-infos col-12r">
	            <div class="form-group">
	            <div style="margin-top:1em">
	            <label class="col-4 control-label" for="profile-password"> Mot de passe : </label>
	             <input type="password" class="col-7" id="profile-password" name="create-motDePasse">
	            </div>
	
	          <div class="corps-connexion-infos col-12r">
		          <div style="margin-top:1em">
			          <label class="col-4" for="profile-confirmation"> Confirmation : </label>
			          <input type="password" class="col-7" id="profile-confirmation" name="create-motDePasse-verif">
		          </div>
	          </div>
	          
	        <div class="container d-flex flex-nowrap justify-content-center">
	          <div class="d-flex flex-wrap justify-content-center">
		          <div style="margin-top:1em">
		            <input type="submit" class="btn-modifier d-flex flex-wrap justify-content-center shadow p-3 mb-5 bg-white rounded" value="Créer">
		          </div>
	        </form>
		          <div style="margin-top:1em">
		          <form method="post" action="accueil">
		            <input type="submit" class="btn-modifier d-flex flex-wrap justify-content-center shadow p-3 mb-5 bg-white rounded " value="Annuler">
		          </div>
		          </form>
	          </div>
		</main>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</html>