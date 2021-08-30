package com.plusplus.newsweb.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewsEntitySEO {
    private Integer id;
    private String title;
    private String description;
    private String avatar;
    private String content;
    private String author;
    private String source;
    @JsonProperty("time_posting")
    private String timePost;
    private String titleSEO;
}
