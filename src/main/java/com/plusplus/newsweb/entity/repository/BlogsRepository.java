package com.plusplus.newsweb.entity.repository;

import com.plusplus.newsweb.entity.BlogsEntity;
import com.plusplus.newsweb.entity.NewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogsRepository extends JpaRepository<BlogsEntity, Integer > {

    BlogsEntity findByTitle(String title);
    BlogsEntity findByStatus(String status);
}
