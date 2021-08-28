package com.plusplus.newsweb.controller.request;


import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;


@Getter
@Setter
public class NewBlogsRequest {
    private String title;
    private String description;
    private String avatar;
    private String content;
    private String author;
    private Integer categoryId;
//    private Integer like;
//    private Integer view;
//    private Timestamp time_posting;
//    private String status;
}
