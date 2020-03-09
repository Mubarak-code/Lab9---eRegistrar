package miu.cs425.eregistrar.repository;

import miu.cs425.eregistrar.model.Student;
import org.hibernate.Criteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "FROM Student s where s.firstName  Like %:searchWord%  or s.middleName Like %:searchWord% or s.lastName Like %:searchWord% or s.studentNumber Like %:searchWord%")
    List<Student> search(@Param("searchWord") String searchWord);

}