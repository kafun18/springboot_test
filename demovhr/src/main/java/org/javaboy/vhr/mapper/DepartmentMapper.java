package org.javaboy.vhr.mapper;

import org.javaboy.vhr.model.Department;

import java.util.List;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    //查询所有部门
    List<Department> getAllDepartmentsByParentId(Integer parentId);
}