package com.oreilly;

import com.oreilly.entities.Game;
import com.oreilly.entities.Team;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.NumberFormat;

public class RunDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        // ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                context.close();
            }
        });

        // NumberFormat nf = context.getBean(NumberFormat.class);
        // double amount = 12345678.9012345;
        // System.out.println(nf.format(amount));

        // Team royals = context.getBean("royals", Team.class);

        Game game1 = context.getBean("game", Game.class);
        System.out.println(game1);

//        Game game2 = context.getBean("game", Game.class);
//        game2.setAwayTeam(royals);
//        System.out.println(game2);
//
//        System.out.println(game1);

        // System.out.println("There are " + context.getBeanDefinitionCount() + " beans");
        // for (String name : context.getBeanDefinitionNames()) {
        //     System.out.println(name);
        // }
    }
}
