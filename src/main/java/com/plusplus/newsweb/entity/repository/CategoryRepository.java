package com.plusplus.newsweb.entity.repository;

import com.plusplus.newsweb.entity.CateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoryRepository extends JpaRepository<CateEntity, Integer> {
    List<CateEntity> findALLByStatus(String Status);
}
