package com.iven.springboot.service;





import com.iven.springboot.model.SqlName;

import java.util.List;

public interface StudentService {

    //添加用户
    int addStudent(SqlName sqlName);
    //查询
    List<SqlName> findStudents();
}
