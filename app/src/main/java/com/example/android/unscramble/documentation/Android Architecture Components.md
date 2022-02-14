# Android Architecture Components:
font partie des bibliothèques [Android Jetpack] , pour vous aider à concevoir des applications avec 
une bonne architecture. Les composants d'architecture fournissent des conseils sur l'architecture 
de l'application et constituent la meilleure pratique recommandée.

L'Architecture de l'application est un ensemble de règles de conception. Tout comme le plan d'une
maison, votre architecture fournit la structure de votre application.

#ARCHITECTURAL PRINCIPLES: 
Une architecture d'application définit les limites entre les parties de l'application et les
responsibilities que chaque parties doit avoir.

[1. Séparation des préoccupations(concerns)]:
Le principe de conception de la séparation des préoccupations stipule que l'application doit être
divisée en classes, chacune avec des responsabilités distinctes.

[2. Drive UI from a model]:
Un autre principe important est que vous devez piloter votre UI à partir d'un modèle, de préférence un modèle persistant.
Les [models] sont des components chargés de gérer (handling) les data for an app. 
 Ils sont indépendants des Views composants et de l'application dans votre application, 
 ils ne sont donc pas affectés par le lifecycle de l'app et les problèmes associés.

The main classes or components in Android Architecture are:
[ 
  UI Controller (activity/fragment),
  ViewModel, 
  LiveData and 
  Room.
]
