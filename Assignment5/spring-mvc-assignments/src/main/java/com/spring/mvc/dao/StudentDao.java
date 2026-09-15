package com.spring.mvc.dao;

import com.spring.mvc.model.StudentMVC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;

@Repository
public class StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Automatically create table if not existing
    @PostConstruct
    public void init() {
        try {
            jdbcTemplate.execute("CREATE TABLE STUDENT_MVC (id VARCHAR2(20) PRIMARY KEY, name VARCHAR2(50), marks NUMBER)");
        } catch (Exception e) {
            // Table already exists
        }
    }

    public int saveStudent(StudentMVC student) {
        String sql = "INSERT INTO STUDENT_MVC (id, name, marks) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, student.getId(), student.getName(), student.getMarks());
    }

    public List<StudentMVC> getAllStudents() {
        String sql = "SELECT id, name, marks FROM STUDENT_MVC";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new StudentMVC(rs.getString("id"), rs.getString("name"), rs.getInt("marks"))
        );
    }
}