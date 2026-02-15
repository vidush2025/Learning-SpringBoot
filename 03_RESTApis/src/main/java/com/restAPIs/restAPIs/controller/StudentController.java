package com.restAPIs.restAPIs.controller;

import com.restAPIs.restAPIs.dto.CreateNewStudentDto;
import com.restAPIs.restAPIs.dto.StudentDto;
import com.restAPIs.restAPIs.dto.UpdateStudentDto;
import com.restAPIs.restAPIs.entity.Student;
import com.restAPIs.restAPIs.repository.StudentRepository;
import com.restAPIs.restAPIs.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<StudentDto>> getAllStudent(){
//      return studentService.getAllStudents();
//      return ResponseEntity.status(HttpStatusCode.OK).body(studentService.getAllStudents());
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }
    @PostMapping("/students")
    public ResponseEntity<StudentDto> createNewStudent(@RequestBody @Valid CreateNewStudentDto newStudentDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(newStudentDto));
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<StudentDto> updateStudentById(@PathVariable Long id, @Valid UpdateStudentDto updateStudentDto){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.updateStudentById(id, updateStudentDto));
    }

}
