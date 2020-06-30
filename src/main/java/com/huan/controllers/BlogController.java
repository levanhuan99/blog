package com.huan.controllers;


import com.huan.model.Blog;
import com.huan.model.Category;
import com.huan.service.BlogService;
import com.huan.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.util.List;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categories")
    public List<Category> categories(){
        return (List<Category>) categoryService.finAll();
    }

    @GetMapping()
    public ModelAndView blog(@PageableDefault(size = 5) Pageable pageable) {
        Page<Blog> list =blogService.getAllBlog(pageable);
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("blogs", list);
        return modelAndView;
    }

    @GetMapping("/blog_list")
    public ModelAndView listBlog(Pageable pageable) {
        Page<Blog> list =blogService.getAllBlog(pageable);
        ModelAndView modelAndView = new ModelAndView("/list_name");
        modelAndView.addObject("blogs", list);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView getEditForm(@PathVariable Long id) {
        Blog blog = blogService.findById(id);

        ModelAndView modelAndView = new ModelAndView("/edit_form");
        modelAndView.addObject("blog", blog);
        return modelAndView;

    }

    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog) {
//        Blog blog1=blogService.findById(blog.getId());
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        blog.setPostTime(timestamp);
        blogService.save(blog);
        return "redirect:/blogs/blog_list";
    }

    @GetMapping("/create")
    public String createForm() {
        return "/create_form";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        blog.setPostTime(timestamp);
        blogService.save(blog);
        return "redirect:/blogs";

    }

    @RequestMapping("/like/{id}")
    public String like(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        blog.setLikes(blog.getLikes() + 1);
        blogService.save(blog);
        return "redirect:/blogs";

    }

    @RequestMapping("/dislike/{id}")

    public String dislike(@PathVariable Long id) {
        Blog blog = blogService.findById(id);

        blog.setDislike(blog.getDislike() + 1);
        blogService.save(blog);
        return "redirect:/blogs";


    }
}
