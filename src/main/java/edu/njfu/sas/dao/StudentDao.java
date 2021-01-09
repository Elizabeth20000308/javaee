package edu.njfu.sas.dao;
import edu.njfu.sas.model.*;

import java.sql.SQLException;
import java.util.List;
public interface StudentDao {
    List<Student> getAllStudent() throws SQLException;
    List<Student> getStudentByName(String name) throws SQLException;
    List<Student> getStudentByPage(int page,int size) throws SQLException;
    List<Student> getStudentByNo(String stuno) throws SQLException;
    boolean saveStudent(Student s);
    boolean deleteStudentByStuno(String s);
    boolean updateStudent(Student s);
    long countToString();
}
