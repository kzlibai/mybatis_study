package com.libai.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Account implements Serializable {
    private Integer id;
    private Integer studentId;
    private Double money;
    private Student student;
}
