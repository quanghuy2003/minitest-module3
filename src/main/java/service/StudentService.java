package service;

import model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    void add(Student student);
    void edit(int id,Student student);
    void delete(int id);
    int findId(int id);
}
