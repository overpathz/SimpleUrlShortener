package com.pathz.urlshort.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;

@Data
@RedisHash("shortened_urls")
public class ShortenedUrl {
    @Id
    private String id;
    private String originalUrl;
    private String title;
    private LocalDateTime createdAt = LocalDateTime.now();
}
