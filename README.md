# ENI-Encheres

# Il faut d'abord installer les fichiers sur votre serveur #

# Pour que le site fonctionne, cela nécessite une base de données #
Il y a 2 scripts de création à la base de l'application:
-CREATE_DATABASE.sql
-CREATE_TABLE.sql
Il faut executer ces deux scripts sur SQLserverManager dans l'ordre.
Ensuite il faut aller dans le fichier src/main/webapp/META-INF/context.xml
et préciser le login et le mot de passe d'une connexion vers le système de base de données du serveur.
