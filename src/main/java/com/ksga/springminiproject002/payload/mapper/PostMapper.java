package com.ksga.springminiproject002.payload.mapper;

import com.ksga.springminiproject002.model.Post;
import com.ksga.springminiproject002.payload.dto.PostDto;
import com.ksga.springminiproject002.payload.request.PostRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostMapper {
    @Mapping(source = "imageUrl", target = "image")
    PostDto postToPostDto(Post post);

    @Mapping(source = "image", target = "imageUrl")
    Post postDtoToPost(PostDto postDto);

    //  @Mapping(target = "category",expression = "java(article.getCategory())")
    PostDto mapToDto(Post post);


    //  @Mapping(source = "categoryId",target = "category.id")
    Post mapRequestToModel(PostRequest request);
}
