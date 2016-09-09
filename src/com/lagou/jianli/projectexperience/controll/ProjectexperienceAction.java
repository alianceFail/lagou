package com.lagou.jianli.projectexperience.controll;

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
import com.lagou.jianli.projectexperience.service.ProjectexperienceService;
import com.lagou.jianli.projectexperience.vo.Projectexperience;

@Controller
public class ProjectexperienceAction {
	@Autowired
	private ProjectexperienceService pservice;
	@Autowired
	private JianliService jservice;
	
	@RequestMapping(value="/addProjectexperience",method=RequestMethod.POST)
	public void add(Model model,PrintWriter out,Projectexperience pe,@RequestParam("lid")String lid){
		/////////////////////////添加项目经验//////////////////////
		model.addAttribute("pe", pe);
		pservice.add(pe);
		out.print(JSONObject.fromObject(pe).element("success", true));
		System.out.println("已执行添加");
		System.out.println(pe.getProjectName());
		///////////////////////更新表单//////////////////////////
		int id=Integer.parseInt(lid);
		Jianli j=new Jianli();
		j.setId(id);
		j.setPid(pe.getId());
		jservice.updatePid(j);
		System.out.println("更新成功");
	}
	
	
}
