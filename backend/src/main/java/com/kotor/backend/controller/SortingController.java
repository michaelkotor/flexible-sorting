package com.kotor.backend.controller;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kotor.backend.facade.StudentFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/sorting")
public class SortingController {

    private final StudentFacade studentFacade;

    @GetMapping("types")
    public ResponseEntity<List<String>> getTypes() {
        return ResponseEntity.ok(studentFacade.getStudentSortingTypes());
    }
}
