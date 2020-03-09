package miu.cs425.eregistrar.service.serviceImpl;

import miu.cs425.eregistrar.model.Student;
import miu.cs425.eregistrar.repository.StudentRepository;
import miu.cs425.eregistrar.service.StudentService;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepo;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public List<Student> getStudents() {

        return studentRepo.findAll();
    }
    public Student getStudent(Long id){
        return studentRepo.findById(id).get();
    }

    @Override
    public void createNewStudentRecord(Student student) {
        studentRepo.save(student);

    }

    @Override
    public void updateStudentRecord(Long id, Student student) {
        Student s = studentRepo.findById(id).get();
//        s.setStudentId(student.getStudentId());
        s.setFirstName(student.getFirstName());
        s.setStudentNumber(student.getStudentNumber());
        s.setFirstName(student.getFirstName());
        s.setMiddleName(student.getMiddleName());
        s.setLastName(student.getLastName());
        s.setCgpa(student.getCgpa());
        s.setEnrollmentDate(student.getEnrollmentDate());
        s.setInternational(student.getInternational());
        studentRepo.save(s);
    }

    @Override
    public void deleteStudentRecord(Long id) {
        studentRepo.deleteById(id);
    }

    public List<Student> search(String searchWord){
        return studentRepo.search(searchWord);
    }

}




