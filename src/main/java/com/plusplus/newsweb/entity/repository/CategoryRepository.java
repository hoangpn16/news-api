package com.plusplus.newsweb.entity.repository;

import com.plusplus.newsweb.entity.BlogsEntity;
import com.plusplus.newsweb.entity.CategoryEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {

    List<CategoryEntity> findAll();
}
