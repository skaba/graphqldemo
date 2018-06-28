package com.example.demo.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name="LINK")
public class LinkEntity {
    @Id
    @GeneratedValue
    private Integer id;
    
    @Column(name="URL")
    private String url;
    
    @Column(name="DESC")
    private String description;

    public LinkEntity(String url, String description) {
        this.url = url;
        this.description = description;
    }
    
    
}
