package com.springboot.RetroBoard.controllerTest;

import com.springboot.RetroBoard.controller.CommentController;
import com.springboot.RetroBoard.service.CommentService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(CommentController.class)
public class CommentControllerTeest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CommentService commentService;


}
