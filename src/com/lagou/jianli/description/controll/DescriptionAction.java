package com.lagou.jianli.description.controll;

import java.io.PrintWriter;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lagou.jianli.description.service.DescriptionService;
import com.lagou.jianli.description.vo.Description;
import com.lagou.jianli.jianli.service.JianliService;
import com.lagou.jianli.jianli.vo.Jianli;

@Controller
public class DescriptionAction {
	@Autowired
	private DescriptionService dservice;
	@Autowired
	private JianliService jservice;
	
	@RequestMapping(value="/addDescription",method=RequestMethod.POST)
	public void add(Model model,PrintWriter out,Description d,@RequestParam("lid")String lid){
		////////////////////////////添加自我描述////////////////////
		dservice.add(d);
		model.addAttribute("d", d);
		
		JSONObject json=new JSONObject();
		json.put("msg",d.getShow());
		json.put("success", true);
		out.print(json);
		
		System.out.println("已执行添加");
		System.out.println(d.getShow());
		
		//////////////////////更新表单/////////////////////////
		int id=Integer.parseInt(lid);
		System.out.println(d.getId());
		Jianli j=new Jianli();
		j.setId(id);
		j.setDid(d.getId());
		jservice.updateDid(j);
		System.out.println("更新成功");
	}
}
