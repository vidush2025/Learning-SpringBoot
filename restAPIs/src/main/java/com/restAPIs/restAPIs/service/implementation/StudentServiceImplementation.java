package com.restAPIs.restAPIs.service.implementation;

import com.restAPIs.restAPIs.dto.CreateNewStudentDto;
import com.restAPIs.restAPIs.dto.StudentDto;
import com.restAPIs.restAPIs.dto.UpdateStudentDto;
import com.restAPIs.restAPIs.entity.Student;
import com.restAPIs.restAPIs.repository.StudentRepository;
import com.restAPIs.restAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

//import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImplementation implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<StudentDto> getAllStudents(){
        List<Student> students = studentRepository.findAll();

        //stream is used to convert any Collection A to any different Collection B
        List<StudentDto> studentDtoList = students.stream()
                .map(student -> modelMapper.map(student, StudentDto.class))
                .toList();

        return studentDtoList;
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException(
                                "Student not found with Id: " + id
                        )
                );

        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto createNewStudent(CreateNewStudentDto newStudentDto) {
        Student newStudent = modelMapper.map(newStudentDto, Student.class);
        Student student = studentRepository.save(newStudent);

        return modelMapper.map(student, StudentDto.class);
    }

    public void deleteStudentById(Long id){
        if(!studentRepository.existsById(id)){
            throw new IllegalArgumentException("Student not found for id:" + id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto updateStudentById(Long id, UpdateStudentDto updateStudentDto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Student not found by id:" + id
                ));
        //for put mapping, put(copy) whole dto to the student
        modelMapper.map(updateStudentDto, student);

        student = studentRepository.save(student);
        return modelMapper.map(student, StudentDto.class);
    }
}
