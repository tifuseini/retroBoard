package com.springboot.RetroBoard.serviceTest;


import com.springboot.RetroBoard.model.User;
import com.springboot.RetroBoard.repository.UserReposiitory;
import com.springboot.RetroBoard.service.UserService;
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
    private UserReposiitory userReposiitory;

    private UserService userService;

    @Before
    public void init(){
        this.userService = new UserService(userReposiitory);
    }

    @Test
    public void getAllCommentsForToday_Path_shouldReturn1Comment(){

        //Given
        User user = new User();
        user.setUsername("tifuseini");
        user.setPassword("root");
        user.setRole("User");

        when(userReposiitory.findByUsername("tifuseini")).thenReturn(user);

        //When
        UserDetails actual = userService.loadUserByUsername("tifuseini");

        //Then
        verify(userReposiitory,times(1)).findByUsername("tifuseini");
    }
}
