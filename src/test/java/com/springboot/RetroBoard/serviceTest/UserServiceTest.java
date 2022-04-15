package com.springboot.RetroBoard.serviceTest;


import com.springboot.RetroBoard.repository.UserReposiitory;
import com.springboot.RetroBoard.service.UserService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class UserServiceTest {

    @MockBean
    private UserReposiitory userReposiitory;

    private UserService userService;

    @Before
    public void init(){
        this.userService = userService;
    }
}
