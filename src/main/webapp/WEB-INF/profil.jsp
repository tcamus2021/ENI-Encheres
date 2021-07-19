<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link href="index.css" rel="stylesheet">
        <meta charset="UTF-8">
        <title>Profil</title>
        <meta name ="Profil">
    </head>
    <body>
        <header class="offset-2 col-10">
            <h1>ENI-Enchères</h1>
        </header>
        <main class="d-flex flex-wrap justify-content-center">
            <form>
                <div class="d-flex flex-wrap justify-content-center"> <h1>${utilisateurVoulu.pseudo }</h1>
                </div>
                <div class="corps-connexion-infos col-12">
                    <div style="margin-top:1em">
                  <label class="col-4" for="profile-pseudo"> Pseudo : </label>
                  <input class="col-7" id="profile-pseudo" disabled 
                     value="${utilisateurVoulu.pseudo }">
                        </div>
                <div class="corps-connexion-infos col-12">
                    <div style="margin-top:1em">
                    <label class="col-4" for="profile-name"> Nom : </label>
                    <input class="col-7" id="profile-name" disabled 
                     value="${utilisateurVoulu.nom }">
                  </div>
                  <div class="corps-connexion-infos col-12r">
                    <div style="margin-top:1em">
                    <label class="col-4" for="profile-first-name"> Prénom : </label>
                     <input type="text" class="col-7" id="profile-first-name" disabled 
                     value="${utilisateurVoulu.prenom }">
                  </div>
                  <div class="corps-connexion-infos col-12">
                    <div style="margin-top:1em">
                    <label class="col-4" for="profile-email"> Email : </label>
                    <input class="col-7" id="profile-email" disabled 
                     value="${utilisateurVoulu.email }">
                  </div>
                  <div class="corps-connexion-infos col-12">
                    <div style="margin-top:1em">
                    <label class="col-4" for="profile-telephone"> Téléphone : </label>
                    <input class="col-7" id="profile-telephone" disabled 
                     value="${utilisateurVoulu.telephone }">
                  </div>
                  <div class="corps-connexion-infos col-12">
                    <div style="margin-top:1em">
                    <label class="col-4" for="profile-street"> Rue : </label>
                    <input class="col-7" id="profile-street" disabled 
                     value="${utilisateurVoulu.rue }">
                  </div>
                  <div class="corps-connexion-infos col-12">
                    <div style="margin-top:1em">
                    <label class="col-4" for="profile-zip-code">Code postal : </label>
                    <input class="col-7" id="profile-zip-code" disabled 
                     value="${utilisateurVoulu.codePostal }">
                  </div>
                  <div class="corps-connexion-infos col-12r">
                    <div style="margin-top:1em">
                    <label class="col-4" for="profile-city"> Ville : </label>
                     <input class="col-7" id="profile-city" disabled 
                     value="${utilisateurVoulu.ville }">
                  </div>
                 
          <c:if test="${monProfil == true }">       
          <div class="d-flex flex-wrap justify-content-center">
            <div style="margin-top:1em">
            <button class="btn-modifier d-flex flex-wrap justify-content-center shadow p-3 mb-5 bg-white rounded "> Modifier</button> 
          </div>
          </c:if>
        </form>
</main>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</html>