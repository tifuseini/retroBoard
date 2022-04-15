package com.springboot.RetroBoard.repository;

import com.springboot.RetroBoard.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {

    @Query("select c from Comment c where year(c.createdDate) = ?1 and month(c.createdDate) = ?2 and day(c.createdDate) = ?3")
    List<Comment> findByCreatedYearAndMonthAndDay(int year,int month,int day);

}
