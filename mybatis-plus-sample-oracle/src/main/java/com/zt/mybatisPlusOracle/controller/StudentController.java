package com.zt.mybatisPlusOracle.controller;

import com.alibaba.fastjson.JSON;
import com.zt.mybatisPlusOracle.ajaxRes.AjaxResult;
import com.zt.mybatisPlusOracle.doamin.People;
import com.zt.mybatisPlusOracle.doamin.Student;
import com.zt.mybatisPlusOracle.query.StudentQuery;
import com.zt.mybatisPlusOracle.service.MStudentService;
import com.zt.mybatisPlusOracle.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/oracle")
public class StudentController {

	private Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	StudentService studentService;
	@Autowired
	private MStudentService mStudentService;

	@GetMapping("/query/{id}")
	public Object findById(@PathVariable("id") Integer id) {
		LOGGER.info("接收的需要查询的数据id 为 {}", id);
		return studentService.findById(id);
	}

	@GetMapping("/all")
	public Object all() {
		List<Student> list = studentService.list();
		LOGGER.info("接收的需要查询的数据list 为 {}", JSON.toJSON(list));

		return list;
	}

	@PostMapping("/add")
	public AjaxResult addDate(@RequestBody Student student){
		LOGGER.info("接收的需要新增的数据student 为 {}", student);
		studentService.save(student);
		return AjaxResult.me();
	}

	@DeleteMapping("/del/{id}")
	public Object delDate(@PathVariable("id") Integer id){
		LOGGER.info("接收的需要删除数据的id 为 {}", id);
		return studentService.deleteById(id);
	}

	@PostMapping("/pageList")
	public AjaxResult pageList(@RequestBody StudentQuery studentQuery){
//		Page<Student> page = new Page<Student>(studentQuery.getPageNo(), studentQuery.getPageSize());
////		page = courseOrderService.page(page);
//		page = studentService.page(page);
//
//
//		PageList<Student> students = new PageList<Student>(page.getTotal(), page.getRecords());
		return AjaxResult.me().setData(studentService.pageList(studentQuery));
//		return AjaxResult.me().setData(students);
	}
	@PostMapping("/selectAll")
	public AjaxResult selectAll(@RequestBody StudentQuery studentQuery){
		return AjaxResult.me().setData(mStudentService.selectAll(studentQuery));
	}
	@PostMapping("/insert")
	public AjaxResult insert(@RequestBody People people){
		mStudentService.insert(people);
		return AjaxResult.me();
	}

}
