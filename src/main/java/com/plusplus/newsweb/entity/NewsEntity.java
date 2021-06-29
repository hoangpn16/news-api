package com.plusplus.newsweb.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "news")
@Getter @Setter
@AllArgsConstructor
public class NewsEntity {
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

    @Column(name = "author")
    private String author;

    @Column(name = "source")
    private String source;

    @Column(name = "time_posting")
    private String time_posting;

    public NewsEntity(String title, String description, String avatar, String content, String author, String source, String timePosting) {
        this.title = title;
        this.description = description;
        this.avatar = avatar;
        this.content = content;
        this.author = author;
        this.source = source;
        this.time_posting = timePosting;
    }
}
