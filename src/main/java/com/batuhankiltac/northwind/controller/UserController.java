package com.batuhankiltac.northwind.controller;

import com.batuhankiltac.northwind.core.entity.User;
import com.batuhankiltac.northwind.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/getAll")
    public List<User> getAll() {
        return userService.getAll();
    }

    @PostMapping("/add")
    public User add(@Valid @RequestBody User user) {
        return userService.add(user);
    }

    @PutMapping("/update")
    public User update(@Valid @RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping("/delete")
    public void delete(@Valid @RequestBody User user) {
        userService.delete(user);
    }
}