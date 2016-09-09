package com.lagou.jianli.workshow.controll;

import java.io.PrintWriter;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lagou.jianli.jianli.service.JianliService;
import com.lagou.jianli.jianli.vo.Jianli;
import com.lagou.jianli.workshow.service.WorksshowService;
import com.lagou.jianli.workshow.vo.Worksshow;

@Controller
public class WorksshowAction {
	@Autowired
	private WorksshowService wservice;
	@Autowired
	private JianliService jserviec;
	@RequestMapping(value="/addWorksshow",method=RequestMethod.POST)
	public void add(Model model,PrintWriter out,Worksshow ws,@RequestParam("lid")String lid){
		/////////////////////////添加作品展示///////////////////////
		wservice.add(ws);
		model.addAttribute("ws", ws);
		JSONObject json=new JSONObject();
		json.put("link",ws.getWorklink());
		json.put("msg", ws.getWorkshow());
		json.put("success", true);
		out.print(json);
		
		System.out.println("已执行添加");
		System.out.println(ws.getWorkshow());
		
		//////////////////////////更新表单//////////////////////////
		int id=Integer.parseInt(lid);
		Jianli j=new Jianli();
		j.setId(id);
		j.setWsid(ws.getId());
		jserviec.updateWsid(j);
		System.out.println("更新成功");
	}

}
