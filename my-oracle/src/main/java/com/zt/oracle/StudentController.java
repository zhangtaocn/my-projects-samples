package com.zt.oracle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/oracle")
public class StudentController {

	private Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	StudentService studentService;

	@GetMapping("/query/{id}")
	public Object findById(@PathVariable("id") Integer id) {
		LOGGER.info("接收的需要查询的数据id 为 {}", id);
		return studentService.findById(id);
	}

	@GetMapping("/all")
	public Object all() {
		return studentService.list();
	}




}
