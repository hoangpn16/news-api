package com.plusplus.newsweb.controller;

import com.plusplus.newsweb.entity.NewsEntity;
import com.plusplus.newsweb.service.NewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/news")
public class NewsController {
//    public static Integer pageNum=0;
    private static final Logger logger = LoggerFactory.getLogger(NewsRestController.class);
    @Autowired
    NewsService service;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String getNews(Model model, @RequestParam(name = "orderBy", defaultValue = "timeOrderBy") String orderBy,
                          @RequestParam(name = "pageNum", defaultValue = "0") Integer pageNum) {
        logger.info("Get list news with page [{}], orderBy [{}]", pageNum, orderBy);
        List<NewsEntity> listNews = service.getNewsEntities("active", orderBy, pageNum);
        logger.info("Found [{}]", listNews.size());
        model.addAttribute("listNews", listNews);
        model.addAttribute("pageNum", pageNum);
        return "news";
    }

    @GetMapping(value = "/detail")
    public String getContent(Model model ,@RequestParam(name = "ID") Integer ID) {
        logger.info("Get detail newID [{}]", ID);
        NewsEntity newsEntity = service.getContentById(ID);
        model.addAttribute("newsEntity", newsEntity);
        return "news-detail";
    }


}
