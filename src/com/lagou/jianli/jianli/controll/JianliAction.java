package com.lagou.jianli.jianli.controll;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lagou.jianli.description.service.DescriptionService;
import com.lagou.jianli.description.vo.Description;
import com.lagou.jianli.educationbackground.service.EducationbackgroundService;
import com.lagou.jianli.educationbackground.vo.Educationalbackground;
import com.lagou.jianli.expectjob.service.ExpectjobService;
import com.lagou.jianli.expectjob.vo.Expectjob;
import com.lagou.jianli.jianli.service.JianliService;
import com.lagou.jianli.jianli.vo.Jianli;
import com.lagou.jianli.message.dao.vo.Message;
import com.lagou.jianli.message.servce.MessageServce;
import com.lagou.jianli.projectexperience.service.ProjectexperienceService;
import com.lagou.jianli.projectexperience.vo.Projectexperience;
import com.lagou.jianli.workexperience.service.WorkexperienceService;
import com.lagou.jianli.workexperience.vo.Workexperience;
import com.lagou.jianli.workshow.service.WorksshowService;
import com.lagou.jianli.workshow.vo.Worksshow;
import com.lagou.login.user.dao.vo.User;

@Controller
@SessionAttributes(value={"m","ej","w","pe","eg","d","ws"})
public class JianliAction {
	@Autowired
	private JianliService jservice;
	@Autowired
	private MessageServce mservice;
	@Autowired
	private ExpectjobService ejservice;
	@Autowired
	private WorkexperienceService weservice;
	@Autowired
	private ProjectexperienceService peservice;
	@Autowired
	private EducationbackgroundService edservice;
	@Autowired
	private DescriptionService dservice;
	@Autowired
	private WorksshowService wservice;
	
	
	
	
	
	@RequestMapping(value="/addTiele")
	public void add(Jianli j,Model model,PrintWriter out){
		jservice.update(j);
		System.out.println(j.getId());
		System.out.println(j.getTitle());
		String title=j.getTitle();
		System.out.println(title);
//		model.addAttribute("j", j);
		System.out.println(111);
		
		out.print(JSONObject.fromObject(j).element("success", true));
		/*JSONObject json=new JSONObject();
		json.put("title", title);
		json.put("success", true);
		out.print(json);*/
	}
	
	@RequestMapping(value="Jianliselect",method=RequestMethod.GET)
	public String check(Model model,Jianli j,Message m,Description d,Educationalbackground eg,Expectjob ej,Projectexperience pe,Workexperience w,Worksshow ws,HttpServletResponse resp,HttpServletRequest req){
		HttpSession session=req.getSession();
//		User user=(User) session.getAttribute("login");
//		System.out.println(user.getId()+"123");
		 j=(Jianli) session.getAttribute("j");
		System.out.println(j.getId()+j.getTitle()+"123");
		
		int id=j.getId();
		/////////////////搜索基本信息/////////////////////
		int mid=j.getMid();
		m=mservice.query(mid);
		model.addAttribute("m", m);
		System.out.println(m.getName());
		////////////////搜索期望工作/////////////////////
		int fid=j.getFid();
		ej=ejservice.query(fid);
		model.addAttribute("ej", ej);
		System.out.println(ej.getexpectCity());
		////////////////搜索工作经历////////////////////
		int wid=j.getWid();
		w=weservice.query(wid);
		model.addAttribute("w", w);
		System.out.println(w.getCompanyName());
		/////////////////搜索项目经验//////////////////
		int pid=j.getPid();
		pe=peservice.query(pid);
		model.addAttribute("pe", pe);
		System.out.println(pe.getProjectDescription());
		/////////////////搜索教育背景//////////////////
		int eid=j.getEid();
		eg=edservice.query(eid);
		model.addAttribute("eg", eg);
		System.out.println(eg.getSchoolName());
		/////////////////搜索自我描述//////////////////
		int did=j.getDid();
		d=dservice.query(did);
		model.addAttribute("d", d);
		System.out.println(d.getShow());
		/////////////////搜索作品展示/////////////////
		int wsid=j.getWsid();
		ws=wservice.query(wsid);
		model.addAttribute("ws", ws);
		System.out.println(ws.getWorkshow());
		
		
		
		
		
		return "jianli1";
	}
	
	
}
