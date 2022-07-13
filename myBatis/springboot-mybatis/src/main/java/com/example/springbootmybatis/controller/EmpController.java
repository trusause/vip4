package com.example.springbootmybatis.controller;

import com.example.springbootmybatis.dao.EmpMapper;
import com.example.springbootmybatis.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author weicl
 * @Date 2022/7/13 下午4:11
 * @Version 1.0
 * @Description
 */

@RequestMapping("/emp")
@RestController
public class EmpController {

    @Autowired
    private EmpMapper empMapper;

    @GetMapping("/getAll")
    @ResponseBody
    public List<Emp> getAll() {
        return empMapper.selectAll();
    }

}
