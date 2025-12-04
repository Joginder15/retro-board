package com.jk.retro_board;


import com.jk.retro_board.domain.User;
import com.jk.retro_board.repository.UserRepository;
import com.jk.retro_board.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class UserServiceTest {

    @MockBean
    private UserRepository userRepository;

    private UserService userService;

    @Before
    public void init() {
        this.userService = new UserService(userRepository);
    }

    @Test
    public void getAllCommentsForToday_HappyPath_ShouldReturn1Comment() {
        // Given
        User user = new User();
        user.setUsername("joginder");
        user.setPassword("jog@123");
        user.setRole("USER");

        when(userRepository.findByUsername("joginder")).thenReturn(user);

        // When
        UserDetails actual = userService.loadUserByUsername("joginder");

        // Then
        verify(userRepository, times(1)).findByUsername("joginder");
    }
}
