package com.zt.oracle;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
		queryWrapper.eq("STUID", id);

		return super.remove(queryWrapper);
	}

}
