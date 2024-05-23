package com.jaewon.security.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int cost; // 평점
    private String content;
    private Date createdAt;

    // 이 리뷰를 누가 작성 했는가? (Customer)
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false) // FK
    private Customer customer; // Object는 컬럼으로 만들어지지 않는다.(FK)

    // 어떤 책에 리뷰가 작성이 되었는가?
    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;
}
