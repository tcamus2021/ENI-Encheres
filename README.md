# ENI-Encheres

# Il faut d'abord installer les fichiers sur votre serveur #

# Pour que le site fonctionne, cela n�cessite une base de donn�es #
Il y a 2 scripts de cr�ation � la base de l'application:
-CREATE_DATABASE.sql
-CREATE_TABLE.sql
Il faut executer ces deux scripts sur SQLserverManager dans l'ordre.
Ensuite il faut aller dans le fichier src/main/webapp/META-INF/context.xml
et pr�ciser le login et le mot de passe d'une connexion vers le syst�me de base de donn�es du serveur.
