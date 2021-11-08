# teamMBot

Pour ceux qui veulent déjà s'amuser à retravailler le code pour l'améliorer, mais sans un but précis, vous pouvez le faire en modifiant la branche sandbox. 
Si vous avez des idées de commandes pour le bot d'autres idées, écrivez les dans le discord. Présentement, le bot fonctionne sur l'ordi à Luc dans IntelliJ avec Java 1.8...?

Description: Projet pour monter un bot discord

## Projet

Voici quelques idées de fonctionalités à implémenter:


- Team maker

    Le TeamMaker prend en compte les personnes qui sont connectées dans le discord vocal et crée deux équipes aléatoires de taille égales si possible. Il envoie un 
    message qui nous informe des équipes et il pinne le message dans le channel où on a entré la commande.


- Rappel examens/devoirs/remises/rencontres

    Notre bot est un agenda sur pattes qui nous ramène à l'ordre pour être certain qu'on ne passe pas tout droit.

- Compétiteur GIF
    
    Le bot tente de trouver un meilleur GIF que celui qu'on vient d'envoyer.
    
- Chercheur de photos sur internet/autres projets de webscraping

    Le bot a un webscraper intégré qui lui permet de chercher des images sur google. On aura peut-être besoin d'ajouter un module python au bot pour que ça fonctionne facilement.
    
## Installation

Pour installer le projet localement:

    1- Télécharger le code de base en fichier .zip sur votre machine. 
    2. Créer un projet IntelliJ à partir de source existante et sélectionner le dossier 'DiscordBot'.
    3. Aller dans l'onglet Run - > Edit Configurations et sélectionner nom du profile (ex: TeamMBot) et sélectionner la main class. Le projet devrait proposer la bonne classe sinon sélectionner manuellement: team.M.TeamMBot
    4. All set!
