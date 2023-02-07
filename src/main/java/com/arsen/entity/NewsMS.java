package com.arsen.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "NewsMS")
@Data
@NoArgsConstructor
public class NewsMS {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "brief")
    private String brief;

    @Column(name = "content")
    String content;

    public NewsMS(String title, String brief, String content) {
        this.title = title;
        this.brief = brief;
        this.content = content;
    }
}
