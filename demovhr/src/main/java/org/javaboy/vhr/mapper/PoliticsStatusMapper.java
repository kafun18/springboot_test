package org.javaboy.vhr.mapper;

import org.javaboy.vhr.model.PoliticsStatus;

import java.util.List;

public interface PoliticsStatusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PoliticsStatus record);

    int insertSelective(PoliticsStatus record);

    PoliticsStatus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PoliticsStatus record);

    int updateByPrimaryKey(PoliticsStatus record);

    //查询所有职称
    List<PoliticsStatus> getAllPoliticsStatus();
}