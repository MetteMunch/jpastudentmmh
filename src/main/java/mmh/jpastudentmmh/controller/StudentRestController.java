package mmh.jpastudentmmh.controller;

import mmh.jpastudentmmh.model.Student;
import mmh.jpastudentmmh.repositories.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentRestController {

    StudentRepository studentRepository;


    public StudentRestController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @GetMapping("/students")
    public List<Student> students() {
        postStudent();
        var obj = studentRepository.findAll();
        return obj;
    }

    @GetMapping("/students/{name}")
    public List<Student> findAllByName(@PathVariable String name) {
        return studentRepository.findAllByName(name);
    }

//    @PostMapping("/student")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Student postStudent(@RequestBody Student student) {
//        return studentRepository.save(student);
//
//    }

    @PostMapping("/student")
    @ResponseStatus(HttpStatus.CREATED)
    public Student postStudent() {
        Student testStudent = new Student();
        testStudent.setName("Luna");
        return studentRepository.save(testStudent);

    }

    @PutMapping("/student")
    public ResponseEntity<Student> putStudent(@RequestBody Student student) {
        Optional<Student> orgStudent = studentRepository.findById(student.getId());
        if(orgStudent.isPresent()) {
          studentRepository.save(student);
          return new ResponseEntity<>(student,HttpStatus.OK);
        }
        return new ResponseEntity<>(new Student(),HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        Optional<Student> orgStudent = studentRepository.findById(id);
        if(orgStudent.isPresent()) {
            studentRepository.deleteById(id);
            return ResponseEntity.ok("Student deleted");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
    }


}
