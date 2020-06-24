package com.huan.service;

import com.huan.model.Blog;

import java.util.List;

public interface BlogService {

    List<Blog> getAllBlog();

    Blog findById(Long id);

    void  save(Blog blog);

    void delete(Long id);

}
