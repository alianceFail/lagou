package com.lagou.companymgr.job.controll;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.lagou.jianli.jianli.service.JianliService;
import com.lagou.jianli.jianli.vo.Jianli;
import com.lagou.login.user.dao.vo.User;


@Controller
public class JobAction {
	@Autowired
	private JobService jService;
	@Autowired
	private CompanyService cservice;
	@Autowired
	private CompanymessageService cmservice;
	@Autowired
	private JianliService jianservice;
	
	
	
	
	
	
	@RequestMapping(value="/addJob")
	public void add(Job j,Model model,PrintWriter out) 
	{  
		System.out.println(j.getCid());
		System.out.println(j.getPositionType()+j.getPositionName()+j.getDepartment()+j.getJobNature()+j.getSalaryMin()+j.getSalaryMax());
		System.out.println(j.getWorkAddress()+j.getWorkYear()+j.getEducation()+j.getPositionAdvantage()+j.getPositionAddress()+j.getEmail());
		
		System.out.println("controll");
		
		boolean b=jService.add(j);
		model.addAttribute("job", j);
		if(b){
			out.println("<script type='text/javascript'>alert('success!');location.href='positions0.jsp';	</script>");;
		}
	}
	
	@RequestMapping(value="/query0")
	public String query0(Job j,Model model)
	{
		List<Job> list0= jService.query0();
		model.addAttribute("list0", list0);
		int countjob0=jService.countjob0();
		model.addAttribute("countjob0", countjob0);
		return "positions0";	
	}
	
	@RequestMapping(value="/query1")
	public String query1(Job j,Model model)
	{
		List<Job> list1= jService.query1();
		model.addAttribute("list1", list1);
		int countjob1=jService.countjob1();
		model.addAttribute("countjob1", countjob1);
		return "positions1";	
	}
	
	@RequestMapping(value="/updatexiaxian")
	public void updatexiaxian(int id,Model model,PrintWriter out)
	{
		
		model.addAttribute("id", id);
		boolean b=jService.updatexiaxian(id);
		if(b){
			out.println("<script type='text/javascript'>alert('success!');location.href='query0';	</script>");;
		}
	}
	
	@RequestMapping(value="/updateshangxian")
	public void updateshangxian(int id,Model model,PrintWriter out)
	{
		
		model.addAttribute("id", id);
		boolean b=jService.updateshangxian(id);
		if(b){
			out.println("<script type='text/javascript'>alert('success!');location.href='query0';	</script>");;
		}
	}
	
	@RequestMapping(value="/del")
	public void del(int id,Model model,PrintWriter out)
	{
		
		model.addAttribute("id", id);
		boolean b=jService.del(id);
		if(b){
			out.println("<script type='text/javascript'>alert('success!');location.href='query0';	</script>");;
		}
	}
	
	@RequestMapping(value="/toupdatejob")
	public String toupdatejob(int id,Job j,Model model,PrintWriter out)
	{
		model.addAttribute("id", id);
		j=jService.queryjob(id);
		model.addAttribute("j", j);
		return "create1";
	}
	
	@RequestMapping(value="/updatejob")
	public void updatejob(int id,Job j,Model model,PrintWriter out)
	{
		model.addAttribute("j", j);
		boolean b=jService.updatejob(j);
		if(b){
			out.println("<script type='text/javascript'>alert('success!');location.href='query0';	</script>");;
		}
	}
	
	@RequestMapping(value="/querybyjob")
	public String querybyjob(Job j,Model model)
	{
		System.out.println(j.getPositionName());
		List<Job> list= jService.querybyjob(j);
		System.out.println("list:"+list.size());
		
		model.addAttribute("list", list);
		return "list";
	}
	
	@RequestMapping(value="/selectjob")
	public String queryById(Model model,Job j,int id,HttpServletRequest req){
		j=jService.queryjob(id);
		model.addAttribute("j", j);
		System.out.println(j.getDepartment());
		int cid=j.getCid();
		Company c=cservice.queryById(cid);
		System.out.println(c.getMid());
		int mid=c.getMid();
		Companymessage cm=cmservice.query(mid);
		System.out.println(cm.getCity()+cm.getHolename());
		model.addAttribute("cm", cm);
		
		HttpSession session=req.getSession();
		User user=(User)session.getAttribute("login");
		int lid=user.getId();
		Jianli jian=jianservice.query(lid);
		model.addAttribute("jian", jian);
		System.out.println(jian.getTitle());
		
		return "toudi";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

