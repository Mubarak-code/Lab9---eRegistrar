package miu.cs425.eregistrar.service;

import miu.cs425.eregistrar.model.Student;

import java.util.List;

public interface StudentService {
    List <Student> getStudents();
    void createNewStudentRecord(Student student);
    void updateStudentRecord(Long id, Student student);
    void deleteStudentRecord(Long id);
    List<Student> search(String searchWord);
    Student getStudent(Long id);

}
