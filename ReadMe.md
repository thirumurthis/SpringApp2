### Dependency Injection

### Inversion of Control

### @AutoWired
 - Used for dependency injection of bean with the interface type of concrete class.
  
### @Controller
 - In this SpringBoot application, we use the controller to bridge the @Component layer.
 - The *@SpringBootApplication* annotated class, creates a *ApplicationContext* and looks for the **@Controller** annoated bean class.
```
  public static void main(String[] args) {
     ApplicationContext ctx = SpringApplication.run(App2Application.class, args);
     LanguageController languageController = (LanguageController) ctx.getBean("languageController");
     languageController.sayHello();
  }
```
 
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
##### If class is not marked with *@Profile(default)*, and there is no active entries in application.properties file, spring will not be able to resolve between the English or Spanish language component beans
 - To fix this issue 
 	- use *@Profile({"default","english"})* **or**
	- activate the profile in application.properties using *spring.profiles.active=english*
```
 Caused by: org.springframework.beans.factory.BeanCreationException: Could not autowire field: private com.app2.Service.LanguageService com.app2.HelloWorld.languageService; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type [com.app2.Service.LanguageService] found for dependency: expected at least 1 bean which qualifies as autowire candidate for this dependency. Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}
	at 
...
org.springframework.beans.factory.support.DefaultListableBeanFactory.raiseNoSuchBeanDefinitionException(DefaultListableBeanFactory.java:1301)
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1047)
```

### @ComponentScan
  - @CompoenentScan annotation is used to tell spring to load the @Component,@Repository, etc. annoation to be resolved to the spring context from the specific package.
  - Use this annotation in the class which has the *@SpringBootApplication*.
  - The annotation can take wildcards to scan pacakge, consider the performance when using wild card
```
  @ComponentScan("com.app2") 
  @ComponentScan({"package1","package2"})
```
![Image](Sb_ComponentScan.png)

### Java configuration using @Configuration
  - For example, a datasource java bean or pojo class in an external jar that needs to be loaded to the Spring context, this can be configured in Spring using **@Configuration** and **@Bean**.
  - If the dataource interface has multiple implemenation, then use the **@Profile** annoatation within **@Bean** to resolve.
  - In the example below, the controller is used to autowire the beans.
Thumb rule:
  - When we have control over the code, we can use *@Component* annoation
  - When the bean that needs to be referenced from the third party library we can use java or xml configuartion.

```
public interface VehicleService {
    public String vehicleType();
}
---
public class CarVehicleImpl implements VehicleService{
    @Override
    public String vehicleType() {
        return "Car";
    }
}
---
public class BusVehicleImpl implements VehicleService {
    @Override
    public String vehicleType() {
        return "Bus";
    }
---
@Configuration
public class VehicleConfig {
    @Bean
    @Profile("bus")
    public VehicleService busService(){
        return new BusVehicleImpl();
    }
    @Bean
    @Profile({"default","car"}) 
    //Note: in @Profile if default is NOT mentioned, spring will not be able to resolve 
    //the bean and throws exception
    public VehicleService carService(){
        return new CarVehicleImpl();
    }
}
```

### Factory pattern usage in java config
```
public interface BirdService {
    public String birdType();
}
---
public class CrowImpl implements BirdService {
    @Override
    public String birdType() {
        return "Crow";
    }
}
---
public class GreyJayImpl implements BirdService {
    @Override
    public String birdType() {
        return "Grey Jay";
    }
}
---
public class BirdFactory {

    public BirdService getBirdService(String birdName){

        BirdService birdService = null;
        birdName = birdName.toUpperCase();
        switch (birdName){
            case "CROW" : birdService = new CrowImpl();break;
            case "GREYJAY" : birdService = new GreyJayImpl();break;
            case "SPARROW" : birdService = new SparrowImpl();break;
            case "HUMMINGBIRD" : birdService = new HummingBirdImpl();break;
            default: birdService= new CrowImpl();
        }
        return birdService;
    }
}
---
@Configuration
public class BirdConfig {

    //Bean for the fatcorybean
    @Bean
    public BirdFactory birdFactory(){
        return new BirdFactory();
    }

    @Bean
    @Profile({"default","crow"})
    // the factory bean passes in as the argument to another bean
    public BirdService getCrowService(BirdFactory birdFactory){
        return birdFactory.getBirdService("crow");
    }

    @Bean
    @Profile("sparrow")
    public BirdService getSparrowService(BirdFactory birdFactory){
        return birdFactory.getBirdService("sparrow");
    }
}
---
@Controller
public class BirdController {

    @Autowired
    private BirdService birdService;

    public void printBirdType(){
        System.out.println(birdService.birdType());
    }
}
---

//Springboot application entry point
BirdController birdController = (BirdController) ctx.getBean("birdController");
birdController.printBirdType();

```

###### When multiple @Profile used on @Component and @Beans, the active profile for each controller needs to be mentioned in  *application.proeprties* for an active profile.
```
# multiple active profiles usage
spring.profiles.active=sparrow,english,car
```
##### Exception when activating the profile names of the same service, the crow and sparrow are of the same BirdService class, which can be fixed by removing the crow if that is not neeed to be active.
```
#using the sparrow and crow which is of the same birdservices
spring.profiles.active=sparrow,crow,car,english
Field birdService in com.app2.controller.BirdController required a single bean, but 2 were found:
	- getCrowService: defined by method 'getCrowService' in class path resource [com/app2/config/BirdConfig.class]
	- getSparrowService: defined by method 'getSparrowService' in class path resource [com/app2/config/BirdConfig.class]

Action:

Consider marking one of the beans as @Primary, updating the consumer to accept multiple beans, or using @Qualifier to identify the bean that should be consumed

```

##### @Autowire by default injects bean by type, to modify by name in java configuration we can use **@Bean(name="name_of_bean")** and accessing the bean name using **@Qualifier("name_of_bean")**. By default, when using qualifier, spring can take the name of the method in the config.


