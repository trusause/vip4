package com.trusause.vip4.dao;

import com.trusause.vip4.domain.Student;
import org.springframework.stereotype.Repository;

/**
 * @Author weicl
 * @Date 2022/7/5 下午3:37
 * @Version 1.0
 * @Description
 */
@Repository
public class StudentDao {

    //演示从数据库中查询数据
    public Student getById(String id) {
        Student student = new Student();
        if (id.equals("001")) {
            student.setId("001");
            student.setName("张三");
            student.setAge(20);
            student.setSex("男");
            student.setPhoneNumber("12345678910");
        }
        return student;
    }

    //演示从数据库添加数据
    public String save(Student student) {
        if (student != null) {
            return "数据成功添加";
        }
        return "数据添加失败";
    }

}
