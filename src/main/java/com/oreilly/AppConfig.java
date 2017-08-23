package com.oreilly;

import com.oreilly.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.oreilly")
public class AppConfig {

    @Autowired
    private DataSource dataSource;

    @Autowired @Qualifier("redSox")
    private Team home;

    @Autowired @Qualifier("cubs")
    private Team away;

    @Bean
    public Game game() {
        BaseballGame baseballGame = new BaseballGame(home, home);
        baseballGame.setDataSource(dataSource);

        return baseballGame;
    }

//    @Bean
//    public Team redSox() {
//        return new RedSox();
//    }
//
//    @Bean
//    public Team cubs() {
//        return new Cubs();
//    }
}
