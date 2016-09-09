package com.lagou.jianli.jobsub.control;



import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lagou.jianli.jobsub.dao.vo.Jobsub;
import com.lagou.jianli.jobsub.servces.JobsubServce;
@Controller
public class JobsubAction 
{
	@Autowired
	private JobsubServce JobsubServce;
	
	
	
    @RequestMapping(value="/addjobsub",method=RequestMethod.POST)
	public void add(Jobsub j,Model model,PrintWriter out,HttpServletResponse resp)
    {
    	System.out.println(1);
    	model.addAttribute("j", j);
    	JobsubServce.add(j);
//    	resp.reset();
    	System.out.println("Ìí¼Ó³É¹¦");
    	out.print(JSONObject.fromObject(j).element("success", true));
//    	return "redirect:subscribe01";
    }
    
    @RequestMapping(value="/selectjobsub")
    public String query(Model model,Jobsub j,PrintWriter out,@RequestParam("lid")String lid){
    	System.out.println(111);
    	int id=Integer.parseInt(lid);
    	List<Jobsub> jlist=JobsubServce.query(id);
    	model.addAttribute("joblist", jlist);
    	
    	return "subscribe01";
    	
    	
    }
    
    
}
