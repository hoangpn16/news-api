package com.plusplus.newsweb.service;

import com.plusplus.newsweb.controller.request.NewNewsRequest;
import com.plusplus.newsweb.entity.NewsEntity;
import com.plusplus.newsweb.entity.NewsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
                if (entity.getTime_posting() != null) {
                    newsEntity.setTimePosting(entity.getTime_posting());
                }

                data.add(newsEntity);
            }

        }
        return repo.saveAll(data);
    }


}
