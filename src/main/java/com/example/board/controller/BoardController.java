package com.example.board.controller;

import com.example.board.dto.BoardDto;
import com.example.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    // 글 작성
    @PostMapping
    public ResponseEntity<BoardDto> createPost(@RequestBody BoardDto dto) {
        return ResponseEntity.ok(boardService.createPost(dto));
    }

    // 전체 글 목록 조회
    @GetMapping
    public ResponseEntity<List<BoardDto>> getAllPosts() {
        return ResponseEntity.ok(boardService.getAllPosts());
    }

    // 특정 글 상세 조회
    @GetMapping("/{postId}")
    public ResponseEntity<BoardDto> getPost(@PathVariable Long postId) {
        return ResponseEntity.ok(boardService.getPost(postId));
    }

    // 글 수정
    @PatchMapping("/{postId}")
    public ResponseEntity<BoardDto> updatePost(@PathVariable Long postId, @RequestBody BoardDto dto) {
        return ResponseEntity.ok(boardService.updatePost(postId, dto));
    }

    // 글 삭제
    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
        boardService.deletePost(postId);
        return ResponseEntity.noContent().build();
    }
}

