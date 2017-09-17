1. Bref présentation du jeu:

- Le jeu de Go est un jeu de plateau originaire de Chine, qui oppose deux adversaires jouant des pierres à tour de rôle.
- Il y 3 tailles de plateau de jeu : 9x9, 13x13 et 19x19.
- Selon les tailles, on aura des différents hoshi qui sont placés, qui permettent au joueur plus fort de donner 
des pierres d'avance au joueur le moins fort, ces pierres sont appelées Handicap.
- Il y a 3 types d'horloge : Aucune horloge, Horloge Absolue et Byo-Yomi. 
- Les règles du jeu sont variées : le komi, le ko, interdiction de se suicider, les sekis..  etc.
- Chaque fois qu'une ou plusieurs pierres sont entourées par les autres pierres de son adversaire (il n'y a plus de liberté), 
les pierres entourées seront capturées par son adversaire et cela va compter comme des points gagants accumulants.
- A la fin du jeu, on compte le score de chacun des joueurs et celui ayant le plus de points gagnent la partie

2. Notre jeu de Go

Notre programme de jeu de Go contient 7 fichiers : 
	- le fichier AUTHORS avec nos noms et prénoms
	- le fichier README pour un brief présentation du projet
	- le fichier Jeux.java qui contient le main
        - le fichier Goban.java qui contient la partie structure du jeux
        - le fichier Joueur.java contenant la partie concernant les joueurs
        - le fichier Temps.java qui contient la partie du temps 

Pour plus de détail, on vous explique brievement les differentes étapes du jeux
- Le fichier Jeux.java est dans lequel on peut trouver le point d'entré pour commencer le jeu. 
Commencer par lancer le jeu avec "javac Jeux.java Goban.java Temps.java Joueur.java" , vous trouvez tout de suite une fenêtre qui contient le menu de notre jeu.En remplissant la 
taille et le handicap désirés et les noms des joueurs, cliquez ensuite sur "Start" pour commencer.
- Une fois que vous avez cliqué sur le button "Start", une deuxième fenêtre va apparaître qui s'appelle "plateau" ou 
"Goban". Là où vous pouvez commencer à jouer avec le premier tour pour le joueur qui joue la pierre noir.
- Pendant le jeu, vous pouvez "annuler" ou "désannuler" les coups.
- Pour finir le jeu, vous appuyez sur le button "Finir" et vous trouverez le résultat de votre match. Vous pouvez aussi abandonner ou passer 2 fois d'affilés

Nous avons un total de 6 class.
	- La class Goban ,  a pour le but de dessiner le plateau 
. Ensuite, dans la méthode paintComponent, on a fait afficher le score et 
les pierres que les deux joueurs ont capturés ainsi que les pierres posées. La fonction actionPerformed est pour définir les actions
différentes quand on clique sur les button "passer","finir","abandonner","annuler" ou "désannuler". La fonction mouseCliqued a pour  but de définir 
la position du clique par rapport au plateau en x et y et de remplir le tableau en consequence. La fonction isDead est pour vérifier si à la position x et y, est-ce
qu'il existe encore des libertés pour la pierre. La dernière fonction de la classe est verifyAdvesarialState est pour vérifier
l'état des joueurs et aussi pour accumuler les points capturés.  

	- La class Jeux est la classe principale du jeu. Elle contient la partie centrale car c'est ici qu'on appele nos class, 
JTextField, Label, Text, etc.
	- La class Joueur qui prend les attributs sur les joueurs (numéro joueur, score ou les pierres capturés).
	- La class Quitter qui a simplement pour but de quitter le jeu.
	- La class Text qui contient des TextField qui retourne les valeurs qui sont entrés dans le menue, comme la taille,
le temps, etc.
        - La class Temps permettant de gérer le Timer.

