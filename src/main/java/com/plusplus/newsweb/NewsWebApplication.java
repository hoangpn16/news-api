package com.plusplus.newsweb;

import com.plusplus.newsweb.entity.repository.NewsRepository;
import com.plusplus.newsweb.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLOutput;

@SpringBootApplication
public class NewsWebApplication {
	@Autowired
	NewsRepository repo;
	public static void main(String[] args) {
		SpringApplication.run(NewsWebApplication.class, args);
		System.out.println("Start News API Application");
		NewsService newsService = new NewsService();
//		newsService.setActiveNews(newsService.getNewsList());
	}

}
