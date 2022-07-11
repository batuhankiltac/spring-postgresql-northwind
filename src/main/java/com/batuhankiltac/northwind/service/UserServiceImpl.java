package com.batuhankiltac.northwind.service;

import com.batuhankiltac.northwind.core.entity.User;
import com.batuhankiltac.northwind.core.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        this.userRepository.findById(user.getUserId());
        user.setUserId(user.getUserId());
        user.setEmail(user.getEmail());
        user.setPassword(user.getPassword());
        return userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }
}