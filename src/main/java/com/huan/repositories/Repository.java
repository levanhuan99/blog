package com.huan.repositories;
import com.huan.model.Blog;

import java.util.List;

public interface Repository<T> {

    List<T> getAllBlog();

    T findBlogById(Long id);

    void  save(Blog blog);

    void delete(Long id);

}
