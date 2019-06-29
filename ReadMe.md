### Dependency Injection

### Inversion of Control

### @AutoWired
  Used for dependecny injection of bean, interface of class
 
### @Profile
   - @Profile annoation comes handy when it is necessary to active the use of class by controlling them form *application.properties*
   - For example, using in memory database for a local development and latter enabling the required database implementation, etc.
   - The profile with the default will be used if the applicaiton.properties was not provided for any active value. 
   ```
   in java class:
        @Profile("name") or
        @Profile({"default","name1"})
   in applicaton.properties
        spring.profiles.active=name1
   ```
##### Below exception message occurs if the @Profile is not marked as default or no active entries in application.properties file spring will not be able to resolve between the English or Spanish language implementor component beans
##### To resolve this issue use default within the @Profile or tag an active profile in application.properties
```
 Caused by: org.springframework.beans.factory.BeanCreationException: Could not autowire field: private com.app2.Service.LanguageService com.app2.HelloWorld.languageService; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type [com.app2.Service.LanguageService] found for dependency: expected at least 1 bean which qualifies as autowire candidate for this dependency. Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}
	at 
...
org.springframework.beans.factory.support.DefaultListableBeanFactory.raiseNoSuchBeanDefinitionException(DefaultListableBeanFactory.java:1301)
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1047)
```

### @ComponentScan
  - @CompoenentScan annotation is used to tell spring to load the @Component,@Repository, etc. annoation to be resolved to the spring context from the specific package.
  - Use this annotation over the class which has the *@SpringBootApplication*.
  - Using the annotation to scan pacakge with wildcard, may cause performance when loading the springboot application
  
```
  @ComponentScan("com.app2") 
  @ComponentScan({"package1","package2"})
```
(Image)[./Sb_ComponentScan.png]

### Java configuration





