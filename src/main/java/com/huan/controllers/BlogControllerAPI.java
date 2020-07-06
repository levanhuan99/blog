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
        List<Comment> comments=commentService.findAllByBlog_Id(blog.getId());
        blog.setComments(comments);
        blogService.save(blog);
        return blog;
    }

    @PostMapping("/saveComment")
    public void saveComment(@RequestBody Comment comment,@RequestBody Long id) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        comment.setPostTime(timestamp);
        Blog blog=blogService.findById(id);
        comment.setBlog(blog);
        commentService.save(comment);
    }

    @GetMapping("/getAllComment")
    public List<Comment> getAllComment(@RequestBody Long id) {
        return commentService.findAllByBlog_Id(id);

    }
}

