package com.plusplus.newsweb.entity.repository;

import com.plusplus.newsweb.entity.JobModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface JobRepository extends JpaRepository<JobModel,Integer> {
    JobModel findByLinkJob(String link);
}
