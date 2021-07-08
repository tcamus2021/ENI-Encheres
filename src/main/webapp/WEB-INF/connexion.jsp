<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="index.css" rel="stylesheet">
    <title>Connexion</title>
</head>
<body>
    <header class="offset-1 col-11">
        <h1>ENI-Enchères</h1>
    </header>
    <main class="d-flex flex-wrap justify-content-center">
        <form method="post" action="">
            <div class="corps-connexion">
                <div class="corps-connexion-infos col-12">
                    <label class="col-4" for="login-name" id="label-login-name">Identifiant:</label>
                    <input class="col-7" type="text" id="login-name">
                </div>
                <div class="corps-connexion-infos col-12">
                    <label class="col-4" for="login-password">Mot de passe:</label>
                    <input class="col-7" type="password" id="login-password">
                </div>
                <div class="corps-connexion-options col-12 d-flex flex-nowrap">
                    <input class="col-4" type="submit" value="Connexion" id="submit-connexion">
                    <div class="col-7 d-flex flex-wrap">
                        <div class="offset-1 d-flex flex-nowrap">
                            <input type="checkbox" id="maintenir-connexion">
                            <label for="maintenir-connexion">Se souvenir de moi</label>
                        </div>
                        <a href="" class="offset-1 d-flex flex-nowrap">Mot de passe oublié</a>
                    </div>
                </div>
                <div class="corps-connexion">
                    <button class="btn-creation-compte col-12">Créer un compte</button>
                </div>
            </div>
        </form>
    </main>
</body>
</html>