package com.plusplus.newsweb.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "news")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
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
    private Timestamp timePosting;

    @Column(name = "status")
    private String status;

}
