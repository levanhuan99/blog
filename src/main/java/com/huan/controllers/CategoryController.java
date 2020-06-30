package com.huan.controllers;

import com.huan.model.Category;
import com.huan.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
@Controller

@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping()
    public ModelAndView categoryList(){
        List<Category> categoryList= (List<Category>) categoryService.finAll();
        ModelAndView modelAndView=new ModelAndView("/category/list");
        modelAndView.addObject("categories",categoryList);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Category category=categoryService.findById(id);
        ModelAndView modelAndView=new ModelAndView("/category/edit_form");
        modelAndView.addObject("category",category);
        return modelAndView;
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Category category){
        categoryService.save(category);
        return "redirect:/categories";
    }
    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Category category=categoryService.findById(id);
        ModelAndView modelAndView=new ModelAndView("/category/delete_form");
        modelAndView.addObject("category",category);
        return modelAndView;

    }


    @PostMapping("/delete")
    public String delete(@ModelAttribute Category category){
        categoryService.remove(category);
        return "redirect:/categories";
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView=new ModelAndView("/category/create_form");
        modelAndView.addObject("category",new Category());
        return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute Category category){
        categoryService.save(category);
        ModelAndView modelAndView=new ModelAndView("/category/create_form");
        modelAndView.addObject("message","created");
        modelAndView.addObject("category",new Category());
        return modelAndView;
    }
}


