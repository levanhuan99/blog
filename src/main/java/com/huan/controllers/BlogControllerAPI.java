package com.huan.controllers;

import com.huan.model.Blog;
import com.huan.model.Category;
import com.huan.service.BlogService;
import com.huan.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class BlogControllerAPI {
    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/blogAPI" , method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getAll() {
        Iterable<Category> list = categoryService.finAll();

        return new ResponseEntity<List<Category>>(HttpStatus.OK);
    }

}
