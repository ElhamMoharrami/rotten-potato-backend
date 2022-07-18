package com.rp.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@RestController
public class ImageController {

    @Value("${images.base.path}")
    private String basePath;

    @GetMapping(value = "/images", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<InputStreamResource> getImage(@RequestParam("name") String name) throws IOException {
        FileInputStream imgFile = new FileInputStream(basePath + File.separator + name);
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(new InputStreamResource(imgFile));
    }

    @PostMapping("/images")
    public ResponseEntity<String> uploadFile(@RequestParam("photo") MultipartFile file) throws IOException {
        String filename = storeFile(file);
        return new ResponseEntity<>(filename, HttpStatus.OK);
    }

    private String storeFile(MultipartFile file) throws IOException {
        String filename = UUID.randomUUID().toString().replaceAll("-", "") + ".jpg";
        Path targetLocation = Paths.get(basePath + File.separator + filename).toAbsolutePath().normalize();
        Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
        return filename;
    }
}
