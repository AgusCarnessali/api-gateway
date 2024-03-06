package com.agustin.school.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Builder
@Data
public class FullSchoolResponse {

    private String email;
    private String name;
    List<Student> students;
}
