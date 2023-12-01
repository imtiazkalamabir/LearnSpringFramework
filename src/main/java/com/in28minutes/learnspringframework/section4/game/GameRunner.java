package com.in28minutes.learnspringframework.section4.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
    private GamingConsole game;
    // public GameRunner(@Qualifier("superContraGame")GamingConsole game) { /* use this way when no @Qualifier annotation is mentioned in the specific class */
    public GameRunner(@Qualifier("SuperContraGameQualifier")GamingConsole game) {
        this.game = game;
    }

    public void run() {
        System.out.println("Running game: " + game);
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
