[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/rGfOobSC)


IASD-16-



// la reponse de la Violation
Analyse des Principes SOLID (Bonus TP2)
Le code de votre TP2, qui intègre les patterns Builder, Observer et Decorator, respecte majoritairement les principes de conception logicielle SOLID. Cependant, une contrainte externe au code impose une légère violation technique.

1. Respect Global des Principes
L'application des patterns garantit l'adhérence aux principes suivants :

O.C.P. (Principe Ouvert/Fermé) : Respecté . Le Decorator Pattern (CoursEnLigne) permet d'ajouter la fonctionnalité "En ligne" en créant une nouvelle classe, sans modifier la classe de base Cours. Le système est ouvert à l'extension, mais fermé à la modification.

D.I.P. (Inversion des Dépendances) : Respecté . Le Observer Pattern dépend des abstractions (Observer et Subject) plutôt que des classes concrètes (Etudiant, Responsable).

L.S.P. (Substitution de Liskov) : Respecté . Les classes décorées (CoursEnLigne) peuvent être utilisées partout où l'interface ICours est attendue, sans briser le comportement du programme.

I.S.P. (Ségrégation des Interfaces) : Respecté . Le code utilise des interfaces spécifiques (ICours, Observer, Subject) pour chaque responsabilité.

2. Le Principe Violé : S.R.P.
Le seul principe qui est techniquement violé est le S.R.P. (Principe de Responsabilité Unique).

Quel principe viole-t-il ?
S.R.P. (Single Responsibility Principle)

Explication de la Violation
Rôle Idéal : La classe Cours devrait avoir une seule raison d'être modifiée : si les données qu'elle stocke changent. La logique de construction devrait être déléguée au CoursBuilder.

La Contrainte : Pour que le fichier de test (TpTests.java) compile, vous avez dû conserver le constructeur public à 8 arguments dans la classe Cours, en plus du constructeur utilisé par le Builder.

Conséquence : La classe Cours a désormais deux responsabilités distinctes :

Stocker les données (Responsabilité légitime).

Gérer la construction complexe par deux méthodes différentes (Violation du S.R.P.).

Cette violation est donc un compromis nécessaire imposé par la structure du TP, mais elle affaiblit l'encapsulation de la construction du Cours.