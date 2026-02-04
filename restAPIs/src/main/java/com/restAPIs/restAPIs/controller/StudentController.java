package com.restAPIs.restAPIs.controller;

import com.restAPIs.restAPIs.dto.StudentDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class StudentController {

    @GetMapping("/student")
    public StudentDto getStudent(){
        return new StudentDto(47L, "Vidush", "vidush@gmail.com");
    }
}
