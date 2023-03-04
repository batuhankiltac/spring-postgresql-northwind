package com.batuhankiltac.northwind.service.user;

import com.batuhankiltac.northwind.entity.User;
import com.batuhankiltac.northwind.repository.UserRepository;
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
        User foundUser = userRepository.findById(user.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found."));
        foundUser.setUserId(user.getUserId());
        foundUser.setEmail(user.getEmail());
        foundUser.setPassword(user.getPassword());
        return userRepository.save(foundUser);
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }
}