package mmh.jpastudentmmh.repositories;

import mmh.jpastudentmmh.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    /*Metoden findAllByName skal defineres StudentRepository, fordi den ikke er en del af standard CRUD-metoder
    i JpaRepository. Spring Data JPA bruger metodenavnet til at opbygge en forespørgsel dynamisk, hvilket gør det nemt at
    arbejde med komplekse forespørgsler uden at skulle skrive SQL manuelt. Derfor er det nødvendigt at tilføje metodesignaturen
    i repository-interface.
     */

    List<Student> findAllByName(String name);
}
