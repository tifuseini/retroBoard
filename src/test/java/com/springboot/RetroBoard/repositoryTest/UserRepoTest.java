package com.springboot.RetroBoard.repositoryTest;

import com.springboot.RetroBoard.model.User;
import com.springboot.RetroBoard.repository.UserReposiitory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepoTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private UserReposiitory userReposiitory;

    @Test
    public void findByUsername_path_shoukdReturnAUser(){

        //Given
        User user = new User();
        user.setUsername("Tahiru");
        user.setPassword("root");
        user.setRole("User");
        testEntityManager.persist(user);
        testEntityManager.flush();;

        //Whem
        User actual = userReposiitory.findByUsername("Tahiru");

        //Then
        assertThat(actual).isEqualTo(user);


    }

    @Test
    public void save_path_ShouldSave1User(){

        //Given
        User user = new User();
        user.setUsername("Tahiru");
        user.setPassword("root");
        user.setRole("USER");

        //When
        User actual = userReposiitory.save(user);

        //Then
        assertThat(actual).isNotNull();
        assertThat(actual.getId()).isNotNull();

    }

}
