# java_alternance

## SpringBoot

### Spring initializr
Réalisé depuis le tuto OpenClassRoom : https://openclassrooms.com/fr/courses/4668056-construisez-des-microservices/5122884-creez-un-microservice-grace-a-spring-boot

https://start.spring.io/ : Permet de définir certains paramêtres afin de télécharger et utilisé ceci comme porjet.

Nous aurons besoin de Maven.

Il faut télécharger ce qu'on à fait via https://start.spring.io/, l'ouvrir dans l'IDE en tant que projet et installé via Maven toute les dépendences déclaré dans le pom.xml.

En fouillant la doc ou les tutos, on trouve les différentes annotations qui nous conviennent. Ex : @RequestMapping, @GetMapping, @PostMapping, @PathVariable, etc.
En utilisant ces différentes annotaions, Spring va comprendre ce qu'on lui demande.

### Thmyeleaf

Thymeleaf est un outils qui nous aide coté Front-end. J'ai, dans un premier temps, fait la même chose que ce que j'avais fait précédement avec Spring, une API REST mais moins évolué. Le but étant par la suite de "consommé" la première API déja fonctionnel et complete via RestTemplate.
