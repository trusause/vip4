package com.trusause.vip4.service;

import com.trusause.vip4.dao.StudentDao;
import com.trusause.vip4.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author weicl
 * @Date 2022/7/5 下午4:05
 * @Version 1.0
 * @Description
 */
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public Student getById(String id) {
        return studentDao.getById(id);
    }

    @Override
    public String save(Student student) {
        return studentDao.save(student);
    }
}
