package com.agustin.school.controller;

import com.agustin.school.model.FullSchoolResponse;
import com.agustin.school.model.School;
import com.agustin.school.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/schools")
public class SchoolController {

    private final SchoolService service;
    private static final Logger logger = LoggerFactory.getLogger(SchoolController.class);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody School student) {
        service.saveSchool(student);
    }

    @GetMapping
    public ResponseEntity<List<School>> findAllSchools() {
        return ResponseEntity.ok(service.findAllSchools());
    }

    @GetMapping("/with-students/{school-id}")
    public ResponseEntity<FullSchoolResponse> findSchoolWithStudents(@PathVariable("school-id") Integer schoolId) {

        return new ResponseEntity<>(service.findSchoolsWithStudents(schoolId), HttpStatus.OK);
    }
}
