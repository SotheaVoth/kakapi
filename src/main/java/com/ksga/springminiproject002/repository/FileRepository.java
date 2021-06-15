package com.ksga.springminiproject002.repository;

import com.ksga.springminiproject002.model.FileUpload;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository {

    @Insert("INSERT INTO files(name,created_at) VALUES (#{name},#{createAt})")
    public void save(FileUpload file);

    @Select("SELECT * FROM files WHERE name = #{name}")
    @Results(id = "fileSelectMapping",
            value = {
                    @Result(column = "id",property = "id"),
                    @Result(column = "name",property = "name"),
                    @Result(column = "created_at",property = "createAt")
            })
    public FileUpload findByName(@Param("name") String name);
}
