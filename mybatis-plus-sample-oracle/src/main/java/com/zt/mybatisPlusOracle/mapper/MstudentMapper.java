package com.zt.mybatisPlusOracle.mapper;


import com.zt.mybatisPlusOracle.doamin.People;
import com.zt.mybatisPlusOracle.doamin.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Alnex
 * @CreateTime 2020-08-25 16:46
 * @Descirption
 */
@Mapper
public interface MstudentMapper {
    List<Student> selectAll(@Param("start") Integer start, @Param("end") Integer end);
    void insert(People people);
}
