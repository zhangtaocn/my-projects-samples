package com.zt.oracle;

import com.baomidou.mybatisplus.extension.service.IService;

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


}
