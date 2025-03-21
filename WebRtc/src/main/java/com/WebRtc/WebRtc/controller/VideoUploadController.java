package com.WebRtc.WebRtc.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.*;

@RestController
public class VideoUploadController {

    private static final String VIDEO_DIRECTORY = "C:/uploaded_videos/"; // Change path if needed

    @PostMapping("/upload")
    public String uploadVideo(@RequestParam("videoFile") MultipartFile file) {
        if (file.isEmpty()) {
            return "File is empty";
        }

        try {
            Files.createDirectories(Paths.get(VIDEO_DIRECTORY));
            Path filePath = Paths.get(VIDEO_DIRECTORY + file.getOriginalFilename());
            Files.write(filePath, file.getBytes());

            return "File uploaded successfully: " + filePath.toString();
        } catch (IOException e) {
            return "Failed to upload file: " + e.getMessage();
        }
    }
}


