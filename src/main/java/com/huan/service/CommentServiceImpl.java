package com.huan.service;

import com.huan.model.Comment;
import com.huan.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
public class CommentServiceImpl  implements CommentService{
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void save(Comment comment) {
         commentRepository.save(comment);

    }

    @Override
    public List<Comment> findAllByBlog_Id(Long id) {
        return commentRepository.findAllByBlog_Id(id);
    }


}
