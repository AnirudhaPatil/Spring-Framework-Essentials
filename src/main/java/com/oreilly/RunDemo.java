package com.oreilly;

import com.oreilly.entities.Game;
import com.oreilly.entities.Team;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunDemo {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Game game = context.getBean("game", Game.class);

        System.out.println(game.playGame());

        Team royals = context.getBean("royals", Team.class);
        game.setAwayTeam(royals);

        System.out.println(game.playGame());

//        System.out.println("There are " + context.getBeanDefinitionCount() + " beans");
//        for (String name : context.getBeanDefinitionNames()) {
//            System.out.println(name);
//        }
    }
}
