package com.ksga.springminiproject002.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class FileUpload {
    private int id;
    private String name;
    private Date createAt;

    public String getFilePath(){
        return "/file/"+name;
    }

    public FileUpload(String name) {
        this.id = 1;
        this.name = name;
        this.createAt =  new Date();
    }
}
