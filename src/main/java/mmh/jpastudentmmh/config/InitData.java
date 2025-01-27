package mmh.jpastudentmmh.config;

import mmh.jpastudentmmh.model.Student;
import mmh.jpastudentmmh.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Component
public class InitData implements CommandLineRunner {  //Spring Boot kalder automatisk metoden run() i klasser, der implementerer CommandLineRunner,
    // når applikationen starter op.

    StudentRepository studentRepository;

    public InitData(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Student student1 = new Student();
        student1.setName("Tim");
        student1.setBornDate(LocalDate.of(2000,02,23));
        student1.setBornTime(LocalTime.of(22,32));

        studentRepository.save(student1);

        Student student2 = new Student();
        student2.setName("Hanna");
        student2.setBornDate(LocalDate.of(2000,02,23));
        student2.setBornTime(LocalTime.of(22,32));

        studentRepository.save(student2);

    }
}
