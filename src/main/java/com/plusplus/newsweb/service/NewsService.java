package com.plusplus.newsweb.service;

import com.plusplus.newsweb.controller.request.NewNewsRequest;
import com.plusplus.newsweb.entity.NewsEntity;
import com.plusplus.newsweb.entity.repository.NewsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

@Service
public class NewsService {
    private static final Logger logger = LoggerFactory.getLogger(NewsService.class);
    @Autowired
    NewsRepository repo;



    public List<NewsEntity> addNewsEntity(List<NewNewsRequest> listNews) {
        List<NewsEntity> data = new ArrayList<>();
        for (NewNewsRequest entity : listNews) {
            NewsEntity newsEntity = repo.findByTitle(entity.getTitle());
            if (newsEntity == null) {
                newsEntity = new NewsEntity();
                if (entity.getTitle() != null) {
                    newsEntity.setTitle(entity.getTitle());
                }
                if (entity.getAvatar() != null) {
                    newsEntity.setAvatar(entity.getAvatar());
                }
                if (entity.getDescription() != null) {
                    newsEntity.setDescription(entity.getDescription());
                }
                if (entity.getContent() != null) {
                    newsEntity.setContent(entity.getContent());
                }
                if (entity.getAuthor() != null) {
                    newsEntity.setAuthor(entity.getAuthor());
                }
                if (entity.getSource() != null) {
                    newsEntity.setSource(entity.getSource());
                }
                if (entity.getTimePost() != null) {
                    newsEntity.setTimePosting(entity.getTimePost());
                    try {
                        String str[] = newsEntity.getTimePosting().split(" ");
                        String str1[] = str[0].split("/");
                        int day = Integer.parseInt(str1[0]);
                        int month = Integer.parseInt(str1[1]);
                        int year = Integer.parseInt(str1[2]);
                        int time_order = year * 10000 + month * 100 + day;
                        newsEntity.setTimeOrderBy(time_order);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
                newsEntity.setStatus("active");
                data.add(newsEntity);
            }

        }

        return repo.saveAll(data);
    }


    public List<NewsEntity> getNewsEntities(String status, String orderBy, Integer pageNum) {
        Sort sort = Sort.by(Sort.Direction.DESC, orderBy);
        PageRequest pageRequest = PageRequest.of(pageNum, 6, sort);
        List<NewsEntity> data = repo.findAllByStatus(status, pageRequest);
//        setActiveNews(getNewsList());
        return data;
    }

    public NewsEntity getContentById(Integer id) {
        NewsEntity content = repo.findAllById(id);
//        content.setStatus("ACTádasdasdasdIVE");
        return content;
    }

    public static String covertToString(String URLValue) {
        try {
            String temp = Normalizer.normalize(URLValue, Normalizer.Form.NFD);
            Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
            return pattern.matcher(temp).replaceAll("").toLowerCase().replaceAll(" ", "-").replaceAll("đ", "d");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return URLValue;
    }

}