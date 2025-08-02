package com.example.board.controller;

import com.example.board.dto.BoardDto;
import com.example.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class ViewController {

    private final BoardService boardService;

    @GetMapping("/")
    public String redirectToList() {
        return "redirect:/posts";
    }

    // 게시글 목록 보기
    @GetMapping("/posts")
    public String listView(Model model) {
        model.addAttribute("posts", boardService.getAllPosts());
        return "list";
    }

    // 글 작성 폼
    @GetMapping("/board/new")
    public String createForm(Model model) {
        model.addAttribute("post", new BoardDto());  // id=null
        return "form";
    }

    // 글 상세 보기
    @GetMapping("/board/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("post", boardService.getPost(id));
        return "detail";
    }

    // 글 수정 폼
    @GetMapping("/board/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("post", boardService.getPost(id));
        return "form";
    }
}
