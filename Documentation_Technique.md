## Documentation technique :


### Introduction





### Technologies utilisées :
Côté backend : Java 17 avec le framework Spring, PostgreSQL 15 pour la base de donnée.
Côté frontend : HTML, CSS, Javascript, Bootstrap, Thymeleaf, jQuery.

Le site est hébergé sur Google Cloud.
La base de données est hébergée sur la plateforme Aiven.

-------------

### Sécurité :


#### Authentification

Les administrateurs sont authentifiés à l'aide de Spring Security.
L'autorisation est gérer par un système de rôle simple, Admin ou sans rôle (personne anonyme), restreignant
les fonctionnalités plus sensibles.

L'administrateur doit rentrer un login et un mot de passe (qui sera encrypté par la fonction de hachage BCrypt).
Les comptes admins ne peuvent pas être créés à partir du site.
Ainsi, il n'y a pas d'interface de création de compte admin sur le site web.

Un login et mot de passe admin est :
login : admin
mot de passe : lorem5ipsum


#### Validation des données

Tous les objets ont des champs nécessaires à remplir dans leurs formulaires. Les logins, mots de passe,
ainsi que pour le produit: le nom, la catégorie et le prix sont obligatoires, et enfin pour une promotion,
tous les champs sont obligatoires.


#### Sécurité des Fichiers et Images

Les images sont seulement fournies par URL externes. Il n'y a pas de possibilité de télécharger des fichiers
malveillants.


-------------

### Evolutions futures :

L'administrateur aura la possibilité de modifier ou supprimer des produits.
Il pourra aussi créer, modifier et supprimer des catégories.
On pourra aussi faire une barre de recherche pour les produits.

Pour la sécurité, on pourra aussi implémenter l'authentification par token.
