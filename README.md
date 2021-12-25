# Java-RMI
Remote method invocation


Quatres étapes dans la conception d'une application distribué RMI:
1. Concevoir et implémenter les composants de votre application distribuée.
2. Compilation des sources.
3. Rendre le réseau de classes accessible.
4. Démarrage de l'application.


### Conception et mise en œuvre des composants de l'application
Tout d'abord, déterminez l'architecture de votre application, notamment quels composants sont des objets locaux et quels composants sont accessibles à distance. Cette étape comprend :
* Définition des interfaces distantes.
* Implémentation des objets distants.
* Implémentation des clients.

### Compilation des sources
Comme pour tout programme Java, vous utilisez le `javac` compilateur pour compiler les fichiers source. Les fichiers source contiennent les déclarations des interfaces distantes, leurs implémentations, toute autre classe serveur et les classes client.

### Rendre le réseau de classes accessible
Dans cette étape, vous rendez accessibles au réseau certaines définitions de classes, telles que les définitions des interfaces distantes et leurs types associés, et les définitions des classes qui doivent être téléchargées sur les clients ou les serveurs. Les définitions de classes sont généralement rendues accessibles sur le réseau via un serveur Web.

### Démarrage de l'application
Le démarrage de l'application inclut l'exécution du registre d'objets distants RMI, du serveur et du client.
