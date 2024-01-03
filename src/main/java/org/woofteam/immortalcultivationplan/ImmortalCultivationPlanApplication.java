package org.woofteam.immortalcultivationplan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan(basePackages = "org.woofteam.immortalcultivationplan.*")
@MapperScan("org.woofteam.immortalcultivationplan.dao")
@PropertySource("datasource.properties")
public class ImmortalCultivationPlanApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImmortalCultivationPlanApplication.class, args);
    }

}
