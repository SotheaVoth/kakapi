package com.ksga.springminiproject002.controller.Rest;

import com.ksga.springminiproject002.model.FileUpload;
import com.ksga.springminiproject002.service.impl.FileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@RestController
@RequestMapping("/api/v1/file")
public class FileRestController {
    private final FileServiceImpl filesService;
    @Autowired
    public FileRestController(FileServiceImpl filesService) {
        this.filesService = filesService;
    }

    @PostMapping(value = "/addFile",consumes = "multipart/form-data")
    public String addFile(@RequestPart MultipartFile file){
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Path path = Paths.get("src/main/resources/files/"+fileName);
        while (true){
            try {
                Files.copy(file.getInputStream(),path, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException n){
                if (new File("src/main/resources/files/").mkdirs()){
                    continue;
                }
            }
            break;
        }
        filesService.save(new FileUpload(fileName));
        return "/file/"+fileName;
    }
    @GetMapping("/getFile")
    public ResponseEntity<FileUpload> getFile(@RequestParam("name") String name){
        FileUpload file = filesService.get(name);
        return new ResponseEntity<>(file, HttpStatus.OK);
    }

}
