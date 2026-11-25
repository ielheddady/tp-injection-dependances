# tp-injection-dependances
TP injection de dépendances
Partie 1:
-Création de l'interfaces Idao avec une méthode getData.
-Création d'une implémentation de l'interface IDao.
-Création de l'interface IMetier avec une méthode calcul.
-Création d'une implémentation de l'interface IMetier en utilisant le couplage faible.
Partie 2:
-Dans la couche présentation on a créer un objet d de type DaoImpl avec la méthode getData().
-Et un objet métier de type MetierIMpl qui contient une variable dao nulle et une méthode calcul().
-Et finalement on a fait l'injection de dépendances avec un constructeur(pour affecter à la variable dao l'objet d). 