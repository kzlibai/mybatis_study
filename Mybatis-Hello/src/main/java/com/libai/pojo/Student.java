package com.libai.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * 学生实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    private Integer id;
    private String studentName;
    private Integer sex;
    private Float score;
    private Date birthday;
    private String address;

    public Student(String studentName, Integer sex, Float score, Date birthday, String address) {
        this.studentName = studentName;
        this.sex = sex;
        this.score = score;
        this.birthday = birthday;
        this.address = address;
    }
}
