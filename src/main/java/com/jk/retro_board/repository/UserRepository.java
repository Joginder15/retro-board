package com.jk.retro_board.repository;

import com.jk.retro_board.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUsername(String userName);
}
