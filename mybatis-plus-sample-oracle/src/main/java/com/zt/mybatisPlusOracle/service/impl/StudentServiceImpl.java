package com.zt.mybatisPlusOracle.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zt.mybatisPlusOracle.doamin.Student;
import com.zt.mybatisPlusOracle.mapper.StudentMapper;
import com.zt.mybatisPlusOracle.query.PageList;
import com.zt.mybatisPlusOracle.query.StudentQuery;
import com.zt.mybatisPlusOracle.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

	@Autowired
	private StudentMapper studentMapper;
	@Override
	public Object findById(Integer id) {
//		QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
//		queryWrapper.eq("STUID",id);
		Student student = studentMapper.selectOne(new LambdaQueryWrapper<Student>().eq(Student::getId, id));
		System.out.println(student);

		return student;
	}

	@Override
	public Object deleteById(Integer id) {
		Student student = (Student) this.findById(id);

		if (student == null){
			return "为查询到数据";
		}
		QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("ID", id);

		return super.remove(queryWrapper);
	}

	@Override
	public PageList<Student> pageList(StudentQuery studentQuery) {
		Page<Student> page = new Page<Student>(studentQuery.getPageNo(), studentQuery.getPageSize());
		page = baseMapper.selectPage(page, null);
		PageList<Student> students = new PageList<Student>(page.getTotal(), page.getRecords());
//		System.out.println(students);
		return students;
	}


}
