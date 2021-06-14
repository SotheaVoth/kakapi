package com.ksga.springminiproject002.repository;

import com.ksga.springminiproject002.model.Post;
import com.ksga.springminiproject002.repository.provider.PostProvider;
import com.ksga.springminiproject002.utilities.Paging;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository {
    @SelectProvider(type = PostProvider.class,method = "findAll")
    @Results(id = "postMapping",
            value = {
                    @Result(column = "image",property = "imageUrl"),
                    @Result(column = "number_of_like",property = "likes")
            })
    public List<Post> findAll(@Param("paging") Paging paging);

    @SelectProvider(type = PostProvider.class,method = "countAll")
    public int countAllRecord();
    @ResultMap("articleMapping")
    public Post findLastArticle();
    @InsertProvider(type = PostProvider.class,method = "insert")
    @ResultMap("articleMapping")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    public boolean insert(@Param("article") Post post);
}
