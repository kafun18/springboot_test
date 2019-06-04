package com.example.demo.service;

import com.example.demo.model.Girl;

import java.util.List;

/**
 * Created by jing on 2017/10/30.
 */
public interface GirlService {
    int addGirl(Girl girl);

    List<Girl> findAllGirl(int pageNum, int pageSize);
}
