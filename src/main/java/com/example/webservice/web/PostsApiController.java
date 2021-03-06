package com.example.webservice.web;

import com.example.webservice.service.posts.PostsService;
import com.example.webservice.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    // 등록
    @PostMapping("/api/posts")
    public Long save(@RequestBody PostsSaveRequestsDto requestsDto) {
        return postsService.save(requestsDto);
    }

    // 모든 게시글 조회
    @GetMapping("/api/posts")
    public List<PostsListResponseDto> find() {
        return postsService.findAllDesc();
    }

    // 특정 게시글 조회
    @GetMapping("/api/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    // 수정
    @PutMapping("/api/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    // 삭제
    @DeleteMapping("/api/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

    // 게시글 검색
    @GetMapping("/api/search/{keyword}/{type}")
    public List<PostsListResponseDto> search(@PathVariable String keyword, @PathVariable String type) {
        return postsService.search(keyword, type);
    }
}
