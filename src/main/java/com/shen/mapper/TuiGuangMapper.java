package com.shen.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.shen.model.TuiGuang;

public interface TuiGuangMapper {
	//��ȡ��ҳÿҳ��ʾ�����ݺ�ÿҳ��������
	List<TuiGuang> findAll(@Param("index") int index);
	//��ȡҳ������
	int pageCountAll();
	//��ȡcsv�����ݺ�������ݿ�
	void insertData(TuiGuang tuiguang);
	
	List<TuiGuang> conFind(@Param("pa_name") String pa_name,@Param("pa_plan") String pa_plan,@Param("pa_login") String pa_login,@Param("pa_wx") String pa_wx,@Param("begin_time") String begin_time,@Param("end_time") String end_time,@Param("index") int index);
	
	List<TuiGuang> conFindCount(@Param("pa_name") String pa_name,@Param("pa_plan") String pa_plan,@Param("pa_login") String pa_login,@Param("pa_wx") String pa_wx,@Param("begin_time") String begin_time,@Param("end_time") String end_time);

}
