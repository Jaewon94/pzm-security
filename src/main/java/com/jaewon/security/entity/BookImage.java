package com.jaewon.security.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int type;   // 1, 2, 3
    private String path; // 파일 경로(이름)

    // 어떤 책에 속한 이미지인가?
    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book; // 오브젝트는 컬럼을 만들 수 없다(FK)
}
