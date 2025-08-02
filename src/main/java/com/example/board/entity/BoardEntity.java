package com.example.board.entity;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String writer;
    private String content;

    @Column(columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime createdDate = LocalDateTime.now();
}
