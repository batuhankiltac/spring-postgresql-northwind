package com.batuhankiltac.northwind.service.user;

import com.batuhankiltac.northwind.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User add(User user);
    User update(User user);
    void delete(Integer id);
}