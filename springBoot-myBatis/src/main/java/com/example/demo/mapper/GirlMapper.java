package com.example.demo.mapper;

import com.example.demo.model.Girl;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface GirlMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Girl record);

    int insertSelective(Girl record);

    Girl selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Girl record);

    int updateByPrimaryKey(Girl record);

    //全部的女孩
    List<Girl> selectAllGirl();
}