package com.example.demo.mapper;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import net.jodah.typetools.TypeResolver;

public abstract class DozerMapper<Source, Target> {
    
    @Autowired
    private Mapper mapper;
    
    protected Class<Source> sourceClass =(Class<Source>) TypeResolver.resolveRawArguments(DozerMapper.class, getClass())[0];
    
    protected Class<Target> targetClass =(Class<Target>) TypeResolver.resolveRawArguments(DozerMapper.class, getClass())[1];
    
    public Target map(Source source) {
        return mapper.map(source, targetClass);
    }
    
    public Source reverseMap(Target target) {
        return mapper.map(target, sourceClass);
    }
    
    public List<Target> mapList(List<Source> sources) {
        return sources.stream().map(this::map).collect(toList());
    }
    
    public List<Source> reverseMapList(List<Target> targets) {
        return targets.stream().map(this::reverseMap).collect(toList());
    }
}
