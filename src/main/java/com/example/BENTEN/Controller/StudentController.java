package com.example.BENTEN.Controller;

import com.example.BENTEN.Model.Student;
import com.example.BENTEN.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
public class StudentController {
    @Autowired
    StudentService s;
    @GetMapping("Students")
    public List<Student>getAllStudents(){
        return s.getAllStudents();
    }
    @PostMapping("Students")
    public String addStudents(@RequestBody Student std){
        return s.addStudents(std);
    }
    @GetMapping("Students/{rno}")
    public Student getStudentByRollNo(@PathVariable int rno){
        return s.getStudentByRollNo(rno);
    }
    @PutMapping("Students")
    public String updateStudent(@RequestBody Student std){
        return s.updateStudent(std);
    }
    @DeleteMapping("Students/{rno}")
    public  String deleteStudentByRollNo(@PathVariable int rno){
        return s.deleteStudent(rno);
    }
    @DeleteMapping("Students/clear")
    public String deleteAllStudents(){
        return s.deleteAllStudents();
    }
    @GetMapping("Students/Technology/{tech}")
    public List<Student>getAllStudentByTech(@PathVariable String tech){
        return s.getAllStudentByTechnology(tech);
    }
}

