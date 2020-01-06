package org.javaboy.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.javaboy.vhr.model.Position;
import org.javaboy.vhr.model.RespBean;

import java.util.List;

public interface PositionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Position record);

    int insertSelective(Position record);

    Position selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);

    //查询所有职位
    List<Position> getAllPositions();

    //根据id删除职位
    Integer deletePositionByIds(@Param("ids") Integer[] ids);

}