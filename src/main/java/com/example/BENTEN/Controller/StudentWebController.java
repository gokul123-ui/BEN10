package com.example.BENTEN.Controller;

import com.example.BENTEN.Model.Student;
import com.example.BENTEN.Service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentWebController {

    @Autowired
    StudentService s;


    // Display all students
    @GetMapping("/students")
    public String getAllStudents(Model model) {

        model.addAttribute("students", s.getAllStudents());
        model.addAttribute("student", new Student());

        return "students";
    }


    // Show Add Student page
    @GetMapping("/students/add")
    public String showAddStudentPage(Model model) {

        model.addAttribute("student", new Student());

        return "add-student";
    }


    // Add Student
    @PostMapping("/students/add")
    public String addStudent(@ModelAttribute Student student) {

        s.addStudents(student);

        return "redirect:/students";
    }


    // Show Edit Student page
    @GetMapping("/students/edit/{rno}")
    public String showEditStudentPage(
            @PathVariable int rno,
            Model model) {

        Student student = s.getStudentByRollNo(rno);

        model.addAttribute("student", student);

        return "edit-student";
    }


    // Update Student
    @PostMapping("/students/update")
    public String updateStudent(@ModelAttribute Student student) {

        s.updateStudent(student);

        return "redirect:/students";
    }


    // Delete Student
    @GetMapping("/students/delete/{rno}")
    public String deleteStudent(@PathVariable int rno) {

        s.deleteStudent(rno);

        return "redirect:/students";
    }


    // Delete all students
    @GetMapping("/students/delete-all")
    public String deleteAllStudents() {

        s.deleteAllStudents();

        return "redirect:/students";
    }


    // Search student by roll number
    @GetMapping("/students/search")
    public String searchStudent(
            @RequestParam int rno,
            Model model) {

        Student student = s.getStudentByRollNo(rno);

        model.addAttribute("students", java.util.List.of(student));

        return "students";
    }


    // Filter by technology
    @GetMapping("/students/technology")
    public String searchByTechnology(
            @RequestParam String technology,
            Model model) {

        model.addAttribute(
                "students",
                s.getAllStudentByTechnology(technology)
        );

        return "students";
    }
}
