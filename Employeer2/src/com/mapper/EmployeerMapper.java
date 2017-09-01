package com.mapper;

import java.util.List;

import com.bean.Employeer;

public interface EmployeerMapper {
	
	//新增
	public  int add(Employeer emp);
	
	//修改
	public  int update(Employeer emp);
	
	//删除
	public  int delete(int id);
	
	//查询
	public  Employeer query(int id);
	
	//根据名字查询
	public List<Employeer> queryByName(String name);
	
	//根据名字和部门查询
	public List<Employeer> queryByNameAndDep(String name,String dep);
}
