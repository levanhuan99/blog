package com.huan.service;

import com.huan.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {

    Page<Blog> getAllBlog(Pageable pageable);

    Blog findById(Long id);

    void  save(Blog blog);

    void delete(Long id);

    List<Blog> getAllBlogs();
}
