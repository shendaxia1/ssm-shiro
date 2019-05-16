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
	//用于查询出每页显示的数据和每页显示的数量
	public List<TuiGuang> findAllService(int index){
		return tuiGuangMapper.findAll(index);
	}
	//用于查询出所有的数据量
	public int pageCountAll() {
		return tuiGuangMapper.pageCountAll();
	}
	
	
	
	
	public void insertDataService(TuiGuang tuiguang) {
		tuiGuangMapper.insertData(tuiguang);
	}
	//查询service层的函数
	public List<TuiGuang> conFindService(TuiGuang tuiguang,int index,String begin_time,String end_time){
		String pa_name = tuiguang.getPa_name();
		String pa_plan = tuiguang.getPa_plan();
		String pa_login = tuiguang.getPa_login();
		String pa_wx = tuiguang.getPa_wx();

		return tuiGuangMapper.conFind(pa_name,pa_plan,pa_login,pa_wx,begin_time,end_time,index);
	}
	//查询结果的总数
	public List<TuiGuang> conFindCountService(TuiGuang tuiguang,String begin_time,String end_time) {
		String pa_name = tuiguang.getPa_name();
		String pa_plan = tuiguang.getPa_plan();
		String pa_login = tuiguang.getPa_login();
		String pa_wx = tuiguang.getPa_wx();
		return tuiGuangMapper.conFindCount(pa_name,pa_plan,pa_login,pa_wx,begin_time,end_time);
	}


}
