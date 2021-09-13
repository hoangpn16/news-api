package com.plusplus.newsweb.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.sql.Timestamp;
@Getter
@Setter
public class BlogEntitySEO {
    private Integer id;
    private String title;
    private String description;
    private String avatar;
    private String content;
    private String status;
    private String author;
    private Integer viewPost;
    private Integer likePost;
    private String titleSEO;

}
