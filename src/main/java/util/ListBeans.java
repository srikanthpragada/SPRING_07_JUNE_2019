package util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ListBeans implements CommandLineRunner  {

	@Autowired
	ApplicationContext ctx;
	
	public static void main(String[] args) {
         SpringApplication.run(ListBeans.class, args);
	}
	
	public void run(String ... args) {
		for (String name : ctx.getBeanDefinitionNames())
			if (! name.startsWith("org"))
			    System.out.println(name);
	}

}
