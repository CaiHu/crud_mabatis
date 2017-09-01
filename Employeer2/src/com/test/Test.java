package com.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bean.Employeer;
import com.mapper.EmployeerMapper;


public class Test {
	private static Reader reader;
	private static SqlSessionFactory ssf;
	
	static{
		try {
			reader=Resources.getResourceAsReader("mybatis.xml");
			ssf=new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//新增
	public static void add(Employeer emp){
		SqlSession session=null;
		try {
			session=ssf.openSession();
			EmployeerMapper em=session.getMapper(EmployeerMapper.class);
			int count=em.add(emp);
			if(count!=0){
				System.out.println("插入数据成功");
				session.commit();
			}else{
				System.out.println("出入数据失败");
			}
		} finally {
			session.close();
		} 
	}
	
	//修改
	public static void update(Employeer emp){
		SqlSession session=null;
		try {
			session=ssf.openSession();
			EmployeerMapper em=session.getMapper(EmployeerMapper.class);
			int count=em.update(emp);
			if(count!=0){
				System.out.println("修改数据成功");
				session.commit();
			}else{
				System.out.println("修改数据失败");
			}
		} finally {
			session.close();
		} 
	}
	//删除
	public static void delete(int id){
		SqlSession session=null;
		try {
			session=ssf.openSession();
			EmployeerMapper em=session.getMapper(EmployeerMapper.class);
			int count=em.delete(id);
			if(count!=0){
				System.out.println("删除数据成功");
				session.commit();
			}else{
				System.out.println("删除数据失败");
			}
		} finally {
			session.close();
		} 
	}
	//查询
	public static void query(int id){
		SqlSession session=null;
		try {
			session=ssf.openSession();
			EmployeerMapper em=session.getMapper(EmployeerMapper.class);
			Employeer emp=em.query(id);
			if(emp!=null){
				System.out.println(em);
			}else{
				System.out.println("没有数据");
			}
		} finally {
			session.close();
		} 
	}
	
	//根据名字查询
	public static void queryByName(String name){
		SqlSession session=null;
		session=ssf.openSession();
		EmployeerMapper em=session.getMapper(EmployeerMapper.class);
		List<Employeer> list =em.queryByName(name);
		if(list.size()>0){
			System.out.println(list);
		}
	}
	
	//根据名字和部门查询
	public static void queryByNameAndDep(String name,String dep){
		SqlSession session=null;
		session=ssf.openSession();
		EmployeerMapper em=session.getMapper(EmployeerMapper.class);
		List<Employeer> list =em.queryByNameAndDep(name, dep);
		if(list.size()>0){
			System.out.println(list);
		}else{
			System.out.println("没有数据");
		}
	}
	
	public static void main(String[] args) {
		Employeer em1=new Employeer(1,"小明",12,"机关","领导");
		Employeer em2=new Employeer(2,"张三",12,"机关","下属");
		Employeer em3=new Employeer(3,"李四",12,"机关","情节");
//		add(em1);
//		add(em2);
//		add(em3);
		
//		update(em3);
		
//		delete(2);
		
//		query(3);
		
//		queryByName("李四");
		
		queryByNameAndDep("李四","机关");
	}
}
