<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
            <h1>ENI-Enchères</h1>
            <div class="d-flex position-relative">
              <div> <a href="connexion" class="stretched-link">S'inscrire - Se connecter</a></div>
            </div>

            <!-- Si l'utilisateur est connecté -->
            <div class="d-flex position-relative">
              <div> <a href="vente" class="stretched-link">Vendre un article</a></div>
            </div>
            <div class="d-flex position-relative">
              <div> <a href="compte" class="stretched-link">Mon profil</a></div>
            </div>
            <div class="d-flex position-relative">
              <div> <a href="accueil" class="stretched-link">Déconnexion</a></div> <!-- TODO -->
            </div>
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

            <!-- Si l'utilisateur est connecté -->
          <div class="form-check">
            <div style="margin-top:1em">
            <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2" checked>
            <label class="form-check-label" for="flexRadioDefault2">
              Achats
            </label>
          </div>
            <div class="form-check">
              <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
              <label class="form-check-label" for="flexCheckDefault">
                Enchères ouvertes
              </label>
            </div>
            <div class="form-check">
              <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked">
              <label class="form-check-label" for="flexCheckChecked">
                Mes enchères 
              </label>
            </div>
            <div class="form-check">
              <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked">
              <label class="form-check-label" for="flexCheckChecked">
                Mes enchères emportées 
              </label>
            </div>
          </div>
            
          <div>
            <div class="form-check">
              <div style="margin-top:1em">
                <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2" checked>
                <label class="form-check-label" for="flexRadioDefault2">
                Mes ventes
              </label>
              </div>
              <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                <label class="form-check-label" for="flexCheckDefault">
                  Mes ventes en cours
                </label>
              </div>
              <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked">
                <label class="form-check-label" for="flexCheckChecked">
                  Ventes non débutées 
                </label>
              </div>
              <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked">
                <label class="form-check-label" for="flexCheckChecked">
                  Ventes terminées 
                </label>
              </div>
             </div>
          </div>
              <!--  -->
      <section>
        <div class="card mb-3" >
          <div class="row g-0">
            <div class="col-md-4">
              <img src="rat.jpg" class="w-75 bg-info" alt="...">
            </div>
            <div class="col-md-8">
              <div class="card-body">
                <h5 class="card-title"> <u> Nom de l'article </u></h5>
                <p class="card-text"> Prix : Classement : </p>
                  <p class="card-text"> Fin de l'enchère : </p>
                  <p class="card-text"> Retrait : </p>
                  <p class="card-text"> Vendeur : </p>
              </div>
            </div>
          </div>
        </div>

        <div class="card mb-3" >
          <div class="row g-0">
            <div class="col-md-4">
              <img src="licorne.jpg" class="w-75 bg-info" alt="...">
            </div>
            <div class="col-md-8">
              <div class="card-body">
                <h5 class="card-title"> <u>Nom de l'article</u></h5>
                <p class="card-text"> Prix :          Classement : </p>
                  <p class="card-text"> Fin de l'enchère : </p>
                  <p class="card-text"> Retrait : </p>
                  <p class="card-text"> Vendeur : </p>
              </div>
            </div>
          </div>
        </div>
      </section>   
</main>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</html>