package com.plusplus.newsweb.entity.repository;

import com.plusplus.newsweb.entity.BlogsEntity;
import com.plusplus.newsweb.entity.NewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BlogsRepository extends JpaRepository<BlogsEntity, Integer > {

    List<BlogsEntity> findAllByTitle(String title);
//    BlogsEntity findByTitle(String title);
    List<BlogsEntity> findALLByStatus(String status);
    BlogsEntity findAllById(Integer id);
    List<BlogsEntity> findAllByCategoryId(Integer CategoryId);
    List<BlogsEntity> findAllByAuthor(String author);

}
