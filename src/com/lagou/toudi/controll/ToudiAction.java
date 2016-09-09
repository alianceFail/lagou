package com.lagou.toudi.controll;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lagou.companymgr.company.dao.service.CompanyService;
import com.lagou.companymgr.company.dao.vo.Company;
import com.lagou.companymgr.companymessage.service.CompanymessageService;
import com.lagou.companymgr.companymessage.vo.Companymessage;
import com.lagou.companymgr.job.dao.vo.Job;
import com.lagou.companymgr.job.service.JobService;
import com.lagou.jianli.educationbackground.service.EducationbackgroundService;
import com.lagou.jianli.educationbackground.vo.Educationalbackground;
import com.lagou.jianli.jianli.service.JianliService;
import com.lagou.jianli.jianli.vo.Jianli;
import com.lagou.jianli.message.dao.vo.Message;
import com.lagou.jianli.message.servce.MessageServce;
import com.lagou.jianli.workexperience.service.WorkexperienceService;
import com.lagou.jianli.workexperience.vo.Workexperience;
import com.lagou.toudi.service.ToudiService;
import com.lagou.toudi.vo.Toudi;


@Controller
public class ToudiAction {
	@Autowired
	private ToudiService tservice;
	@Autowired
	private JobService jservice;
	@Autowired
	private JianliService jianService;
	@Autowired
	private MessageServce mservice;
	@Autowired
	private CompanyService cservice;
	@Autowired
	private CompanymessageService cmservice;
	@Autowired
	private EducationbackgroundService eservice;
	@Autowired
	private WorkexperienceService wservice;
	
	@RequestMapping(value="/addtoudi")
	public void add(Toudi t,Model model,PrintWriter out,HttpServletRequest req){
		tservice.add(t);
		System.out.println(t.getJid()+t.getId());
		model.addAttribute("t", t);
		out.print(JSONObject.fromObject(t).element("success", true));
	}
	
	@RequestMapping(value="/queryState")
	public String query(Model model,PrintWriter out,HttpServletRequest req){
		List<Toudi> tlist=tservice.query0();
		model.addAttribute("tlist", tlist);
		System.out.println(tlist.size());
		for(Toudi toudi:tlist){
			int bid=toudi.getBid();
			Job job=jservice.queryjob(bid);
			model.addAttribute("job", job);
			int cid=job.getCid();
			Company c=cservice.queryById(cid);
			int cmid=c.getMid();
			Companymessage cm=cmservice.query(cmid);
			model.addAttribute("cm", cm);
			int jid=toudi.getJid();
			Jianli jianli=jianService.queryid(jid);
			model.addAttribute("jianli", jianli);
			int mid=jianli.getMid();
			Message m=mservice.query(mid);
			model.addAttribute("message", m);
			int eid=jianli.getEid();
			Educationalbackground e=eservice.query(eid);
			model.addAttribute("education", e);
			int wid=jianli.getWid();
			Workexperience w=wservice.query(wid);
			model.addAttribute("work",w);
		}
		int x=0;
		int a=tservice.count(x);
		System.out.println(a);
		model.addAttribute("count", a);
		System.out.println("²éÑ¯Íê³É£¡");
		return "pedingResume";
	}

	
	
	
	
	
}
