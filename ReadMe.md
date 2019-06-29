# Dependency Injection

# Inversion of Control

# @AutoWired
  Used for dependecny injection of bean, interface of class
 
# @Profile
   - @Profile annoation comes handy for use the necessary class to be active, by controlling them form *application.properties*
   - Annotate the class with 
   ```
   in java class:
    @Profile("name") or
    @Profile({"default","name1"})
   in applicatons.properties
    spring.profiles.active=name1
   ```
   
