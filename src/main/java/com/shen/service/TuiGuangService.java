package com.shen.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shen.mapper.TuiGuangMapper;
import com.shen.model.TuiGuang;

@Service
public class TuiGuangService {
	@Autowired
	private TuiGuangMapper tuiGuangMapper;
	//���ڲ�ѯ��ÿҳ��ʾ�����ݺ�ÿҳ��ʾ������
	public List<TuiGuang> findAllService(int index){
		return tuiGuangMapper.findAll(index);
	}
	//���ڲ�ѯ�����е�������
	public int pageCountAll() {
		return tuiGuangMapper.pageCountAll();
	}
	
	
	
	
	public void insertDataService(TuiGuang tuiguang) {
		tuiGuangMapper.insertData(tuiguang);
	}
	//��ѯservice��ĺ���
	public List<TuiGuang> conFindService(TuiGuang tuiguang,int index,String begin_time,String end_time){
		String pa_name = tuiguang.getPa_name();
		String pa_plan = tuiguang.getPa_plan();
		String pa_login = tuiguang.getPa_login();
		String pa_wx = tuiguang.getPa_wx();

		return tuiGuangMapper.conFind(pa_name,pa_plan,pa_login,pa_wx,begin_time,end_time,index);
	}
	//��ѯ���������
	public List<TuiGuang> conFindCountService(TuiGuang tuiguang,String begin_time,String end_time) {
		String pa_name = tuiguang.getPa_name();
		String pa_plan = tuiguang.getPa_plan();
		String pa_login = tuiguang.getPa_login();
		String pa_wx = tuiguang.getPa_wx();
		return tuiGuangMapper.conFindCount(pa_name,pa_plan,pa_login,pa_wx,begin_time,end_time);
	}


}
