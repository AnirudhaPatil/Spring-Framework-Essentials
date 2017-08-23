package com.oreilly;

import com.oreilly.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
import java.util.List;

@Configuration
@ComponentScan(basePackages = "com.oreilly")
public class AppConfig {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private List<Team> teams;   // Autowire all Components that implement Team and insert into List

    @Bean @Scope("prototype")   // "prototype" changes default instantiation from Singleton beans
    public Game game() {
        BaseballGame baseballGame = new BaseballGame(teams.get(0), teams.get(1));
        baseballGame.setDataSource(dataSource);

        return baseballGame;
    }
}
