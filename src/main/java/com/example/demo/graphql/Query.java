package com.example.demo.graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.demo.model.Link;
import com.example.demo.service.LinkService;

@Component
public class Query implements GraphQLQueryResolver {
    
    @Autowired
    private LinkService linkService;

    public List<Link> allLinks() {
        return linkService.getAllLinks();
    }
}