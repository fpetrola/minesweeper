# minesweeper-API


Heroku URL: https://shrouded-tor-35036.herokuapp.com/api-docs?url=/swagger.json


Development process for the API

* I've decided to use SpringBoot as base to make use of easy configurations and dependency injection capabilities.
* I've started development from minesweeper model to get a good perspective about which endpoints create
* To create the model from scratch following the rules of the game I prefer to use TDD over these small set of rules
* There were 4 important cycles of refactoring during tdd process:
    * Start using Square model instead of string representation
    * Calculate and model adjacent squares
    * Compute string representation from board properties
* Once model was complete I started to introduce rest configuration as pom dependencies
* Using JAX-RS standard I've created MineSweeperApi interface annotated with severeal annotations from the standard, in class, method, and parameter levels.
* Using swagger annotations in combination with jax-rs annotation it's very easy to create a server implementing this interface. And also make use of swagger capabilities to create live client.
* To preserve game state I've decided to use repository pattern implementing method like save and find by id. First implementation is in memory.
* Finally I've deployed application in Heroku because I've already use its client and it's very simple to deploy just pushing git changes to other remote server.
* Pending implementations:
    * Add an alternative implementation of GameRepository using no sql database, such as Redis or Mongo. I would not use a Sql database because I'm  no using relational algebra queries in this application.
    * Multiple users and accounts. To implement this feature I would use a social login like Google and Facebook login as first implementation cause there is no database or custom security needed. And if it's required I'd implement custom login  and user registration in own database to provide an email sign up.
    
