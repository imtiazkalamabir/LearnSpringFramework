package com.in28minutes.learnspringframework.section4.f1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class SomeClass {
    private SomeDependency someDependency;

    public SomeClass(SomeDependency someDependency) {
        super();
        this.someDependency = someDependency;
        System.out.println("All dependencies are ready!");
    }

    @PostConstruct // some logic to execute immediately after dependencies are wired in/injected
    public void initialize() {
        someDependency.getReady();
    }

    @PreDestroy //use to release resources just before bean is removed from the container and application context
    public void cleanup() {
        System.out.println("Cleanup");
    }
}

@Component
class SomeDependency {
    public void getReady() {
        System.out.println("Some logic using SomeDependency");
    }
}

@Configuration
@ComponentScan //auto scan on current package
public class PrePostAnnotationsContextLauncherApplication {

    public static void main(String [] args) {
        /*// var game = new MarioGame();
        //var game = new SuperContraGame();
        var game = new PacmanGame();
        var gameRunner = new GameRunner(game);
        gameRunner.run();*/

        try(var context = new AnnotationConfigApplicationContext(PrePostAnnotationsContextLauncherApplication.class)) {
            // Print all Bean names
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);

        }
    }
}
