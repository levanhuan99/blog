package com.huan.controllers;

import com.huan.model.Blog;
import com.huan.model.Category;
import com.huan.model.Comment;
import com.huan.service.BlogService;
import com.huan.service.CategoryService;
import com.huan.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class BlogControllerAPI {
    @Autowired
    private BlogService blogService;


    @Autowired
    private CommentService commentService;

    @GetMapping("")
    public List<Blog> allBlogs() {
        return blogService.getAllBlogs();
    }

    @PutMapping("/{id}")
    public Blog like(@PathVariable Long id) {
        Blog blog1 = blogService.findById(id);
        blog1.setLikes(blog1.getLikes() + 1);
        blogService.save(blog1);
        return blog1;
    }

    @PostMapping("/add")
    public Blog addBlog(@RequestBody Blog blog) {
        blog.setPostTime(new Timestamp(System.currentTimeMillis()));
        List<Comment> comments = commentService.findAllByBlog_Id(blog.getId());
        blog.setComments(comments);
        blogService.save(blog);
        return blog;
    }

    @PostMapping("/saveComment/{id}")
    public void saveComment(@PathVariable Long id ,@RequestBody Comment comment) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Blog blog = blogService.findById(id);
        comment.setPostTime(timestamp);
        comment.setBlog(blog);
        commentService.save(comment);
    }

    @GetMapping("/getAllComment/{id}")
    public List<Comment> getAllComment(@PathVariable Long id) {
        List<Comment> list= commentService.findAllByBlog_Id(id);
        return list;
    }
}







