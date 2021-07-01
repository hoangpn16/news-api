package com.plusplus.newsweb.controller;

import com.plusplus.newsweb.controller.request.NewNewsRequest;
import com.plusplus.newsweb.entity.NewsEntity;
import com.plusplus.newsweb.service.NewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/news")
public class NewsController {
    private static final Logger logger = LoggerFactory.getLogger(NewsController.class);
    @Autowired
    NewsService service;

    @PostMapping(name = "/add")
    public List<NewsEntity> addNews(@RequestBody List<NewNewsRequest> listNews){
        return service.addNewsEntity(listNews);
    }

    @GetMapping(name = "/getdata")
    public List<NewsEntity> getNews(@RequestParam(name = "orderBy", defaultValue = "timePosting") String orderBy,
                                    @RequestParam(name = "pageNum", defaultValue = "0") Integer pageNum){
        return service.getNewsEntities("active",orderBy, pageNum);
    }


}
