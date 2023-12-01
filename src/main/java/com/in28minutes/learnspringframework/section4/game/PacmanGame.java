package com.in28minutes.learnspringframework.section4.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PacmanGame implements GamingConsole {

    public void up() {
        System.out.println("Up");
    }

    public void down() {
        System.out.println("Down");
    }

    public void left() {
        System.out.println("Left");
    }

    public void right() {
        System.out.println("Right");
    }
}
