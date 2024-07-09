package com.example.sweater.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
Этот класс содержит конфигурацию нашего веб-слоя
И здесь как раз тот случай, когда не нужно создавать свой контроллер
Здесь раздаются странички которые просто шаблоны и на них нет никакой логики
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }
}