package mmh.jpastudentmmh.controller;

import mmh.jpastudentmmh.model.Student;
import mmh.jpastudentmmh.repositories.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentRestController {

    StudentRepository studentRepository;


    public StudentRestController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @GetMapping("/students")
    public List<Student> students() {
        var obj = studentRepository.findAll();
        return obj;
    }

    @GetMapping("/students/{name}")
    public List<Student> findAllByName(@PathVariable String name) {
        return studentRepository.findAllByName(name);
    }

    @PostMapping("/student")
    @ResponseStatus
    public Student postStudent(@RequestBody Student student) {
        return studentRepository.save(student);

    }


}
