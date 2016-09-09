package com.lagou.jianli.educationbackground.controll;

import java.io.PrintWriter;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lagou.jianli.educationbackground.service.EducationbackgroundService;
import com.lagou.jianli.educationbackground.vo.Educationalbackground;
import com.lagou.jianli.jianli.service.JianliService;
import com.lagou.jianli.jianli.vo.Jianli;

@Controller
public class EducationbackgroundAction {
	@Autowired
	private EducationbackgroundService es;
	@Autowired
	private JianliService jservice;
	
	@RequestMapping(value="/addEducation",method=RequestMethod.POST)
	public void add(Model model,PrintWriter out,Educationalbackground eg,@RequestParam("lid")String lid){
		////////////////添加教育背景/////////////////////
		es.add(eg);
		model.addAttribute("eg", eg);
		out.print(JSONObject.fromObject(eg).element("success", true));
		System.out.println("已执行添加");
		System.out.println(eg.getprofessionalName());
		
		////////////////更新表单////////////////////////
		int id=Integer.parseInt(lid);
		Jianli j=new Jianli();
		j.setId(id);
		j.setEid(eg.getId());
		jservice.updateEid(j);
		System.out.println("更新完成");	
	}


}
