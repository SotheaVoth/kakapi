package com.ksga.springminiproject002.service;

import com.ksga.springminiproject002.payload.dto.PostDto;
import com.ksga.springminiproject002.payload.request.PostRequest;
import com.ksga.springminiproject002.utilities.Paging;

import java.util.List;
import java.util.Map;

public interface PostService {
    public List<PostDto> findAll(Paging paging);
    public PostDto insert(PostRequest post);
}
