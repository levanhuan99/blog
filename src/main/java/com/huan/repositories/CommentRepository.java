package com.huan.repositories;

import com.huan.model.Blog;
import com.huan.model.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;
public interface CommentRepository  extends CrudRepository<Comment,Long> {

    List<Comment> findAllByBlog_Id(Long id);

}
