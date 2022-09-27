package com.calisto.spring.rest_api.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Не указано имя пользователя.")
    @Size(min = 2, max = 255, message = "Введён не корректный размер имени пользователя.")
    private String name;
    @NotEmpty(message = "Не указан логин пользователя.")
    @Size(min = 2, max = 255, message = "Введён не корректный размер логина пользователя.")
    private String login;
    @Size(min = 2, max = 255, message = "Введён не корректный размер ИНН пользователя.")
    private String inn;
    @Email
    private String email;
    @Size(min = 12, max = 12, message = "Введён не корректный размер телефона организации.")
    private String phone;
    @NotEmpty(message = "Не указан пароль пользователя.")
    @Size(min = 8, max = 255, message = "Введён не корректный размер пароля пользователя.")
    private String password;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "company",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    private List<Company> companyList;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
    }
}
