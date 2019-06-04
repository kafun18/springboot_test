package com.example.demo.swagger.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class JsonResult {
    private String status = null;

    private Object result = null;
}
