package com.example.demo.test.JsonTest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.demo.SpringBootMybatisDemoApplication;
import com.example.demo.test.JsonTest.bean.Person;
import com.example.demo.test.JsonTest.bean.Person1;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootMybatisDemoApplication.class)
@WebAppConfiguration
public class fastJsonTest {
    private List<Person> listOfPersons = new ArrayList<Person>();

    private List<Person1> listOfPersons1 = new ArrayList<Person1>();

    @Autowired
    public void setUp() throws Exception {
        listOfPersons.add(new Person(15, "John Doe", new Date()));
        listOfPersons.add(new Person(20, "Janette Doe", new Date()));
    }

    @Autowired
    public void setUp1() throws Exception {
        listOfPersons1.add(new Person1("dot", "John Doe", new Date()));
        listOfPersons1.add(new Person1("cat", "Janette Doe", new Date()));
    }

    @Test
    public void whenJavaList_thanConvertToJsonCorrect() throws Exception {
        String jsonOutput= JSON.toJSONString(listOfPersons, SerializerFeature.BeanToArray);
        /*[{"AGE":15,"DATE OF BIRTH":1568192225354,"FULL NAME":"John Doe"},
        {"AGE":20,"DATE OF BIRTH":1568192225354,"FULL NAME":"Janette Doe"}]*/
        System.out.println(jsonOutput);
    }

    //自定义了Person实体的字段属性
    @Test
    public void whenJavaList_thanConvertToJsonCorrect1() throws Exception {
        String jsonOutput= JSON.toJSONString(listOfPersons1);
        /*[{"FIRST NAME":"dot","LAST NAME":"John Doe","DATE OF BIRTH":"11/09/2019"},
        {"FIRST NAME":"cat","LAST NAME":"Janette Doe","DATE OF BIRTH":"11/09/2019"}]*/
        System.out.println(jsonOutput);
    }

}