package com.zt.mybatisPlusOracle.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.zt.mybatisPlusOracle.doamin.Student;
import com.zt.mybatisPlusOracle.query.PageList;
import com.zt.mybatisPlusOracle.query.StudentQuery;

public interface StudentService extends IService<Student> {

	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	Object findById(Integer id);

	/**
	 * 根据id删除
	 * @param id
	 * @return
	 */
	Object deleteById(Integer id);

	PageList<Student> pageList(StudentQuery studentQuery);


}
