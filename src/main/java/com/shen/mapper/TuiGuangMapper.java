package com.shen.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.shen.model.TuiGuang;

public interface TuiGuangMapper {
	//获取分页每页显示的数据和每页的数据量
	List<TuiGuang> findAll(@Param("index") int index);
	//获取页面总数
	int pageCountAll();
	//读取csv的内容后插入数据库
	void insertData(TuiGuang tuiguang);
	
	List<TuiGuang> conFind(@Param("pa_name") String pa_name,@Param("pa_plan") String pa_plan,@Param("pa_login") String pa_login,@Param("pa_wx") String pa_wx,@Param("begin_time") String begin_time,@Param("end_time") String end_time,@Param("index") int index);
	
	List<TuiGuang> conFindCount(@Param("pa_name") String pa_name,@Param("pa_plan") String pa_plan,@Param("pa_login") String pa_login,@Param("pa_wx") String pa_wx,@Param("begin_time") String begin_time,@Param("end_time") String end_time);

}
