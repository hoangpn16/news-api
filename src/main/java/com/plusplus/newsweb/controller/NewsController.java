package com.plusplus.newsweb.controller;

import com.plusplus.newsweb.entity.NewsEntity;
import com.plusplus.newsweb.entity.NewsEntitySEO;
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

import java.util.ArrayList;
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
        List<NewsEntity> listNews2 = service.getNewsEntities("active", orderBy, 2);
        logger.info("Found [{}]", listNews.size());
//        model.addAttribute("listNews1", listNews);
        model.addAttribute("pageNum", pageNum);
        List<NewsEntitySEO> newsEntitySEOS = new ArrayList<>();
        List<NewsEntitySEO> newsEntitySEOS2 = new ArrayList<>();
        for (int i = 0; i < listNews.size(); i++) {
            NewsEntitySEO entitySEO = new NewsEntitySEO();
            entitySEO.setId(listNews.get(i).getId());
            entitySEO.setTitleSEO(service.covertToString(listNews.get(i).getTitle()));
            entitySEO.setContent(listNews.get(i).getContent());
            entitySEO.setAuthor(listNews.get(i).getAuthor());
            entitySEO.setAvatar(listNews.get(i).getAvatar());
            entitySEO.setDescription(listNews.get(i).getDescription());
            entitySEO.setTimePost(listNews.get(i).getTimePosting());
            entitySEO.setTitle(listNews.get(i).getTitle());
            newsEntitySEOS.add(entitySEO);
        }
        for (int i = 0; i < listNews2.size(); i++) {
            NewsEntitySEO entitySEO1 = new NewsEntitySEO();
            entitySEO1.setId(listNews2.get(i).getId());
            entitySEO1.setTitleSEO(service.covertToString(listNews2.get(i).getTitle()));
            entitySEO1.setTitle(listNews2.get(i).getTitle());
            newsEntitySEOS2.add(entitySEO1);
        }
        model.addAttribute("listNews", newsEntitySEOS);
        model.addAttribute("listNews2", newsEntitySEOS2);
        return "news";
    }

    @GetMapping(value = "/detail")
    public String getContent(Model model, @RequestParam(name = "ID") Integer ID,
                             @RequestParam(name = "title", required = false) String title) {
        logger.info("Get detail newID [{}]", ID);
        NewsEntity newsEntity = service.getContentById(ID);
        model.addAttribute("newsEntity", newsEntity);
        model.addAttribute("titleSEO", title);
        return "news-detail";
    }


}
