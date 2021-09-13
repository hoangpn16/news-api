package com.plusplus.newsweb.service;


import com.plusplus.newsweb.controller.request.NewBlogsRequest;
import com.plusplus.newsweb.entity.BlogsEntity;
import com.plusplus.newsweb.entity.CateEntity;
import com.plusplus.newsweb.entity.NewsEntity;
import com.plusplus.newsweb.entity.repository.BlogsRepository;
import com.plusplus.newsweb.entity.repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.Normalizer;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class BlogsService {
    private static final Logger logger = LoggerFactory.getLogger(NewsService.class);
    @Autowired
    BlogsRepository blogsRepository;
    @Autowired
    CategoryRepository categoryRepository;

    public List<BlogsEntity> findAllBlogs() {
        List data = blogsRepository.findALLByStatus("ACTIVE");
        return data;
    }

    public BlogsEntity findBlogsByID(Integer id) {
        BlogsEntity data = blogsRepository.findAllById(id);
//        String date = data.getTimePosting().toString();
        return data;
    }

    public List<BlogsEntity> findAllByCategoryId(Integer categoryId) {
        List<BlogsEntity> data = blogsRepository.findAllByCategoryId(categoryId);
        return data;
    }

    public List<BlogsEntity> findAllByAuthor(String author) {
        List<BlogsEntity> data = blogsRepository.findAllByAuthor(author);
        return data;
    }

    public List<BlogsEntity> findAllByTitle(String title) {
        List<BlogsEntity> data = (List<BlogsEntity>) blogsRepository.findAllByTitle(title);
        return data;
    }


    public List<BlogsEntity> getBlogEntities(String status, String orderBy, Integer pageNum, Integer cate){
        Sort sort = Sort.by(Sort.Direction.DESC, orderBy);
        PageRequest pageRequest = PageRequest.of(pageNum, 9, sort);
        if (cate != null){
            List<BlogsEntity> data = blogsRepository.findAllByStatusAndCategoryId(status,pageRequest, cate);
            return data;
        }
        else {
            List<BlogsEntity> data = blogsRepository.findAllByStatus(status,pageRequest);
            return data;
        }

    }

    public List<BlogsEntity> getBlogsByCate(Integer cateId, String orderBy, Integer pageNum){
        Sort sort = Sort.by(Sort.Direction.DESC, orderBy);
        PageRequest pageRequest = PageRequest.of(pageNum, 9, sort);
        List<BlogsEntity> data = blogsRepository.findAllByCategoryId(cateId, pageRequest);
        return data;
    }

    public List<CateEntity> getCategory(){
       return categoryRepository.findALLByStatus("ACTIVE");
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
