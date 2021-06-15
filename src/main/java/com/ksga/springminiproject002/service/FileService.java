package com.ksga.springminiproject002.service;

import com.ksga.springminiproject002.model.FileUpload;

public interface FileService {
    public void save(FileUpload file);
    public FileUpload get(String name);
}
