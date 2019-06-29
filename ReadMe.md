## Dependency Injection

## Inversion of Control

## @AutoWired
  Used for dependecny injection of bean, interface of class
 
## @Profile
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
   
