package com.kotor.backend.service;

import com.kotor.backend.dto.StudentDto;

import java.util.List;
import java.util.Set;

public interface SortingService {
    List<StudentDto> sortStudents(Set<StudentDto> toSort);
}
