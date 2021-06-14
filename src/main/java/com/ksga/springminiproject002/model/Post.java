package com.ksga.springminiproject002.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private String id;
    private String caption;
    private String imageUrl;
    private int likes;
    private boolean owner;
    private String userId;
}
