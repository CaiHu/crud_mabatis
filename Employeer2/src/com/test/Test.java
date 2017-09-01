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
	
	//����
	public static void add(Employeer emp){
		SqlSession session=null;
		try {
			session=ssf.openSession();
			EmployeerMapper em=session.getMapper(EmployeerMapper.class);
			int count=em.add(emp);
			if(count!=0){
				System.out.println("�������ݳɹ�");
				session.commit();
			}else{
				System.out.println("��������ʧ��");
			}
		} finally {
			session.close();
		} 
	}
	
	//�޸�
	public static void update(Employeer emp){
		SqlSession session=null;
		try {
			session=ssf.openSession();
			EmployeerMapper em=session.getMapper(EmployeerMapper.class);
			int count=em.update(emp);
			if(count!=0){
				System.out.println("�޸����ݳɹ�");
				session.commit();
			}else{
				System.out.println("�޸�����ʧ��");
			}
		} finally {
			session.close();
		} 
	}
	//ɾ��
	public static void delete(int id){
		SqlSession session=null;
		try {
			session=ssf.openSession();
			EmployeerMapper em=session.getMapper(EmployeerMapper.class);
			int count=em.delete(id);
			if(count!=0){
				System.out.println("ɾ�����ݳɹ�");
				session.commit();
			}else{
				System.out.println("ɾ������ʧ��");
			}
		} finally {
			session.close();
		} 
	}
	//��ѯ
	public static void query(int id){
		SqlSession session=null;
		try {
			session=ssf.openSession();
			EmployeerMapper em=session.getMapper(EmployeerMapper.class);
			Employeer emp=em.query(id);
			if(emp!=null){
				System.out.println(em);
			}else{
				System.out.println("û������");
			}
		} finally {
			session.close();
		} 
	}
	
	//�������ֲ�ѯ
	public static void queryByName(String name){
		SqlSession session=null;
		session=ssf.openSession();
		EmployeerMapper em=session.getMapper(EmployeerMapper.class);
		List<Employeer> list =em.queryByName(name);
		if(list.size()>0){
			System.out.println(list);
		}
	}
	
	//�������ֺͲ��Ų�ѯ
	public static void queryByNameAndDep(String name,String dep){
		SqlSession session=null;
		session=ssf.openSession();
		EmployeerMapper em=session.getMapper(EmployeerMapper.class);
		List<Employeer> list =em.queryByNameAndDep(name, dep);
		if(list.size()>0){
			System.out.println(list);
		}else{
			System.out.println("û������");
		}
	}
	
	public static void main(String[] args) {
		Employeer em1=new Employeer(1,"С��",12,"����","�쵼");
		Employeer em2=new Employeer(2,"����",12,"����","����");
		Employeer em3=new Employeer(3,"����",12,"����","���");
//		add(em1);
//		add(em2);
//		add(em3);
		
//		update(em3);
		
//		delete(2);
		
//		query(3);
		
//		queryByName("����");
		
		queryByNameAndDep("����","����");
	}
}
