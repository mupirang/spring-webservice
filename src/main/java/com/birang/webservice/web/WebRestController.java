package com.birang.webservice.web;

import com.birang.webservice.domain.ports.PostsRepository;
import com.birang.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsRepository postsRepository;
    private PostsService postsService;
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
}