package com.libai.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student implements Serializable {
    private Integer id;
    private String name;
    private Integer sex;
    private Double score;
    private Date birthday;
    private String address;

    //一对多关系映射，主表方应该包含从表方的集合
    private List<Account> accounts;

    public Student(String name, Integer sex, Double score, Date birthday, String address) {
        this.name = name;
        this.sex = sex;
        this.score = score;
        this.birthday = birthday;
        this.address = address;
    }
}
