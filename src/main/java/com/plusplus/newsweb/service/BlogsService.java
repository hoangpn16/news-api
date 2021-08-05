package com.plusplus.newsweb.service;


import com.plusplus.newsweb.controller.request.NewBlogsRequest;
import com.plusplus.newsweb.controller.request.NewNewsRequest;
import com.plusplus.newsweb.entity.BlogsEntity;
import com.plusplus.newsweb.entity.NewsEntity;
import com.plusplus.newsweb.entity.repository.AuthorRepository;
import com.plusplus.newsweb.entity.repository.BlogsRepository;
import com.plusplus.newsweb.entity.repository.Img_BlogsRepository;
import com.plusplus.newsweb.entity.repository.NewsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogsService {
    private static final Logger logger = LoggerFactory.getLogger(NewsService.class);
    @Autowired
    BlogsRepository blogsRepository;
    @Autowired
    Img_BlogsRepository img_blogsRepository;
    @Autowired
    AuthorRepository authorRepository;
    public List<BlogsEntity> addBlogsEntity(NewBlogsRequest Blogs, String status) {
        BlogsEntity blogsEntity = blogsRepository.findByStatus(Blogs.getTitle());
        if (blogsEntity == null){
            blogsEntity = new BlogsEntity();
            if (Blogs.getTitle() != null){
                blogsEntity.setTitle(Blogs.getTitle());
            }
            if (Blogs.getDescription() != null){
                blogsEntity.setDescription(Blogs.getDescription());
            }
            if (Blogs.getAuthor() != null){
                blogsEntity.setAuthor(Blogs.getAuthor());
            }
            if (Blogs.getAvatar() != null){
                blogsEntity.setAvatar(Blogs.getAvatar());
            }
            if (Blogs.getContent() != null){
                blogsEntity.setContent(Blogs.getContent());
            }
//           blogsEntity.setTimePosting();
        }
        return null;
    }



}
