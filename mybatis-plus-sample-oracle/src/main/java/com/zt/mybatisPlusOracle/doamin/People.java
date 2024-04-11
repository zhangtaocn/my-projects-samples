package com.zt.mybatisPlusOracle.doamin;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author Alnex
 * @CreateTime 2020-08-25 16:37
 * @Descirption JsonProperty 作用 json传值时 实体类的属性字段首字母为大写 需要设置映射配置
 */
@Data
@TableName("PEOPLE")
@KeySequence(value = "PEOPLE_SEQ")
public class People implements Serializable {

	private static final long serialVersionUID = -7319131784076249735L;

	@TableId(value = "ID", type = IdType.INPUT)
	private Integer id;
	@TableField(value ="NAME")
	private String name;
	@TableField(value ="AGE")
	private Integer age;


}
