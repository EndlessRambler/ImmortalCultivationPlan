package org.woofteam.immortalcultivationplan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.woofteam.immortalcultivationplan.mapper")
public class ImmortalCultivationPlanApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImmortalCultivationPlanApplication.class, args);
    }

}
