package com.huan.service;

import com.huan.model.Blog;
import com.huan.repositories.blod_repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;


    @Override
    public List<Blog> getAllBlog() {

        return blogRepository.getAllBlog();
    }

    @Override
    public Blog findById(Long id) {
        Blog blog= blogRepository.findBlogById(id);
        return blog;
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void delete(Long id) {
        blogRepository.delete(id);
    }
}
