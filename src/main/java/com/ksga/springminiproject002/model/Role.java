package com.ksga.springminiproject002.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    private Long id;
    private ERole name;
}
