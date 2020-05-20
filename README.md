# TP ASI 
### Partie 1

##### En quoi nos prototypes respectent le pattern MVC ?
Nos prototypes respectent MVC car la vue côté Javascript n'effectue aucune manipulation de données du modèle. Elle utilise l'API REST qui fait office de controller d'accès aux données via les services. Le modèle est géré via des DAO et seul l'api REST peut donc effectuer des manipulations dans la base de données (requête SQL)
