package com.plusplus.newsweb.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "img_blogs")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Img_BlogsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "imgs")
    private String imgs;

    @Column(name = "blogs_id")
    private String blogId;


}
