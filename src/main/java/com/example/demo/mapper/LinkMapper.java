package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.model.Link;
import com.example.demo.persistence.LinkEntity;

@Component
public class LinkMapper extends DozerMapper<Link, LinkEntity> {

}
