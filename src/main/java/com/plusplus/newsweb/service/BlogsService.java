package com.plusplus.newsweb.service;


import com.plusplus.newsweb.controller.request.NewBlogsRequest;
import com.plusplus.newsweb.entity.BlogsEntity;
import com.plusplus.newsweb.entity.CategoryEntity;
import com.plusplus.newsweb.entity.repository.AuthorRepository;
import com.plusplus.newsweb.entity.repository.BlogsRepository;
import com.plusplus.newsweb.entity.repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.BlockingQueue;

@Service
public class BlogsService {
    private static final Logger logger = LoggerFactory.getLogger(NewsService.class);
    @Autowired
    BlogsRepository blogsRepository;
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    CategoryRepository categoryRepository;


    public BlogsEntity addBlogsEntity(NewBlogsRequest Blogs) {
       BlogsEntity blogsEntity = new BlogsEntity();
//            blogsEntity = new BlogsEntity();
        if (Blogs.getAuthor() != null) {
            blogsEntity.setAuthor(Blogs.getAuthor());
            if (Blogs.getTitle() != null) {
                blogsEntity.setTitle(Blogs.getTitle());
            }
            if (Blogs.getDescription() != null) {
                blogsEntity.setDescription(Blogs.getDescription());
            }
            if (Blogs.getAvatar() != null) {
                blogsEntity.setAvatar(Blogs.getAvatar());
            }
            if (Blogs.getContent() != null) {
                blogsEntity.setContent(Blogs.getContent());
            }
            if (Blogs.getCategoryId() != null) {
                blogsEntity.setCategoryId(Blogs.getCategoryId());
            }
            blogsEntity.setTimePosting(new Timestamp(System.currentTimeMillis()));
            blogsEntity.setStatus("ACTIVE");
            blogsEntity.setLike(0);
            blogsEntity.setView(0);
        }

        return blogsRepository.save(blogsEntity);
    }


    public List<BlogsEntity> findAllBlogs(String status) {
        List data = blogsRepository.findALLByStatus(status);
        return data;
    }

    public BlogsEntity findBlogsByID(Integer id) {
        BlogsEntity data = blogsRepository.findAllById(id);
//        String date = data.getTimePosting().toString();
        return data;
    }

    public List<BlogsEntity> findAllByCategoryId(Integer categoryId) {
        List<BlogsEntity> data = blogsRepository.findAllByCategoryId(categoryId);
        return data;
    }

    public List<BlogsEntity> findAllByAuthor(String author) {
        List<BlogsEntity> data = blogsRepository.findAllByAuthor(author);
        return data;
    }

    public List<BlogsEntity> findAllByTitle(String title) {
        List<BlogsEntity> data = (List<BlogsEntity>) blogsRepository.findAllByTitle(title);
        return data;
    }

    public List<CategoryEntity> findAll() {
        List<CategoryEntity> categoryEntityList = categoryRepository.findAll();
        return categoryEntityList;
    }
}
