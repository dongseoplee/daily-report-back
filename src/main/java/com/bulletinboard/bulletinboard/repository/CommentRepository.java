package com.bulletinboard.bulletinboard.repository;

import com.bulletinboard.bulletinboard.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("SELECT c FROM Comment c WHERE c.board_id = :boardId")
    public List<Comment> findByBoardId(@Param("boardId") Long boardId);

    public void deleteById(Long id);
}
