# flot Maximum  OUATAR Hakim



A.  Préambule :   
On récupère l'archive maxflow qui contient le code d'un algorithme de flot max et celui de test de cet algorithme .On doit résolver les problèmes liée à la version de GraphStream .   
On vérifie la solution obtenue et on le test sur second exemple .

B.  Construction de graphe associé au réseau routier et le mettre sous forme d'un fichier DGS :   

   >[Le fichier autoroute.dgs qui représente le graphe  ](./Data/autoroute.dgs)   
   

C.  Donnez la solution du problème de flot max en utilisant l'algorithme mis à votre disposition. Vous afficherez le réseau, les valeurs du flot sur les arêtes, et vous mettrez en évidence les arêtes saturées.   
   ![Flots max d'autoroutes](Data/flotMax.png)   


D.AVANT de tester toutes les solutions pour la question 2), que pouvez-vous déduire du flot
max sur le réseau routier concernant les tronçons à construire ?   

On vérifie les capacités sur les tronçons dans  graphe obtenu ,on peut déduire que le flot n'est pas optimal car on a des tronçons qui peuvent être augmenté en capacité.   
Ce flot maximal est à 900 à l'arrivée .Si on augmente les capacités de certains tronçons ,on aurait le flot max.  



