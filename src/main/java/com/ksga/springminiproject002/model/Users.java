package com.ksga.springminiproject002.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    private String fullname;
    private String password;
    private String[] roles;
    private String username;
}
