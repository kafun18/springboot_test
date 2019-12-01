package com.example.demo.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Spring属性注入
 */
@Component
/*为了加载book.properties文件，本身springboot不会自动加载
自己创建的文件，除了application.properties*/
@PropertySource("classpath:book.properties")
/*使用类型安全的注入可以让book.properties文件里面的book前缀内容注入，
从而不需要给每个字段加@Value*/
@ConfigurationProperties(prefix = "book")
public class Book {

//    @Value("${book.id}")
    private Long id;

//    @Value("${book.name}")
    private String name;

//    @Value("${book.author}")
    private String author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
