package com.in28minutes.learnspringframework.section2;

import com.in28minutes.learnspringframework.section2.game.GameRunner;
import com.in28minutes.learnspringframework.section2.game.GamingConsole;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02GamingSpringBeans {

    public static void main(String [] args) {


        /*// var game = new MarioGame();
        //var game = new SuperContraGame();
        var game = new PacmanGame();
        var gameRunner = new GameRunner(game);
        gameRunner.run();*/
        try(var context = new AnnotationConfigApplicationContext(GamingConfiguration.class)) {
            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();
        }

    }
}
