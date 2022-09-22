# LIVEDATA
La [LiveData] classe fait également partie des composants d'architecture Android et est une classe de support de données qui peut être observée.
LiveData est une classe de détenteurs de données observables qui tient compte du lifeCycle.

[observability] fait référence à la capacité d'un objet à informer les autres des modifications de ses données

[LiveData] contient des données ; LiveData est un wrapper qui peut être utilisé avec n'importe quel type de données.

[LiveData] est observable,  ce qui signifie que lorsque les données changent, l'interface utilisateur sera automatiquement mise à jour.

[LiveData] est conscient du lifecycle. Lorsque vous attachez un observateur au LiveData,
l' [observer] est associé à un [LifecycleOwner](généralement une activité ou un fragment). 

# MutableLiveData
c'est la version modifiable de LiveData, c'est-à-dire que la valeur des données qui y sont stockées peut être modifiée.

Le type de variable [val] car la valeur de l' objet [LiveData/ MutableLiveData] restera la même et 
seules les données stockées dans l'objet changeront.

# Value LiveData object
Pour accéder aux données d'un LiveData objet, utilisez la [value] propriété

# Attach observer to the LiveData object .observe()
[observer] que vous allez ajouter observe les modifications apportées aux données de l'application currentScrambledWord.
Ainsi, [observer] dans le GameFragment ne sera averti que lorsque le GameFragment est dans [STARTED] ou [RESUMED] indique.

  ## observe() method 
[viewLifecycleOwner] représente le lifecycle de la view du fragment .
Ce paramètre permet à la LiveData d'être consciente du GameFragment lifecycle et de notifier 
l' observer uniquement lorsque la GameFragment est dans des états actifs ( STARTED ou RESUMED).

# Use LiveData with data binding
L'application écoute les modifications de données dans le code. De même, les applications peuvent écouter
les modifications de données à partir de la mise en page.
 
[View Binding] -  est une fonctionnalité qui vous permet d'accéder plus facilement aux [views] dans le code.
Une instance d'une binding class contient des références directes à toutes les views qui ont un ID dans la mise en page correspondante.
C'est une liaison à sens unique.
vous ne pouvez pas référencer les données d'application dans les views (fichiers de mise en page). Cela peut être accompli en utilisant [data binding]

[data binding] - fait également partie de la bibliothèque Android Jetpack
Lie les composants d'UI de vos mises en page aux sources de données de votre application à l'aide d'un format déclaratif,
In simpler terms Data binding is binding data (from code) to views + view binding (binding views to code)

[1.] buildFeatures {
   dataBinding = true
   }
[2.] plugins {
id 'com.android.application'
id 'kotlin-android'
id 'kotlin-kapt' on doit applique ce ci
}

Convert layout file to data binding layout

[Add data binding variables]-

# Use binding expressions
sont écrites dans la mise en page dans les [propriétés d'attribut]
Les propriétés de mise en page sont déclarées en haut du fichier de mise en page de data binding, via la [<variable>] balise
Lorsque l'une des variables dépendantes change, la 'DB Library' exécute vos expressions de liaison (et met ainsi à jour les views). 

[Syntaxe des binding expressions ]
Les binding expressions  commencent par un [ @ ]symbole et sont entourées d'accolades [ {} ]. 
 #Resources in data binding expressions:
  [1. android:padding="@{@dimen/largePadding}" ]-  padding attribut est affecté d'une valeur à largePadding a partir du dimen.xml
  [2. android:text="@{@string/example_resource(user.lastName)}"]


