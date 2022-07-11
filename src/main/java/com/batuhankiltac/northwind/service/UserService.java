package com.batuhankiltac.northwind.service;

import com.batuhankiltac.northwind.core.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User add(User user);
    User update(User user);
    void delete(User user);
}