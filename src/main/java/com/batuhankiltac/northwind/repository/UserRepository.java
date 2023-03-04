package com.batuhankiltac.northwind.repository;

import com.batuhankiltac.northwind.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}