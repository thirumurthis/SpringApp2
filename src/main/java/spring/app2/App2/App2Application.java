package spring.app2.App2;

import com.app2.controller.LanguageController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//the class is placed in different package and
@ComponentScan({"com.app2.service.*","com.app2.controller"})
public class App2Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(App2Application.class, args);

		LanguageController languageController = (LanguageController) ctx.getBean("languageController");
		languageController.sayHello();

	}

}
