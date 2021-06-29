package com.plusplus.newsweb.service;

import com.plusplus.newsweb.entity.NewsEntity;
import com.plusplus.newsweb.entity.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsService {
    @Autowired
    NewsRepository repo;

    public List<NewsEntity> addNewsEntity(List<NewsEntity> listNews) {
        List<NewsEntity> data = new ArrayList<>();
        for (NewsEntity entity : listNews) {
            NewsEntity newsEntity = repo.findByTitle(entity.getTitle());
            if(newsEntity == null){
                newsEntity = new NewsEntity(entity.getTitle(),
                        entity.getDescription(),
                        entity.getAvatar(),
                        entity.getContent(),
                        entity.getAuthor(),
                        entity.getSource(),
                        entity.getTimePosting());
                data.add(newsEntity);
            }

        }
        return repo.saveAll(data);
    }


}
