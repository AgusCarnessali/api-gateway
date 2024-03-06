package com.agustin.school.client;

import com.agustin.school.model.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "student-service",url = "http://localhost:8090/api/v1/students")
public interface StudentClient {
    @GetMapping("/school/{school-id}")
    List<Student>findAllStudentsBySchool(@PathVariable("school-id")Integer schoolId);
}
