package com.example.demo.service.impl;

import com.example.demo.mapper.GirlMapper;
import com.example.demo.model.Girl;
import com.example.demo.service.GirlService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jing on 2017/10/30.
 */
@Service
public class GirlServiceImpl implements GirlService {

    @Autowired
    private GirlMapper girlMapper;//这里会报错，但是并不会影响

    @Override
    public int addGirl(Girl girl){
        return girlMapper.insertSelective(girl);
    }

    @Override
    public List<Girl> findAllGirl(int pageNum, int pageSize){
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        return girlMapper.selectAllGirl();
    }
}
