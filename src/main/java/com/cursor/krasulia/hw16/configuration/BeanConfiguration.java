package com.cursor.krasulia.hw16.configuration;

import com.cursor.krasulia.hw16.entity.robot_component.Head;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public Head getHead() {
        return new Head();
    }
}
