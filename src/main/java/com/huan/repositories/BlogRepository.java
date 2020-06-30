package com.huan.repositories;

import com.huan.model.Blog;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BlogRepository extends PagingAndSortingRepository<Blog,Long> {
}
