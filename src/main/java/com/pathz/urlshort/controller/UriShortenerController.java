package com.pathz.urlshort.controller;

import com.pathz.urlshort.service.ShortenerService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/short")
public class UriShortenerController {
    @Value("${domain_uri}")
    private String domainUri;
    private final ShortenerService shortenerService;

    @SneakyThrows
    @GetMapping("/{id}")
    public void getShortUri(@PathVariable String id, HttpServletResponse response) {
        String originalUrlById = shortenerService.findOriginalUrlById(id);
        response.sendRedirect(originalUrlById);
    }

    @PostMapping
    public ResponseEntity<?> shortUri(@RequestBody ShortUrlRequest request) {
        String shortUrlId = shortenerService.createShortenedUri(request.url(), request.title());
        URI location = URI.create(domainUri + "short/" + shortUrlId);
        return ResponseEntity.created(location).build();
    }

    private record ShortUrlRequest(String url, String title) {}
}
