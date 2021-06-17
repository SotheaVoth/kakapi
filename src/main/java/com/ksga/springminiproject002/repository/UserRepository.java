package com.ksga.springminiproject002.repository;

import com.ksga.springminiproject002.model.Role;
import com.ksga.springminiproject002.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository {
    @Select("SELECT users.id as id,fullname,username,password From users WHERE username = #{name}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "fullName", column = "fullname"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "roles", column = "id", many = @Many(select = "findAllRolesByUserId"))
    })
    Optional<User> findUserByUsername(@Param("name") String username);

    @Select("SELECT * FROM users u INNER JOIN roles r ON u.role_id = r.id WHERE u.id = #{userId}")
    Set<Role> findAllRolesByUserId(Long userId);

}
