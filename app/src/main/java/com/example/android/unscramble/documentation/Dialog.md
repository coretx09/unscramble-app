# MaterialAlertDialog
Utilisez le MaterialAlertDialog de la bibliothèque Material Design Components pour ajouter une boîte 
de dialogue à votre application qui suit les directives Material.

utilisez la [MaterialAlertDialogBuilder] class pour créer des parties de la boîte de dialogue étape par étape.
Appelez le MaterialAlertDialogBuilder constructeur en transmettant le contenu à l'aide de la 
méthode du fragment [requireContext()]. 
La requireContext() méthode renvoie un [non-null Context].

# CONTEXT:
Comme son nom l'indique, [Context] fait référence au contexte ou à l'état actuel d'une application,
[d'une activity ou d'un fragment]. Il contient les informations concernant l' activity, le fragment ou l'application.
Il est généralement utilisé pour accéder aux ressources, aux bases de données et à d'autres services système.

# BUTTONS:
[setNegativeButton(getString(R.string.exit), { _, _ -> exitGame()})] où la setNegativeButton()méthode
prend deux paramètres : a [String] et une fonction, [DialogInterface.OnClickListener()] qui peut être exprimée sous la forme d'un lambda.
Lorsque le dernier argument transmis est une fonction, vous pouvez placer l'expression lambda en dehors des parenthèses.
Il en va de même pour la [setPositiveButton]fonction.