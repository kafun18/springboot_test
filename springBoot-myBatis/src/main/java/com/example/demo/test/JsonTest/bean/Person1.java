package com.example.demo.test.JsonTest.bean;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Person1 {

    @JSONField(name="AGE", serialize=false)
    private int age;

    @JSONField(name="LAST NAME", ordinal = 2)
    private String lastName;

    @JSONField(name="FIRST NAME", ordinal = 1)
    private String firstName;

    @JSONField(name="DATE OF BIRTH", format="dd/MM/yyyy", ordinal = 3)
    private Date dateOfBirth;

    public Person1(String firstName, String lastName, Date dateOfBirth) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }
}
