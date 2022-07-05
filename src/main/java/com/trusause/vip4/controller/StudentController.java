package com.trusause.vip4.controller;

import com.trusause.vip4.domain.Student;
import com.trusause.vip4.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author weicl
 * @Date 2022/7/5 下午4:06
 * @Version 1.0
 * @Description
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/getById")
    public Student getById(@RequestParam("id") String id) {
        return studentService.getById(id);
    }

    @PostMapping("/save")
    public String save(@RequestBody Student student) {
        return studentService.save(student);
    }

}
