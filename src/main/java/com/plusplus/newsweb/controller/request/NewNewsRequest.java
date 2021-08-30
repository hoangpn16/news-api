package com.plusplus.newsweb.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("time_posting")
    private String timePost;

    @Override
    public String toString() {
        return "NewNewsRequest{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", avatar='" + avatar + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", source='" + source + '\'' +
                ", timePost='" + timePost + '\'' +
                '}';
    }
}
