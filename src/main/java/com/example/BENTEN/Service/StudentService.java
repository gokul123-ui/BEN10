package com.example.BENTEN.Service;

import com.example.BENTEN.Model.Student;
import com.example.BENTEN.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//import static jdk.internal.org.jline.utils.Colors.s;

@Service
public class StudentService {
    @Autowired
    StudentRepo r;
    public List<Student> getAllStudents(){
        return r.findAll();
    }
    public String addStudents(Student std){
        r.save(std);
        return"saved";
    }
    public Student getStudentByRollNo(int rno){
        return r.findById(rno).orElse(new Student());
    }
    public String updateStudent(Student std){
        r.save(std);
        return "updated";
    }

    public String deleteStudent(int rno) {
        if(r.existsById(rno)){
            r.deleteById(rno);
            return "deleted";
        }
        return"student not found";
    }

    public String deleteAllStudents() {
        r.deleteAll();
        return "deleted";
    }

    public List<Student> getAllStudentByTechnology(String tech) {
      return  r.findByTechnology(tech);
    }
}
