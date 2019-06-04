package com.example.demo.controller;

import com.example.demo.model.Result;
import com.example.demo.model.Girl;
import com.example.demo.resultUtil.ResultUtil;
import com.example.demo.service.impl.GirlServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * Created by jing on 2017/10/30.
 */
@Controller
public class GirlController {

    @Autowired
    private GirlServiceImpl girlServiceImpl;

    @ResponseBody
    @RequestMapping("/add")
    public Result<Girl> addGirl(Girl girl){

        if(girl.getAge() == null || girl.getCupSize() == null || girl.getCupSize() == ""){
            Result<Girl> result = new Result<Girl>();
            result.setMsg("添加失败,罩杯和年龄-> 必 、须 、填 !~~");
            result.setData(girl);
            return result;
        }else {
            int i = girlServiceImpl.addGirl(girl);
            if (i == 1) {
                List<Girl> list = getAllGirl();
                return ResultUtil.success(list.get(list.size() - 1));
            }
        }
        return ResultUtil.error("添加失败");
    }

    @ResponseBody
    @RequestMapping("/date")
    public String getDate(){
        return "北京时间:"+(new Date()).toString();
    }

    @ResponseBody
    @RequestMapping("/allGirl")
    public List<Girl> getAllGirl(){
        List<Girl> list = girlServiceImpl.findAllGirl(0,100);
        return list;
    }

    @RequestMapping("/ai")
    public String index(){
        return "ai";
    }
}
