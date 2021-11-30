package service;

import model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService{
    private List<Student> studentList;
    public StudentServiceImpl() {
        studentList=new ArrayList<>();
        studentList.add(new Student(1,"huy",10,10,10));
        studentList.add(new Student(2,"uy",7,8,9));
        studentList.add(new Student(3,"dung",9,8,7));
    }

    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public void add(Student student) {
        studentList.add(student);
    }

    @Override
    public void edit(int id, Student student) {
        studentList.set(findId(id),student);

    }

    @Override
    public void delete(int id) {
        studentList.remove(findId(id));
    }

    @Override
    public int findId(int id) {
        for (int i = 0; i < studentList.size(); i++) {
            if(studentList.get(i).getId()==id){
                return i;
            }
        }
        return -1;
    }
}
