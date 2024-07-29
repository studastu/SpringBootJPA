package com.example.sweater.domain;

import jakarta.persistence.*;
import java.util.Set;


@Entity
@Table(name = "usr") //т.е. храниться будет в таблице usr
public class User {
    @Id //поле id
    @GeneratedValue(strategy = GenerationType.AUTO) //автогенерация ID
    private Long id;
    private String username;
    private String password;
    private boolean active; //признак активности

    /*
    ElementCollection позволяет нам избавиться от головной боли по формированию дополнительной таблицы для хранения enum-а.
    Enum не такая сложная структура, чтоб там что-то городить совсем особенное.
    fetch - определяет, как данные значения будут подгружаться относительно основной сущности (user).
    Когда мы загружаем пользователя, его роли хранятся в отдельной таблице и нам необходимо загружать их либо жадным способом, либо ленивым.
    Жадный (EAGER) - hibernate сразу же при запросе пользователя будет подгружать все его роли (ускоряет работу, но потребляет больше памяти).
    Ленивый (LAZY) - hibernate подгрузит роли только тогда, когда пользователь реально обратиться к этому полю (хорош, когда хранится много записей
    (например класс Институт содержащий несколько тысяч Студентов и нам не нужно подгружать сразу всех студентов, они нам нужны по мере необходимости).
     */
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)

    /*
     CollectionTable описывает, что данное поле будет храниться в отдельной таблице, для которой мы не описывали мэппинг.
     В итоге создаётся таблица user_role для перечисленного набора полей, которая будет соединяться с текущей таблицей через user_id
     */
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING) //хотим этот enum хранить в виде строки
    //У юзеров будет ролевая система (админ, юзер, модератор)
    private Set<Role> roles; //Role - это как раз enum, который мы создали заранее

    //Alt+Ins / генерируем геттеры и сеттеры для всех полей

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}