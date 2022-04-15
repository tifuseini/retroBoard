package com.springboot.RetroBoard.serviceTest;

import com.springboot.RetroBoard.repository.CommentRepository;
import com.springboot.RetroBoard.service.CommentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CommentServiceTest {

    @MockBean
    private CommentRepository commentRepository;

    private CommentService commentService;

    @Before
    public void init(){
        commentService =new CommentService(commentRepository);
    }

    @Test
    public void getAllComment4Today_Path_ShouldReturn1Comment(){

        //Giveb
    }
}
