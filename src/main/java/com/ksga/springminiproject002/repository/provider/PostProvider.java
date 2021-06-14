package com.ksga.springminiproject002.repository.provider;

import com.ksga.springminiproject002.model.Post;
import com.ksga.springminiproject002.utilities.Paging;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class PostProvider {
    public String findAll(@Param("paging") Paging paging){

        return new SQL(){{
            SELECT("*");
            FROM("posts");
//            INNER_JOIN("categories on articles.category_id = categories.id");
//            ORDER_BY("articles.id desc  limit #{paging.limit} offset #{paging.offset}");
        }}.toString();
    }

    public String insert(Post post){
        return new SQL(){{
            INSERT_INTO("posts");
            VALUES("id,caption,image,number_of_like","#{post.id},#{post.caption},#{post.image},#{post.like}");

        }}.toString();
    }

    public String countAll(){
        return new SQL(){{
            SELECT("count(id)");
            FROM("posts");
        }}.toString();
    }
}
