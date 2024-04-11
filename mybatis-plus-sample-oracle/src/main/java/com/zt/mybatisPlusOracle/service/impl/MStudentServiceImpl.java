package com.zt.mybatisPlusOracle.service.impl;


import com.zt.mybatisPlusOracle.doamin.People;
import com.zt.mybatisPlusOracle.doamin.Student;
import com.zt.mybatisPlusOracle.mapper.MstudentMapper;
import com.zt.mybatisPlusOracle.query.StudentQuery;
import com.zt.mybatisPlusOracle.service.MStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MStudentServiceImpl implements MStudentService {


	@Autowired
	private MstudentMapper mstudentMapper;
	@Override
	public List<Student> selectAll(StudentQuery studentQuery) {
		Integer start = (studentQuery.getPageNo()-1)*studentQuery.getPageSize()+1;
		Integer end = studentQuery.getPageSize()* studentQuery.getPageNo();
		List<Student> students = mstudentMapper.selectAll(start,end);
//		System.out.println(students);
		return students;
	}

	@Override
	public void insert(People people) {
//		System.out.println(people);
		mstudentMapper.insert(people);
	}
}
