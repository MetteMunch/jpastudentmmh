package mmh.jpastudentmmh.repositories;

import mmh.jpastudentmmh.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("testh2")
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    public void testSaveToH2() {

        //Arrange
        List<Student> listOfStudents = studentRepository.findAll();

        //Act
        int actualSize = listOfStudents.size();
        int expectedSize = 2;

        //Assert
        assertEquals(expectedSize,actualSize);
    }

    @Test
    public void testOneViggo() {
        //Arrange
        Student s1 = new Student();
        s1.setName("Viggo");
        s1.setBornDate(LocalDate.of(1974,02,23));
        studentRepository.save(s1);

        //Act
        List<Student> list = studentRepository.findAllByName("Viggo");
        int expectedSize = 1;
        int actualSize = list.size();

        //Assert
        assertEquals(expectedSize, actualSize);
    }
}