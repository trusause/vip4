package com.trusause.vip4.service;

import com.trusause.vip4.dao.StudentDao;
import com.trusause.vip4.domain.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * @Author weicl
 * @Date 2022/7/5 下午4:08
 * @Version 1.0
 * @Description
 */
class StudentServiceTest {

    @InjectMocks
    StudentServiceImpl studentService;

    @Mock
    StudentDao studentDao;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getById() {
        Student student = new Student();
        student.setId("001");
        student.setName("张三");
        //when里面带的是条件，thenReturn里面表示的是返回结果
        Mockito.when(studentDao.getById("001")).thenReturn(student);
        //assertThat后面跟着断言的判断语句
        Assertions.assertEquals(studentService.getById(student.getId()).getName(), "张三");
    }

    @Test
    public void save() {
        Student student = new Student();
        student.setId("002");
        student.setName("李四");
        //when里面带的是条件，thenReturn里面表示的是返回结果
        Mockito.when(studentDao.save(student))
                .thenReturn("数据成功添加");
        //assertThat后面跟着断言的判断语句
        Assertions.assertEquals(studentService.save(student), "数据成功添加");
    }

}