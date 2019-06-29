# Dependency Injection

# Inversion of Control

# @AutoWired
  Used for dependecny injection of bean, interface of class
 
# @Profile
   - @Profile annoation comes handy for use the necessary class to be active, by controlling them form *application.properties*
   - The profile with the default will be used if the applicaiton.properties was not provided for any active value. 
   ```
   in java class:
        @Profile("name") or
        @Profile({"default","name1"})
   in applicaton.properties
        spring.profiles.active=name1
   ```
   
