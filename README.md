# tp-injection-dependances
TP injection de dépendances
Partie 1:
Création de l'interface IDao

La première étape consiste à créer une interface appelée IDao.

Cette interface définit une méthode getData() qui permet de récupérer une donnée.

L'utilisation d'une interface permet de séparer la définition du service de son implémentation.
Capture 1 : Structure du projet

![Interface IDao](captures/IDao.png)

Explication :

La méthode getData() représente le contrat que toutes les classes implémentant IDao doivent respecter.

Ainsi, la couche métier n'a pas besoin de connaître les détails de récupération des données.

4.2. Création de l'implémentation de IDao

Nous créons ensuite une classe DaoImpl qui implémente l'interface IDao.

![Implémentation de IDao](captures/DaoImpl.png)
}

Explication :

La classe DaoImpl fournit une implémentation concrète de la méthode getData().

Dans cet exemple, elle retourne une valeur numérique représentant une donnée récupérée. Dans une application réelle, cette méthode pourrait effectuer une consultation dans une base de données.

4.3. Création de l'interface IMetier

Nous créons une deuxième interface appelée IMetier.

Elle contient une méthode calcul() qui représente le traitement métier de l'application.
![Interface IMétier](captures/IMetier.png)
Explication :

L'interface IMetier définit le contrat de la couche métier sans imposer une manière particulière de réaliser le calcul.

4.4. Création de l'implémentation MetierImpl avec couplage faible

Nous créons la classe MetierImpl qui implémente l'interface IMetier.

Cette classe utilise une dépendance de type IDao.
![Implémentation de IMétier](captures/Metier.Impl.png)
Explication :

La classe MetierImpl dépend de l'interface IDao et non directement de la classe DaoImpl.

C'est ce qui permet d'obtenir un couplage faible.

L'utilisation de la méthode setDao() permet d'injecter une implémentation de IDao depuis l'extérieur.

Cette approche facilite le remplacement de l'implémentation DAO sans modifier le code de la classe métier.
Partie 2:
-Injection par instanciation statique

Dans cette première méthode, les objets sont créés directement dans la classe principale.

![Instantiation Statique](captures/InstantiationStatique.png)

Explication :

Nous créons une instance de DaoImpl.

Nous créons une instance de MetierImpl.

Nous injectons l'objet DAO dans l'objet métier à l'aide de setDao().

Nous exécutons la méthode calcul().

Cette méthode est appelée statique parce que les classes concrètes sont directement instanciées dans le code source.

Avantage : elle est simple à mettre en place.

Inconvénient : le changement d'implémentation nécessite une modification du code source.
Partie 3:
-Injection par instanciation dynamique
Dans cette deuxième méthode, nous utilisons la réflexion Java pour charger dynamiquement les classes à partir d'un fichier de configuration.

Le fichier config.txt contient les noms des classes à instancier :

dao.DaoImpl
metier.MetierImpl

![Instantiation Dynamique](captures/InstanciationDynamique.png)
Explication :

Cette méthode utilise principalement :

Scanner pour lire le fichier de configuration.

Class.forName() pour charger une classe à partir de son nom.

getDeclaredConstructor().newInstance() pour créer dynamiquement une instance.

getMethod() et invoke() pour appeler la méthode d'injection.

L'avantage de cette approche est qu'il est possible de changer les classes utilisées en modifiant uniquement le fichier config.txt, sans modifier la classe principale, à condition de respecter les interfaces et les méthodes attendues.

