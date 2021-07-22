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
        <title>Accueil</title>
        <meta name ="Home">
    </head>
    <body>
        <header class="offset-2 col-10">
            <a href="" style="color: black; text-decoration: none;"><h1>ENI-Enchères</h1></a>
            <c:if test="${login.nom == null }">
            <div class="d-flex position-relative">
              <div> <a href="connexion" class="stretched-link">S'inscrire - Se connecter</a></div>
            </div>
            </c:if>
			<c:if test="${login.nom != null }">
            <div class="d-flex position-relative">
              <div> <a href="accueil" class="stretched-link">Enchères</a></div>
            </div>
            <div class="d-flex position-relative">
              <div> <a href="vente-creation" class="stretched-link">Vendre un article</a></div>
            </div>
            <div class="d-flex position-relative">
              <div> <a href="compte" class="stretched-link">Mon profil</a></div>
            </div>
            <div class="d-flex position-relative">
	              <a href="accueil?deconnexion=true" type="hidden">Déconnexion</a>
            </div>
            </c:if>
        </header>
        <main class="d-flex flex-wrap justify-content-center">
            <form>
              <div style="margin-top:1em">
                <div class="d-flex flex-wrap"> <h5>Filtres : </h5> </div>
                <div class="input-group mb-3">
                  <label class="input-group-text" for="inputGroupSelect01">Catégories</label>
                  <select class="form-select" id="inputGroupSelect01">
                    <option selected>Toutes</option>
                    <option value="1">Informatique</option>
                    <option value="2">Ameublement</option>
                    <option value="3">Vêtement</option>
                    <option value="3">Sport & Loisirs</option>
                  </select>
                </div>
                <section>
                <form class="form-inline"></form>
                  <input class="form-control mr-sm-2" type="search" placeholder="Le nom de l'article contient" aria-label="Search">
                  <div class="d-flex flex-wrap justify-content-center">
                    <div style="margin-top:1em">
                      <button class="btn-modifier d-flex flex-wrap justify-content-center shadow p-3 mb-5 bg-white rounded "> Rechercher </button> 
                    </div>   
                  </section>   
            </form> 

           
			<c:if test="${login.nom != null }">
          <div class="form-check">
            <div style="margin-top:1em">
            <input class="form-check-input" type="radio" name="radio-groupe" id="radio-achats" onclick="griserBtn()">
            <label class="form-check-label" for="flexRadioDefault2">
              Achats
            </label>
          </div>
            <div class="form-check">
              <input class="form-check-input" type="checkbox" value="" id="achat-checkbox1" name="achat-checkbox" disabled="disabled">
              <label class="form-check-label" for="flexCheckDefault">
                Enchères ouvertes
              </label>
            </div>
            <div class="form-check">
              <input class="form-check-input" type="checkbox" value="" id="achat-checkbox2" name="achat-checkbox" disabled="disabled">
              <label class="form-check-label" for="flexCheckChecked">
                Mes enchères 
              </label>
            </div>
            <div class="form-check">
              <input class="form-check-input" type="checkbox" value="" id="achat-checkbox3" name="achat-checkbox" disabled="disabled">
              <label class="form-check-label" for="flexCheckChecked">
                Mes enchères emportées 
              </label>
            </div>
          </div>
            
          <div>
            <div class="form-check">
              <div style="margin-top:1em">
                <input class="form-check-input" type="radio" name="radio-groupe" id="radio-ventes" onclick="griserBtn()">
                <label class="form-check-label" for="flexRadioDefault2">
                Mes ventes
              </label>
              </div>
              <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="ventes-checkbox1" disabled="disabled">
                <label class="form-check-label" for="flexCheckDefault">
                  Mes ventes en cours
                </label>
              </div>
              <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="ventes-checkbox2" disabled="disabled">
                <label class="form-check-label" for="flexCheckChecked">
                  Ventes non débutées 
                </label>
              </div>
              <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="ventes-checkbox3" disabled="disabled">
                <label class="form-check-label" for="flexCheckChecked">
                  Ventes terminées 
                </label>
              </div>
             </div>
          </div>
          </c:if>
              <!--  -->
      <section>
      <c:forEach var="article" items="${model.articlesVendus}">
      <form action="vente" method="post">
        <div class="card mb-3">
          <div class="row g-0">
            <div class="col-md-4">
            <input type="hidden" name="" value="${article.noArticle }">
            <input type="hidden" value="${article.nomArticle }">
            <input type="hidden" value="${article.description }">
            <input type="hidden" value="${article.dateDebutEncheres }">
            <input type="hidden" value="${article.dateFinEncheres }">
            <input type="hidden" value="${article.miseAPrix }">
            <input type="hidden" value="${article.prixVente }">
            <input type="hidden" value="${article.etatVente }">
<%--             <input type="hidden" value="${article.utilisateur.pseudo }">
            <input type="hidden" value="${article.categorie.libelle }">
            <input type="hidden" value="${article.retrait.rue }">
            <input type="hidden" value="${article.retrait.codePostal }">
            <input type="hidden" value="${article.retrait.ville }"> --%>
              <img src="${article.lienImage }" class="w-75 bg-info" alt="">
            </div>
            <div class="col-md-8">
              <div class="card-body">
                <h5 class="card-title">${article.nomArticle }</h5>
                <p class="card-text"> Prix : ${article.prixVente} points</p>
                  <p class="card-text"> Fin de l'enchère : </p>
                  <p class="card-text"> Retrait : </p>
                  <p class="card-text"> Vendeur : </p>
              </div>
            </div>
          </div>
        </div>
        </form>
        </c:forEach>
      </section>   
</main>
    </body>
    <script type="text/javascript">
		function griserBtn(){
	        if(document.getElementById('radio-achats').checked) {
	            document.getElementById('achat-checkbox1').disabled = "";
	            document.getElementById('achat-checkbox2').disabled = "";
	            document.getElementById('achat-checkbox3').disabled = "";
	        } 
	        else{
	            document.getElementById('achat-checkbox1').disabled = "disabled";
	            document.getElementById('achat-checkbox2').disabled = "disabled";
	            document.getElementById('achat-checkbox3').disabled = "disabled";
	            document.getElementById('achat-checkbox1').checked = "";
	            document.getElementById('achat-checkbox2').checked = "";
	            document.getElementById('achat-checkbox3').checked = "";
	        }
	        if(document.getElementById('radio-ventes').checked) {
	            document.getElementById('ventes-checkbox1').disabled = "";
	            document.getElementById('ventes-checkbox2').disabled = "";
	            document.getElementById('ventes-checkbox3').disabled = "";
	        } 
	        else{
	            document.getElementById('ventes-checkbox1').disabled = "disabled";
	            document.getElementById('ventes-checkbox2').disabled = "disabled";
	            document.getElementById('ventes-checkbox3').disabled = "disabled";
	            document.getElementById('ventes-checkbox1').checked = "";
	            document.getElementById('ventes-checkbox2').checked = "";
	            document.getElementById('ventes-checkbox3').checked = "";
	        }
	    }
	</script>
</html>