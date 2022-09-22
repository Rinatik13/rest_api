package com.calisto.spring.rest_api.service.user;

import com.calisto.spring.rest_api.DaO.user.UserDaO;
import com.calisto.spring.rest_api.entity.User;
import com.calisto.spring.rest_api.logic.BuildPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDaO userDaO;

    @Override
    @Transactional
    public List<User> getAll() {
        return userDaO.getAll();
    }

    @Override
    @Transactional
    public User add(User user) {
        userDaO.add(user);
        BuildPath.buildUserPath(user);
        return user;
    }

    @Override
    @Transactional
    public User getUser(int id) {
        return userDaO.getUser(id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userDaO.delete(id);
    }

    @Override
    @Transactional
    public User getLoginEndPass(User user) {
        String login = user.getLogin();
        String password = user.getPassword();
        User result = null;
        List<User> userList = userDaO.getAll();

        for (User myUser : userList) {
            if (myUser.getLogin().equals(login)){
                if (myUser.getPassword().equals(password)){
                    result=myUser;
                }
            }
        }
        return result;
    }
}
