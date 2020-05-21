package com.demo.dao;

import com.demo.beans.College;
import com.demo.beans.CollegeExample;
import com.sun.javafx.collections.MappingChange.Map;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CollegeMapper {
    long countByExample(CollegeExample example);

    int deleteByExample(CollegeExample example);

    int deleteByPrimaryKey(Integer cid);

    int insert(College record);

    int insertSelective(College record);

    List<College> selectByExample(CollegeExample example);
    
    List<Map> selectByMap(CollegeExample example);
    
    List<College> getAllColleges();

    College selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param("record") College record, @Param("example") CollegeExample example);

    int updateByExample(@Param("record") College record, @Param("example") CollegeExample example);

    int updateByPrimaryKeySelective(College record);

    int updateByPrimaryKey(College record);
}