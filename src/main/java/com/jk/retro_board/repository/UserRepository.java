package com.jk.retro_board.repository;

import com.jk.retro_board.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Shazin Sadakath
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
