package com.pathz.urlshort.service;

import com.pathz.urlshort.entity.ShortenedUrl;
import com.pathz.urlshort.exception.UriNotFoundException;
import com.pathz.urlshort.repo.ShortenerRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShortenerService {
    @Value("${shorten_uri_size}")
    private Integer shorterUriSize;
    private final ShortenerRepository shortenerRepository;

    public String createShortenedUri(String uri, String title) {
        String shortUrl = generateShortURI();
        ShortenedUrl shortenedUrl = new ShortenedUrl();
        shortenedUrl.setOriginalUrl(uri);
        shortenedUrl.setTitle(title);
        shortenedUrl.setId(shortUrl);
        return shortenerRepository.save(shortenedUrl).getId();
    }

    @Cacheable("shortened_urls")
    public String findOriginalUrlById(String urlId) {
        return shortenerRepository.findById(urlId)
                .map(ShortenedUrl::getOriginalUrl)
                .orElseThrow(() -> new UriNotFoundException(urlId));
    }

    private String generateShortURI() {
        return RandomStringUtils.randomAlphabetic(shorterUriSize);
    }
}
