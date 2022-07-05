package com.trusause.vip4.service;

import com.trusause.vip4.domain.Student;

/**
 * @Author weicl
 * @Date 2022/7/5 下午4:04
 * @Version 1.0
 * @Description
 */
public interface StudentService {

    public Student getById(String id);

    public String save(Student student);

}
