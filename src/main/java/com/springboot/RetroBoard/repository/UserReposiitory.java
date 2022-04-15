package com.springboot.RetroBoard.repository;

import com.springboot.RetroBoard.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReposiitory extends JpaRepository<User,Long> {

    User findByUsername(String username);
}
