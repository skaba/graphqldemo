package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.LinkMapper;
import com.example.demo.model.Link;
import com.example.demo.persistence.LinkEntity;
import com.example.demo.persistence.LinkRepository;

@Service
public class LinkService {

    @Autowired
    private LinkRepository linkRepository;

    @Autowired
    private LinkMapper linkMapper;

    public List<Link> getAllLinks() {
        return linkMapper.reverseMapList(linkRepository.findAll());
    }
    
    public Link createLink(String url, String description) {
        LinkEntity linkEntity = new LinkEntity(url, description);
        return linkMapper.reverseMap(linkRepository.save(linkEntity));
    }
}
