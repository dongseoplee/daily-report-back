package com.bulletinboard.bulletinboard.service;


import com.bulletinboard.bulletinboard.domain.Comment;
import com.bulletinboard.bulletinboard.dto.CommentDTO;
import com.bulletinboard.bulletinboard.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getComments() {
        return commentRepository.findAll();
    }

    public List<Comment> getCommentsByBoardId(Long board_id) {
        return commentRepository.findByBoardId(board_id);
    }

    public Comment saveComment(CommentDTO commentDTO) {
        Comment comment = convertToEntity(commentDTO);

        return commentRepository.save(comment);
    }

    public Comment convertToEntity(CommentDTO commentDTO) {
        Comment comment = new Comment();

//        외래키 set get 함수 필요
        comment.setUsername(comment.getUsername());
        comment.setContent(comment.getContent());
        comment.setYyyymmdd(comment.getYyyymmdd());

        return comment;
    }
}
