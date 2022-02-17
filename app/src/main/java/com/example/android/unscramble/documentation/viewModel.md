# viewModel:
one of the Architecture components [to store your app data].
Il s'agit d'un modèle de data d'app affichées dans les views.
ls permettent à votre app de suivre le principe de l'architecture, en pilotant l'UI à partir du modèle.

Le ViewModel stocke les data liées à l'app qui ne sont pas détruites lorsque l'activité ou le fragment est détruit et recréé par le framework Android.

ViewModel est responsable de la conservation et du traitement de toutes les données nécessaires à l'UI.
Il ne doit jamais accéder à votre hiérarchie de vue (comme un objet de liaison de vue) ou contenir une référence à l'activité ou au fragment.

#Kotlin property delegate
 [var] propriety mutable() a des functions [getter et setter] par default automatiquement générées
pour elle. Les functions setter et getter sont appelées lorsque vous affected une valeur ou lisez la valeur de la propriété.

 [val] elle diffère légèrement d'une propriety modifiable. Seule la fonction [getter] est générée par défaut.
Cette fonction getter est appelée lorsque vous lisez la valeur d'une propriety en lecture seule.

La delegation de propriety dans Kotlin vous aide à transférer la responsabilité du [getter-setter] à une autre classe.
Cette classe (appelée [delegate class] ) fournit les fonctions getter et setter de la propriété et gère ses modifications.
Une propriété déléguée est définie à l'aide de la [by] clause et d'une instance de classe déléguée :
   [var <property-name> : <property-type> by <delegate-class>()]

#Backing property
Permet de renvoyer quelque chose d'un getter autre que l'objet exact.
// Declare private mutable variable that can only be modified  within the class it is declared.
[ private var _count = 0 ]
// Declare another public immutable field and override its getter method. 
[ val count: Int
     get() = _count ]

N'exposez jamais les champs de données modifiables de votre ViewModel— assurez-vous que ces données
ne peuvent pas être modifiées à partir d'une autre classe. Les données modifiables à l'intérieur de ViewModel doivent toujours être private.

# The lifecycle of a ViewModel:
Le framework  maintient le ViewModel vivant tant que la portée de l'activité ou du fragment est vivante.
ViewModel n'est pas détruit si son propriétaire est détruit pour un changement de configuration

# Late initialization (latenit) - Initialisation tardive:
Généralement, lorsque vous déclarez une variable, vous lui fournissez une valeur initiale à l'avance.
Cependant, si vous n'êtes pas encore prêt à attribuer une valeur, vous pouvez l'initialiser plus tard.
La mémoire n'est pas allouée à la variable tant qu'elle n'est pas initialisée. 
Si vous essayez d'accéder à la variable avant de l'avoir initialisée, l'application plantera.

