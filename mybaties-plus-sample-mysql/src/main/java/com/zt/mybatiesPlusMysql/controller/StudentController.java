package com.zt.mybatiesPlusMysql.controller;

import com.alibaba.fastjson.JSON;
import com.zt.mybatiesPlusMysql.entity.TestData;
import com.zt.mybatiesPlusMysql.enums.TestEnum;
import com.zt.mybatiesPlusMysql.mapper.TestDataMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/oracle")
public class StudentController {

	private Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	TestDataMapper testDataMapper;

	@GetMapping("/all")
	public Object all() {
		int size = 2;
		List<TestData> testDataList = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			String str = i + "条";
			TestData testData = new TestData().setTestInt(i).setTestStr(str);
			testDataList.add(testData);

			testDataMapper.insert(testData);
			LOGGER.info("插入成功 为 {}", JSON.toJSON(testData));
		}
		testDataList.forEach(System.err::println);
		List<TestData> allNoTenant = testDataMapper.getAllNoTenant();
		LOGGER.info("接收的需要查询的数据list 为 {}", JSON.toJSON(allNoTenant));

		return allNoTenant;
	}



}
