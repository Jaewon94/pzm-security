package com.jaewon.security.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private int page;
    private int price;


    // 책 정보를 가져올때 리뷰정보(여러개)까지 함께 가져오기
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Review> reviews;


    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<BookImage> bookImages;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Cart> carts;

}
