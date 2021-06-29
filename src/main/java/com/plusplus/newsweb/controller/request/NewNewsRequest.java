package com.plusplus.newsweb.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewNewsRequest {
    private String title;
    private String description;
    private String avatar;
    private String content;
    private String author;
    private String source;
    private String time_posting;
}
