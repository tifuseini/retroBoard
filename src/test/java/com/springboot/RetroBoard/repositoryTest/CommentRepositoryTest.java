package com.springboot.RetroBoard.repositoryTest;

import com.springboot.RetroBoard.model.Comment;
import com.springboot.RetroBoard.model.CommentType;
import com.springboot.RetroBoard.repository.CommentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private CommentRepository commentRepository;

    @Test
    public void findByCreatedYearAndMonthAndDay_Path_ShouldReturn1Comment(){

        //Given
        Comment comment = new Comment();
        comment.setComment("Test");
        comment.setType(CommentType.PLUS);
        comment.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        testEntityManager.persist(comment);
        testEntityManager.flush();

        //When
        LocalDate now = LocalDate.now();
        List<Comment> comments = commentRepository.findByCreatedYearAndMonthAndDay(now.getYear(),now.getMonth().getValue(),now.getDayOfMonth());


        //Then
        assertThat(comments).hasSize(1);
        assertThat(comments.get(0)).hasFieldOrPropertyWithValue("comment","Test");


    }

    @Test
    public void  save_path_ShouldSave1Comment(){

        //Given
        Comment comment = new Comment();
        comment.setComment("Test");
        comment.setType(CommentType.PLUS);
        comment.setCreatedDate(new Timestamp(System.currentTimeMillis()));

        //When
        Comment saved = commentRepository.save(comment);

        //Then
        assertThat(testEntityManager.find(Comment.class,saved.getId())).isEqualTo(saved);
    }
}
