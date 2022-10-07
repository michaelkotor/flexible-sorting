package com.kotor.backend.service.impl;

import com.kotor.backend.dto.StudentDto;
import com.kotor.backend.service.SortingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service("Bubble")
public class BubbleSortingServiceImpl implements SortingService {
    @Override
    public List<StudentDto> sortStudents(Set<StudentDto> toSort) {
        log.info("Pretending sorting using bubble sort...");
        return toSort.stream().sorted(Comparator.comparingDouble(StudentDto::getScore)).collect(Collectors.toList());
    }
}
