package com.calisto.spring.rest_api.service.user;

import com.calisto.spring.rest_api.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAll();
    public User add(User user);
    public User getUser(int id);
    public void delete(int id);

    User getLoginEndPass(User user);
}
