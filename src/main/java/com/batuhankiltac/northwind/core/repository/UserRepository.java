package com.batuhankiltac.northwind.core.repository;

import com.batuhankiltac.northwind.core.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}