package com.in28minutes.learnspringframework.section3.a0;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan //auto scan on current package
public class SimpleSpringContextLauncherApplication {

    public static void main(String [] args) {
        /*// var game = new MarioGame();
        //var game = new SuperContraGame();
        var game = new PacmanGame();
        var gameRunner = new GameRunner(game);
        gameRunner.run();*/

        try(var context = new AnnotationConfigApplicationContext(SimpleSpringContextLauncherApplication.class)) {
            // Print all Bean names
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);

        }
    }
}
