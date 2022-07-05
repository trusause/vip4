package com.trusause.vip4.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author weicl
 * @Date 2022/7/5 下午3:33
 * @Version 1.0
 * @Description
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private String id;

    private String name;

    private Integer age;

    private String sex;

    private String phoneNumber;

}
