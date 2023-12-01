package com.in28minutes.learnspringframework.section1;

import com.in28minutes.learnspringframework.section2.game.GameRunner;
import com.in28minutes.learnspringframework.section2.game.PacmanGame;

public class AppGamingBasicJava {

    public static void main(String [] args) {
        // var game = new MarioGame();
        //var game = new SuperContraGame();
        var game = new PacmanGame();
        var gameRunner = new GameRunner(game);
        gameRunner.run();
    }
}
