package com.zt.mybatisPlusOracle.service;



import com.zt.mybatisPlusOracle.doamin.People;
import com.zt.mybatisPlusOracle.doamin.Student;
import com.zt.mybatisPlusOracle.query.StudentQuery;

import java.util.List;

public interface MStudentService {


	List<Student> selectAll(StudentQuery studentQuery);
	void insert(People people);

}
