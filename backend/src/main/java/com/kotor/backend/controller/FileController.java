package com.kotor.backend.controller;

import com.kotor.backend.dto.StudentDto;
import com.kotor.backend.facade.StudentFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileController {

    private final StudentFacade studentFacade;

    @PostMapping("/upload")
    public ResponseEntity<List<StudentDto>> handleFileUpload(@RequestParam("file") MultipartFile multipartFile, String sortingAlgorithm) throws IOException {
        log.info("File name - {}, sortingAlgorithm - {}", multipartFile.getName(), sortingAlgorithm);
        return ResponseEntity.ok(studentFacade.handleRequest(multipartFile, sortingAlgorithm));
    }
}
