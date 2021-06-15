package com.ksga.springminiproject002.service.impl;

import com.ksga.springminiproject002.model.FileUpload;
import com.ksga.springminiproject002.repository.FileRepository;
import com.ksga.springminiproject002.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService {
    private final FileRepository fileRepository;

    @Autowired
    public FileServiceImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    public void save(FileUpload file) {
        fileRepository.save(file);
    }

    @Override
    public FileUpload get(String name) {
        return fileRepository.findByName(name);
    }
}
