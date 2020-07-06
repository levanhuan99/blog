package com.huan.service;

import com.huan.model.Blog;

import com.huan.model.Category;
import com.huan.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Page<Blog> getAllBlog(Pageable pageable) {

        return blogRepository.findAll(pageable);
    }
    @Override
    public List<Blog> getAllBlogs(){
        return (List<Blog>) blogRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        Blog blog= blogRepository.findOne(id);
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
