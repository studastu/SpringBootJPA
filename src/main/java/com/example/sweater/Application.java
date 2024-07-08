package com.example.sweater;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

/*
Данный файл будет запускать всё приложение.
@SpringBootApplication - аннотация, которая добавляет какие-то специальные обвесы,
которые всё это поднимут, проверят, надут какие-то контроллеры,
найдут файлы для подключения к БД и т.д.
 */