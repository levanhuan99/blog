package com.huan.service;

import com.huan.model.Comment;

import java.util.List;

public interface CommentService {
    void save(Comment comment);
    List<Comment> findAllByBlog_Id(Long id);

}
