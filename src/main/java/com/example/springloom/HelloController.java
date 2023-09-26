package com.example.springloom;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final AuthorRepository authorRepository;

    @GetMapping("/hello")
    public String hello() {
        return Thread.currentThread().toString();
    }

    @GetMapping("/sleep")
    public String testSleep(@RequestParam Long sleepTime) throws InterruptedException {
        Thread.sleep(sleepTime);
        return Thread.currentThread().toString();
    }

    @GetMapping("/db")
    public String db() {
        List<Author> authors = authorRepository.findAll();
        return "Author count: " + authors.size();
    }
}
