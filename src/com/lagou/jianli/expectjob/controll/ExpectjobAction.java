package com.lagou.jianli.expectjob.controll;

import java.io.PrintWriter;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lagou.jianli.expectjob.service.ExpectjobService;
import com.lagou.jianli.expectjob.vo.Expectjob;
import com.lagou.jianli.jianli.service.JianliService;
import com.lagou.jianli.jianli.vo.Jianli;

@Controller
public class ExpectjobAction {
	@Autowired
	private ExpectjobService eservice;
	@Autowired
	private JianliService jservice;
	
	
	
	@RequestMapping(value="/addExpectjob",method=RequestMethod.POST)
	public void add(Model model,PrintWriter out,Expectjob ej,@RequestParam("lid")String lid){
		/////////////////添加期望工作////////////////////////////
		eservice.add(ej);
		System.out.println(ej.getId());
		model.addAttribute("ej", ej);
		out.print(JSONObject.fromObject(ej).element("success", true));
		System.out.println("已执行添加");
		System.out.println(ej.getExpectSalary());
		
	/////////////////////更新表单////////////////////////
		System.out.println(lid);
		int id=Integer.parseInt(lid);
		Jianli j=new Jianli();
		j.setId(id);
		j.setFid(ej.getId());
		jservice.updateFid(j);
		System.out.println("更新完成");
	}
}
