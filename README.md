# exercice

## Enoncé de l’exercice technique à réaliser :
Tu es un nouveau Développeur dans une société de vente de produit en ligne. La société vend trois types deproduits : des téléphones haut de gamme, des téléphones milieu de gamme et des ordinateurs portables.Ton Product Manager te demande de développer un programme permettant de calculer le panier d’unconsommateur.
Il existe deux types de clients :
1) Des clients particuliers identifiés par un id client, un nom et un prénom
2) Des clients professionnels identifiés par un id client, une raison sociale, un numéro de TVA intracommunautaire(qui est optionnel), un SIREN et un chiffre d’affaires annuel

## Tarification des Produits selon le Type de Client

| Type de Client                      | Téléphone Haut de Gamme | Téléphone Milieu de Gamme | Ordinateur Portable |
|------------------------------------|--------------------------|----------------------------|----------------------|
| Particulier                        | 1500 €                   | 800 €                      | 1200 €               |
| Professionnel (CA > 10M €)         | 1000 €                   | 550 €                      | 900 €                |
| Professionnel (CA <= 10M €)        | 1150 €                   | 600 €                      | 1000 €               |

 
Calculez pour un client donné le coût de son panier, sachant que celui-ci pourra contenir les 3 produits enplusieurs exemplaires.