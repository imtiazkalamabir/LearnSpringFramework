package com.in28minutes.learnspringframework.section3.a1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component
class YourBusinessClass {

    //Field Injection
    //@Autowired
    Dependency1 dependency1;
    //@Autowired
    Dependency2 dependency2;

    /*@Autowired
    public void setDependency1(Dependency1 dependency1) {
        System.out.println("Setter Injection - setDependency1");
        this.dependency1 = dependency1;
    }
    @Autowired
    public void setDependency2(Dependency2 dependency2) {
        System.out.println("Setter Injection - setDependency2");
        this.dependency2 = dependency2;
    }*/

    //@Autowired - not required for construction injection
    // Spring team recommends constructor injection since all the initialization occurs just in one method
    public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
        System.out.println("Constructor Injection - YourBusinessClass");
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

    public String toString() {
        return "Using " + dependency1 + " and " + dependency2;
    }

}
@Component
class Dependency1{

}
@Component
class Dependency2 {

}

@Configuration
@ComponentScan //auto scan will be performed on current package if no package name is specified
public class DependencyInjectionLauncherApplication {

    public static void main(String [] args) {
        /*// var game = new MarioGame();
        //var game = new SuperContraGame();
        var game = new PacmanGame();
        var gameRunner = new GameRunner(game);
        gameRunner.run();*/

        try(var context = new AnnotationConfigApplicationContext(DependencyInjectionLauncherApplication.class)) {
            // Print all Bean names
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);
            System.out.println(context.getBean(YourBusinessClass.class));

        }
    }
}
