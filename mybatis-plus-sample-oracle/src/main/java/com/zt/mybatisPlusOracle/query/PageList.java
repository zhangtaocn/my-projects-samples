package com.zt.mybatisPlusOracle.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor //全参数构造器
@NoArgsConstructor  //无参数构造器
public class PageList<T> {
    private Long total;
    private List<T> rows = new ArrayList<>();
}