package com.example.demo.graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.demo.model.Link;
import com.example.demo.service.LinkService;


@Component
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private LinkService linkService;

    public Link createLink(String url, String description) {
        return linkService.createLink(url, description);
    }
}