package com.plusplus.newsweb.controller.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewBlogsRequest {
    private String title;
    private String description;
    private String avatar;
    private String content;
    private String author;
}
