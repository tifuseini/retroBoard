package com.springboot.RetroBoard.serviceTest;

import com.springboot.RetroBoard.model.Comment;
import com.springboot.RetroBoard.model.CommentType;
import com.springboot.RetroBoard.repository.CommentRepository;
import com.springboot.RetroBoard.service.CommentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

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

        //Given
        Comment comment = new Comment();
        comment.setComment("Test");
        comment.setType(CommentType.PLUS);
        comment.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        List<Comment> comments = Arrays.asList(comment);
        LocalDate now = LocalDate.now();

        when(commentRepository.
                findByCreatedYearAndMonthAndDay(now.getYear(),now.getMonth().getValue(),
                        now.getDayOfMonth())).thenReturn(comments);

        //When
        List<Comment> actualComments = commentService.getAllCommentsForToday();

        //Then
        verify(commentRepository,times(1)).findByCreatedYearAndMonthAndDay(now.getYear(),
                now.getMonth().getValue(),now.getDayOfMonth());
        assertThat(comments).isEqualTo(actualComments);
    }
}
