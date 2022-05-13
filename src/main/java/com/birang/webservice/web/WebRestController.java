package com.birang.webservice.web;

import com.birang.webservice.domain.ports.PostsRepository;
import com.birang.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Arrays;

@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsRepository postsRepository;
    private PostsService postsService;
    private Environment env;
    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }

    /*@PostMapping("/posts")
    public void savePosts(@RequestBody PostsSaveRequestDto dto) {
        postsRepository.save(dto.toEntity());
    }*/

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto) {
        return postsService.save(dto);
    }

    @GetMapping("/profile")
    public String getProfile () {
        return Arrays.stream(env.getActiveProfiles())
                .findFirst()
                .orElse("");
    }
}