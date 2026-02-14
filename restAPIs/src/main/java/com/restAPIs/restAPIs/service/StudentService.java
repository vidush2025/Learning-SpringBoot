package com.restAPIs.restAPIs.service;

import com.restAPIs.restAPIs.dto.CreateNewStudentDto;
import com.restAPIs.restAPIs.dto.StudentDto;
import com.restAPIs.restAPIs.dto.UpdateStudentDto;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface StudentService {

    List<StudentDto> getAllStudents();
    StudentDto getStudentById(@PathVariable Long id);
    StudentDto createNewStudent(CreateNewStudentDto newStudentDto);
    void deleteStudentById(Long id);
    StudentDto updateStudentById(Long id, UpdateStudentDto updateStudentDto);
}
