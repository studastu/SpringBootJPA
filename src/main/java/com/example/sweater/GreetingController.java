package com.example.sweater;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/*
 Контроллер - программный модуль, который по пути /greeting
 слушает запросы от пользователей и возвращает запросы
 и будет возвращать файл шаблона (return "greeting")
 */
@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name="name", required=false, defaultValue="World") String name,
            /*Model model //то,куда будет складывать файлы,кот-е хотим вернуть юзеру(html)*/
            Map<String, Object> model
    ) {
        //model.addAttribute("name", name);
        model.put("name", name);
        return "greeting";
    }

    //GetMapping ниже будет работать сразу на localhost (а не localhost/greeting)
    @GetMapping
    public String main(Map<String, Object> model) {
        model.put("main-info", "My first Spring app!");
        return "main";
    }

}
