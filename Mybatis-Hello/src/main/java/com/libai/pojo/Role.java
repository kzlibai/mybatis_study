package com.libai.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Role implements Serializable {
    private Integer id;
    private String roleName;
    private String describ;
    //多对多的映射，一个角色可以赋给多个学生
    private List<Student> students;
}
