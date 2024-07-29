package com.example.sweater.controller;

import com.example.sweater.domain.Role;
import com.example.sweater.domain.User;
import com.example.sweater.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        User userFromDb = userRepo.findByUsername(user.getUsername());

        //если пользователь не равен null, то об этом нужно сообщить на экране.
        //для этого выше добавляем второй параметр model
        if (userFromDb != null) {
            model.put("message", "User exists!");
            return "registration"; //т.е. сообщаем об этом на странице регистрации
            //соответственно, ниже добавляем на страницу регистрации код(1)
        }

        //если такого пользователя ещё нет, то нужно обработать данные
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        // на вход setRoles ожидается коллекция в виде сета (Set<Role>),
        // но т.к. у нас всего лишь одно значение, мы можем использовать шоткат Collections.singleton(), который создаёт сет с одним единственным значением
        userRepo.save(user);

        //при успешной регистрации мы будем делать редирект на страницу логина
        return "redirect:/login";
    }
}
