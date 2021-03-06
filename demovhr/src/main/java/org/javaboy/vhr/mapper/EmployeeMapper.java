package org.javaboy.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.javaboy.vhr.model.Employee;

import java.util.Date;
import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    //查询员工基本信息（分页）
    List<Employee> getEmployeeByPage(@Param("page") Integer page, @Param("size") Integer size,
                                     @Param("emp") Employee employee, @Param("beginDateScope") Date[] beginDateScope);

    //查询员工总数
    Long getTotal(@Param("emp") Employee employee, @Param("beginDateScope") Date[] beginDateScope);

    //查询员工号最大值
    Integer maxWorkID();

    Integer addEmps(@Param("list") List<Employee> list);
}