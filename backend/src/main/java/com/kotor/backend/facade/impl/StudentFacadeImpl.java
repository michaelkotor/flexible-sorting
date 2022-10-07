package com.kotor.backend.facade.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.kotor.backend.dto.StudentDto;
import com.kotor.backend.facade.StudentFacade;
import com.kotor.backend.service.SortingService;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.enums.CSVReaderNullFieldIndicator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentFacadeImpl implements StudentFacade {

    private final Map<String, SortingService> sortingServices;

    @Override
    public List<StudentDto> handleRequest(MultipartFile multipartFile, String sortingAlgorithm) {
        log.info("There are {} sorting services", sortingServices.values().size());
        log.info("There are {} sorting services", sortingServices.keySet().stream().reduce("", (a, b) -> a + " " + b));
        Set<StudentDto> studentDtos = convertFile(multipartFile);

        SortingService userChoice = sortingServices.get(sortingAlgorithm);

        return userChoice.sortStudents(studentDtos);
    }

    @Override
    public List<String> getStudentSortingTypes() {
        return new ArrayList<>(sortingServices.keySet());
    }

    private Set<StudentDto> convertFile(MultipartFile multipartFile) {
        try (Reader reader = new InputStreamReader(multipartFile.getInputStream(), StandardCharsets.UTF_8)) {
            var csvToBean = new CsvToBeanBuilder<StudentDto>(reader)
                    .withType(StudentDto.class)
                    .withFieldAsNull(CSVReaderNullFieldIndicator.BOTH)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSeparator(',')
                    .build();

            return csvToBean.stream().collect(Collectors.toSet());

        } catch (IOException e) {
            log.error("Exception with reading file", e);
        }
        throw new RuntimeException("Not able to convert");
    }
}