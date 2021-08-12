package com.plusplus.newsweb.controller;


import com.plusplus.newsweb.controller.request.NewBlogsRequest;
import com.plusplus.newsweb.controller.request.NewNewsRequest;
import com.plusplus.newsweb.entity.BlogsEntity;
import com.plusplus.newsweb.entity.CategoryEntity;
import com.plusplus.newsweb.entity.NewsEntity;
import com.plusplus.newsweb.entity.repository.BlogsRepository;
import com.plusplus.newsweb.service.BlogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.BlockingQueue;

@RestController
@RequestMapping(name = "/blogs")
public class BogsController {

    @Autowired
    BlogsService blogsService;

    @PostMapping(value = "/addBlogs")
    public BlogsEntity addBlogs(@RequestBody NewBlogsRequest newBlogsRequest) {
        return blogsService.addBlogsEntity(newBlogsRequest);

    }

    @GetMapping(value = "/getBlogs", name = "/getBlogs")
    public List<BlogsEntity> getAllBlogs() {
        return blogsService.findAllBlogs("ACTIVE");
    }

    @GetMapping(value = "/getBlogsByCate", name = "/getBlogsByCate")
    public List<BlogsEntity> getBlogsByCate(@RequestParam(name = "CategoryID") Integer categoryID
    ) {
        return blogsService.findAllByCategoryId(categoryID);
    }

    @GetMapping(value = "/getBlogsByAuthor", name = "/getBlogsByAuthor")
    public List<BlogsEntity> getBlogsByAuthor(@RequestParam(name = "Author") String author
    ) {
        return blogsService.findAllByAuthor(author);
    }

    @GetMapping(value = "/getBlogsByTitle", name ="/getBlogsByTitle")
    public List<BlogsEntity> getBlogsByTitle(@RequestParam(name = "Title") String title
    ) {
        return blogsService.findAllByTitle(title);
    }


    @GetMapping(value = "/getCategory")
    public List<CategoryEntity> getCategory() {
        return blogsService.findAll();
    }

    @GetMapping(value = "/getBlogsDetail")
    public BlogsEntity getBlogsDetail(@RequestParam(name = "ID") Integer ID) {
        return blogsService.findBlogsByID(ID);
    }



}
