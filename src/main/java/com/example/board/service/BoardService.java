package com.example.board.service;

import com.example.board.dto.BoardDto;
import com.example.board.entity.BoardEntity;
import com.example.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardDto createPost(BoardDto dto) {
        BoardEntity saved = boardRepository.save(dto.toEntity());
        return BoardDto.fromEntity(saved);
    }

    public List<BoardDto> getAllPosts() {
        return boardRepository.findAll().stream()
                .map(BoardDto::fromEntity)
                .collect(Collectors.toList());
    }

    public BoardDto getPost(Long id) {
        BoardEntity entity = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Post not found: " + id));
        return BoardDto.fromEntity(entity);
    }

    public BoardDto updatePost(Long id, BoardDto dto) {
        BoardEntity entity = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Post not found: " + id));

        entity.setTitle(dto.getTitle());
        entity.setWriter(dto.getWriter());
        entity.setContent(dto.getContent());

        BoardEntity updated = boardRepository.save(entity);
        return BoardDto.fromEntity(updated);
    }

    public void deletePost(Long id) {
        boardRepository.deleteById(id);
    }
}
