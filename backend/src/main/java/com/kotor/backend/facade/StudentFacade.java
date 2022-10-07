package com.kotor.backend.facade;

import com.kotor.backend.dto.StudentDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

public interface StudentFacade {
    List<StudentDto> handleRequest(MultipartFile multipartFile, String sortingAlgorithm);

    List<String> getStudentSortingTypes();
}
