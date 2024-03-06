package com.agustin.school.service;

import com.agustin.school.client.StudentClient;
import com.agustin.school.model.FullSchoolResponse;
import com.agustin.school.model.School;
import com.agustin.school.model.Student;
import com.agustin.school.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository schoolRepository;
    private final StudentClient client;

    public void saveSchool(School student) {
        schoolRepository.save(student);
    }

    public List<School> findAllSchools() {
        return schoolRepository.findAll();
    }

    public FullSchoolResponse findSchoolsWithStudents(Integer schoolId) {
        School school = schoolRepository.findById(schoolId).orElse(
                School.builder()
                        .name("NOT FOUND")
                        .email("NOT FOUND")
                        .build());
        List<Student> student = client.findAllStudentsBySchool(schoolId);

        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(student)
                .build();

    }
}

