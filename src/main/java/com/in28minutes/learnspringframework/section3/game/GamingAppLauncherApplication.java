package com.in28minutes.learnspringframework.section3.game;

import com.in28minutes.learnspringframework.section3.game.GameRunner;
import com.in28minutes.learnspringframework.section3.game.GamingConsole;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.in28minutes.learnspringframework.section3.game")
public class GamingAppLauncherApplication {

    public static void main(String [] args) {
        /*// var game = new MarioGame();
        //var game = new SuperContraGame();
        var game = new PacmanGame();
        var gameRunner = new GameRunner(game);
        gameRunner.run();*/

        try(var context = new AnnotationConfigApplicationContext(com.in28minutes.learnspringframework.section3.game.GamingAppLauncherApplication.class)) {
            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();
        }
    }
}
