package com.in28minutes.learnspringframework.section2;

import com.in28minutes.learnspringframework.section2.game.GameRunner;
import com.in28minutes.learnspringframework.section2.game.GamingConsole;
import com.in28minutes.learnspringframework.section2.game.PacmanGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfiguration {

    @Bean
    public GamingConsole game() {
        var game = new PacmanGame();
        return game;
    }

    @Bean
    public GameRunner gamerRunner(GamingConsole game) {
        var gameRunner = new GameRunner(game);
        return gameRunner;
    }
    // var game = new MarioGame();
    //var game = new SuperContraGame();
    /*var game = new PacmanGame();
    var gameRunner = new GameRunner(game);
        gameRunner.run();
    */
}
