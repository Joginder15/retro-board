package com.jk.retro_board;

import com.jk.retro_board.domain.User;
import com.jk.retro_board.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
public class UserRepoTest {

    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByUsername_HappyPath_ShouldReturn1User() throws Exception{
        // Given
        User user = new User();
        user.setUsername("Joginder");
        user.setPassword("jog123");
        user.setRole("USER");
        testEntityManager.persist(user);
        testEntityManager.flush();

        // When
        User actual = userRepository.findByUsername("Joginder");

        // Then
        assertThat(actual).isEqualTo(user);
    }

    @Test
    public void save_HappyPath_ShouldSave1User() throws Exception {
        // Given
        User user = new User();
        user.setUsername("shazin");
        user.setPassword("shaz980");
        user.setRole("USER");

        // When
        User actual = userRepository.save(user);

        // Then
        assertThat(actual).isNotNull();
        assertThat(actual.getId()).isNotNull();
    }
}
