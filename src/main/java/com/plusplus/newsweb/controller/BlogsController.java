package com.plusplus.newsweb.controller;


import com.plusplus.newsweb.controller.request.NewBlogsRequest;
import com.plusplus.newsweb.entity.*;
import com.plusplus.newsweb.service.BlogsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/news/blogs/")
public class BlogsController {
    private static final Logger logger = LoggerFactory.getLogger(NewsRestController.class);

    @Autowired
    BlogsService service;

    @GetMapping( value= "/")
    public String getBlogs(Model model, @RequestParam(name = "orderBy", defaultValue = "createdTime") String orderBy,
                           @RequestParam(name = "order", required = false) Integer cateId,
                           @RequestParam(name = "pageNum", defaultValue = "0") Integer pageNum) {
        model.addAttribute("pageNum", pageNum);
        model.addAttribute("cate", cateId);
        List<BlogsEntity> blogsList = service.getBlogEntities("ACTIVE", orderBy, pageNum, cateId);
        List<BlogsEntity> blogsList2 = service.getBlogEntities("ACTIVE", orderBy, pageNum, cateId);
        List<BlogEntitySEO> blogSEOS = new ArrayList<>();
        List<BlogEntitySEO> blogSEOS2 = new ArrayList<>();
        for (int i = 0; i < blogsList.size(); i++) {
            BlogEntitySEO entitySEO = new BlogEntitySEO();
            entitySEO.setId(blogsList.get(i).getId());
            entitySEO.setTitleSEO(service.covertToString(blogsList.get(i).getTitle()));
            entitySEO.setContent(blogsList.get(i).getContent());
            entitySEO.setAuthor(blogsList.get(i).getAuthor());
            entitySEO.setAvatar(blogsList.get(i).getAvatar());
            entitySEO.setDescription(blogsList.get(i).getDescription());
//            entitySEO.setTimePost(blogsList.get(i).getCreatedTime();
            entitySEO.setLikePost(blogsList.get(i).getLikePost());
            entitySEO.setViewPost(blogsList.get(i).getViewPost());
            entitySEO.setTitle(blogsList.get(i).getTitle());
            blogSEOS.add(entitySEO);
        }
        for (int i = 0; i < blogsList.size(); i++) {
            BlogEntitySEO entitySEO2 = new BlogEntitySEO();
            entitySEO2.setId(blogsList2.get(i).getId());
            entitySEO2.setAvatar(blogsList2.get(i).getAvatar());
            entitySEO2.setDescription(blogsList2.get(i).getDescription());
            entitySEO2.setTitleSEO(service.covertToString(blogsList2.get(i).getTitle()));
            entitySEO2.setTitle(blogsList2.get(i).getTitle());
            blogSEOS2.add(entitySEO2);
        }
        model.addAttribute("listBlog",blogSEOS);
        model.addAttribute("listBlog2",blogSEOS2);
        return "blogs";

    }

    @GetMapping(value = "/detail")
    public String getContent(Model model, @RequestParam(name = "ID") Integer ID,
                             @RequestParam(name = "title", required = false) String title) {
        logger.info("Get detail newID [{}]", ID);
        BlogsEntity blogsEntity = service.findBlogsByID(ID);
        model.addAttribute("blogsEntity", blogsEntity);
        model.addAttribute("titleSEO", title);
        return "blogs-detail";
    }





    @GetMapping(value = "/getBlogsByCate", name = "/getBlogsByCate")
    public List<BlogsEntity> getBlogsByCate(@RequestParam(name = "CategoryID") Integer categoryID,
                                            @RequestParam(name = "orderBy", defaultValue = "timePosting") String orderBy,
                                            @RequestParam(name = "pageNum", defaultValue = "0") Integer pageNum
    ) {
        return service.getBlogsByCate(categoryID, orderBy, pageNum);
    }

    @GetMapping(value = "/getBlogsByAuthor", name = "/getBlogsByAuthor")
    public List<BlogsEntity> getBlogsByAuthor(@RequestParam(name = "Author") String author
    ) {
        return service.findAllByAuthor(author);
    }

    @GetMapping(value = "/getBlogsByTitle", name ="/getBlogsByTitle")
    public List<BlogsEntity> getBlogsByTitle(@RequestParam(name = "Title") String title
    ) {
        return service.findAllByTitle(title);
    }


    @GetMapping(value = "/getBlogsDetail")
    public BlogsEntity getBlogsDetail(@RequestParam(name = "ID") Integer ID) {
        return service.findBlogsByID(ID);
    }


    @GetMapping(value = "/getCategory")
    public List<CateEntity> getCates() {
        return service.getCategory();
    }


}
