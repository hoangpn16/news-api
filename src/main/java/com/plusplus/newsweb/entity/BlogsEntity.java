package com.plusplus.newsweb.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

    @Entity
    @Table(name = "blogs")
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class BlogsEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Integer id;

        @Column(name = "title")
        private String title;

        @Column(name = "description")
        private String description;

        @Column(name = "avatar")
        private String avatar;

        @Column(name = "content")
        private String content;

        @Column(name = "created_time")
        private Timestamp createdTime;

        @Column(name = "updated_time")
        private Timestamp updatedTime;

        @Column(name = "status")
        private String status;

        @Column(name = "author")
        private String author;

        @Column(name = "category_id")
        private Integer categoryId;

        @Column(name = "view_post")
        private Integer viewPost;

        @Column(name = "like_post")
        private Integer likePost;

        @Column(name = "user_id")
        private Integer userId;

        @Column(name = "name_censor")
        private String nameCensor;
    }
