package com.huan.model;

import java.util.List;
import javax.persistence.*;

@Entity
@Table
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @OneToMany(targetEntity = Blog.class)
    private List<Blog> blogs;

    public Category() {
    }

    public List<Blog> getList() {
        return blogs;
    }

    public void setList(List<Blog> list) {
        this.blogs = list;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
