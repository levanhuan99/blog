package com.huan.repositories.blod_repository;

import com.huan.model.Blog;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
public class BlogRepositoryImpl implements BlogRepository {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List getAllBlog() {
        String sql = "select b  from Blog AS b ";
        TypedQuery<Blog> query = entityManager.createQuery(sql, Blog.class);
        return query.getResultList();
    }

    @Override
    public Blog findBlogById(Long id) {
        return entityManager.find(Blog.class, id);
    }

    @Override
    public void save(Blog blog) {
        if (blog.getId() != null) {
            entityManager.merge(blog);
        } else {
            entityManager.persist(blog);
        }
    }


    @Override
    public void delete(Long id) {
        Blog blog = entityManager.find(Blog.class, id);
        entityManager.remove(blog);
    }
}
