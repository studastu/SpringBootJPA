package com.example.sweater.repos;

import com.example.sweater.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    //нам нужен метод, который будет возвращать пользователя
    User findByUsername(String username);
}
