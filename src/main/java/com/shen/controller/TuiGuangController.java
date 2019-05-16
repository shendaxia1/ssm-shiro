package com.shen.controller;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.shen.model.TuiGuang;
import com.shen.service.TuiGuangService;

import util.Csv;
import util.PageUtil;


@Controller
@RequestMapping(value = "/tuiguang")
public class TuiGuangController {
	@Autowired
	private TuiGuangService tuiGuangService;
	
	@RequestMapping(value = "/toIndex")
	public String toIndex() {
		return "login";
	}
	@RequestMapping(value="/findAll")
	public String findAllController(Model model,@RequestParam(value="pageIndex",defaultValue="1") int pageIndex) {
		int pageSize=10;//����ÿҳ��ʾ���������ݣ������sql����е�limit���������һ��
		PageUtil<TuiGuang> pageUtile = new PageUtil<TuiGuang>();//��ʼ����ҳ������
		List<TuiGuang> list = new ArrayList<TuiGuang>();
		pageUtile.setPageIndex(pageIndex);
		int num = tuiGuangService.pageCountAll();
		pageUtile.setPageNumber(num);
		pageUtile.setPageSize(pageSize);
		pageUtile.setPageCount((int) Math.ceil((double) (pageUtile
                .getPageNumber() / pageUtile.getPageSize())) + 1);//�������ҳ��,����װ��������
		int index = (pageIndex - 1) * pageSize;//�����ÿһҳ�����ݿ��еڼ������ݿ�ʼȡֵ��Ҳ����limit����ĵ�һ������
		list = tuiGuangService.findAllService(index);
		pageUtile.setList(list);
		
		model.addAttribute("pageUtile", pageUtile);
		
		return "login";
	}
	@RequestMapping("upLoad")
	public String tuiGuangController(MultipartFile file,HttpServletRequest request,Model model) throws ParseException {
		if(!file.isEmpty()) {
			//�õ���Ŀ�ڷ������ϵľ���·��
		String path = request.getSession().getServletContext().getRealPath("/");
		String csv_name = file.getOriginalFilename();
		String extensionName = csv_name.substring(csv_name.lastIndexOf(".")+1);
		String newId = UUID.randomUUID().toString();
		String newfile = newId+"."+extensionName;
		try {
			//��Ŀ�ڷ������ϵ�·��/csv(���/csvҪ�Լ�����)
			file.transferTo(new File(path+"/"+newfile));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String csvPath = request.getSession().getServletContext().getRealPath("/")+newfile;
		List<TuiGuang> list = new ArrayList<TuiGuang>();
		list = Csv.readCsv(csvPath);
		for(TuiGuang tuiguang:list) {
			tuiGuangService.insertDataService(tuiguang);
		}
		Csv.deleteFile(csvPath);
		}
		
		
		
		return "success";
	}
	@RequestMapping("conFind")
	public String conFindController(TuiGuang tuiguang,@RequestParam(value="pageIndex",defaultValue="1") int pageIndex,Model model,@RequestParam(value="begin_time",required=false)String begin_time,@RequestParam(value="end_time",required=false)String end_time) {
		int pageSize=10;//����ÿҳ��ʾ���������ݣ������sql����е�limit���������һ��
		PageUtil<TuiGuang> pageUtile = new PageUtil<TuiGuang>();//��ʼ����ҳ������
		List<TuiGuang> list = new ArrayList<TuiGuang>();
		pageUtile.setPageIndex(pageIndex);
		int num = tuiGuangService.conFindCountService(tuiguang,begin_time,end_time).size();
		pageUtile.setPageNumber(num);
		pageUtile.setPageSize(pageSize);
		pageUtile.setPageCount((int) Math.ceil((double) (pageUtile
                .getPageNumber() / pageUtile.getPageSize())) + 1);//�������ҳ��,����װ��������
		int index = (pageIndex - 1) * pageSize;//�����ÿһҳ�����ݿ��еڼ������ݿ�ʼȡֵ��Ҳ����limit����ĵ�һ������
		list = tuiGuangService.conFindService(tuiguang,index,begin_time,end_time);
		pageUtile.setList(list);
		model.addAttribute("pageUtile", pageUtile);
		return "login";
	}
}
