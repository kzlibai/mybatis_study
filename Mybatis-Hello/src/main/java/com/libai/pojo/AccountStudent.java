package com.libai.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class AccountStudent extends Account implements Serializable {
    private String studentName;
    private String address;
    @Override
    public String toString() {
        return super.toString() + "studentName='" + studentName + '\'' +
                ", address='" + address + '\'' + '}';
    }
}
