package com.springboot.RetroBoard.controllerTest;

import com.springboot.RetroBoard.controller.CommentController;
import com.springboot.RetroBoard.service.CommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.Mockito.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CommentController.class)
public class CommentControllerTeest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CommentService commentService;


    @Test
    public void saveCommentShouldeturnstatus302() throws Exception {
        //When
        ResultActions resultActions = mockMvc.perform(post("/comment")
                .with(csrf()).with(user("tifuseini").roles("USER"))
                .param("plusComment", "Test Plus"));

        // Then
        resultActions
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));

        verify(commentService,times(1)).saveAll(anyList());
        verifyNoMoreInteractions(commentService);
    }


}
