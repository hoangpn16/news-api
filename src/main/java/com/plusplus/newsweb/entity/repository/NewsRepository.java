package com.plusplus.newsweb.entity.repository;

import com.plusplus.newsweb.entity.NewsEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<NewsEntity, Integer> {
    NewsEntity findByTitle(String title);
    List<NewsEntity> findAllByStatus(String Status, Pageable pageable);
    List<NewsEntity> findAllByStatus(String Status);
    NewsEntity findAllById(Integer id);
}
