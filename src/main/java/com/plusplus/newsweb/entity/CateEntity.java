package com.plusplus.newsweb.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Table( name = "category")
@Getter
@Setter
public class CateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "categoryName")
    private String categoryName;

    @Column(name = "status")
    private String status;

}
