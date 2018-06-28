package com.example.demo;

import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.coxautodev.graphql.tools.SchemaParser;
import com.example.demo.graphql.Mutation;
import com.example.demo.graphql.Query;

import graphql.schema.GraphQLSchema;

@SpringBootApplication
@EnableJpaRepositories
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    
    @Bean
    public GraphQLSchema schema(Query  query, Mutation mutation) {
        return SchemaParser.newParser()
                .file("demo.graphqls")
                .resolvers(query,mutation)
                .build()
                .makeExecutableSchema();
    }
    
    @Bean
    public DozerBeanMapperFactoryBean dozer() {
        return new DozerBeanMapperFactoryBean();
    }
}
