package com.huan.repositories;

import com.huan.model.Blog;
import com.huan.model.Comment;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BlogRepository extends PagingAndSortingRepository<Blog,Long> {
}
