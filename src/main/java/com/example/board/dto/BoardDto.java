package com.example.board.dto;

import com.example.board.entity.BoardEntity;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDto {
    private Long id;
    private String title;
    private String writer;
    private String content;
    private LocalDateTime createdDate;

    public static BoardDto fromEntity(BoardEntity entity) {
        return BoardDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .writer(entity.getWriter())
                .content(entity.getContent())
                .createdDate(entity.getCreatedDate())
                .build();
    }

    public BoardEntity toEntity() {
        return BoardEntity.builder()
                .id(this.id)
                .title(this.title)
                .writer(this.writer)
                .content(this.content)
                .build();
    }
}
