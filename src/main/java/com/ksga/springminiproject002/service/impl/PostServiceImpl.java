package com.ksga.springminiproject002.service.impl;

import com.ksga.springminiproject002.model.Post;
import com.ksga.springminiproject002.payload.dto.PostDto;
import com.ksga.springminiproject002.payload.mapper.PostMapper;
import com.ksga.springminiproject002.payload.request.PostRequest;
import com.ksga.springminiproject002.repository.PostRepository;
import com.ksga.springminiproject002.service.PostService;
import com.ksga.springminiproject002.utilities.Paging;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository repository;
    private PostMapper postMapper;
    ModelMapper mapper = new ModelMapper();
    @Autowired
    public PostServiceImpl(PostRepository repository,
                             PostMapper postMapper) {
        this.repository = repository;
        this.postMapper = postMapper;
    }

    @Override
    public List<PostDto> findAll(Paging paging) {
        paging.setTotalCount(repository.countAllRecord());
        List<PostDto> dtoList = new ArrayList<>();
        for(Post a: repository.findAll(paging)){
            PostDto dto = mapper.map(a,PostDto.class);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public PostDto insert(PostRequest post) {
        Post a = postMapper.mapRequestToModel(post);
        if(repository.insert(a)){
            PostDto dto = postMapper.mapToDto(repository.findLastArticle());
            return dto;
        }
        else
            return null;
    }
}
