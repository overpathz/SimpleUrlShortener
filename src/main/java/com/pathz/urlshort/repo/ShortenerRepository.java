package com.pathz.urlshort.repo;

import com.pathz.urlshort.entity.ShortenedUrl;
import org.springframework.data.repository.CrudRepository;

public interface ShortenerRepository extends CrudRepository<ShortenedUrl, String> {
}
