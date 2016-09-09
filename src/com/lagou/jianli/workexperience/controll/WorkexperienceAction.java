package com.lagou.jianli.workexperience.controll;

import java.io.PrintWriter;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lagou.jianli.jianli.service.JianliService;
import com.lagou.jianli.jianli.vo.Jianli;
import com.lagou.jianli.workexperience.service.WorkexperienceService;
import com.lagou.jianli.workexperience.vo.Workexperience;

@Controller
public class WorkexperienceAction {
	@Autowired
	private WorkexperienceService wservice;
	@Autowired
	private JianliService jservice;
	
	@RequestMapping(value="/addWorkexperience",method=RequestMethod.POST)
	@ResponseBody
	public void add(Model model,PrintWriter out,Workexperience w,@RequestParam("lid")String lid){
		/////////////////////////添加工作经历/////////////////////////
		wservice.add(w);
		model.addAttribute("w", w);
		out.print(JSONObject.fromObject(w).element("success", true));
		System.out.println("已执行添加");
		System.out.println(w.getPositionName());
		
		/////////////////////更新表单//////////////////////////////
		int id=Integer.parseInt(lid);
		Jianli j=new Jianli();
		j.setId(id);
		j.setWid(w.getId());
		jservice.updateWid(j);
		System.out.println("更新完成");
	}
}
