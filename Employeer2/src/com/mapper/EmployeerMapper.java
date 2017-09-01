package com.mapper;

import java.util.List;

import com.bean.Employeer;

public interface EmployeerMapper {
	
	//����
	public  int add(Employeer emp);
	
	//�޸�
	public  int update(Employeer emp);
	
	//ɾ��
	public  int delete(int id);
	
	//��ѯ
	public  Employeer query(int id);
	
	//�������ֲ�ѯ
	public List<Employeer> queryByName(String name);
	
	//�������ֺͲ��Ų�ѯ
	public List<Employeer> queryByNameAndDep(String name,String dep);
}
