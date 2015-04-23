#README

Examples of using spring @Configurable annotated "prototype" bean type (remember singleton bean also), i.e. create beans using normal "new" operator and then spring take control further for initializing beans, replace value on @Value placeholder bean properties, calling afterPropertiesSet of InitializingBean type, injecting @Autowired or @Inject properties, etc.

This feature enables by AspectJ. So, on compile-time (or maybe loading time, but it is more complex), any @Configurable beans must be woven using aspect provided in [spring-aspects](http://mvnrepository.com/artifact/org.springframework) module (you have to add [spring-tx](http://mvnrepository.com/artifact/org.springframework) and [spring-context-support](http://mvnrepository.com/artifact/org.springframework) also, because spring-aspects depends on them). For details, please look at ```pom.xml``` file, more importantly on aspectj-maven-plugin, for details of this plugin, read [here](http://mojo.codehaus.org/aspectj-maven-plugin/).

On configuration class, don't forget to enable this feature using @EnableSpringConfigured annotation.

On bean type, use @Component (or any other Streotype annitations), @Configurable and @Scope("prototype").

Clone this simple project repo, and then run the simple test provided. 

This sample created as answer for questions asked [here](http://www.javacodegeeks.com/2013/11/strategy-pattern-aint-meant-for-spring.html#comment-56921).

Happy Coding!