package com.lagou.companymgr.reported.controll;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lagou.companymgr.reported.service.ReportService;
import com.lagou.companymgr.reported.vo.Reported;

@Controller
@SessionAttributes("r")
public class ReportAction {
	@Autowired
	private ReportService rservice;
	
	@RequestMapping(value="addreport",method=RequestMethod.POST)
	public String add(Reported r,Model model,PrintWriter out,HttpServletResponse res){
//		int id=Integer.parseInt(lid);
//		System.out.println(id);
		rservice.add(r);
		model.addAttribute("r", r);
		System.out.println(r.getArticleTitle()+r.getArticleUrl());
//		JSONObject json=new JSONObject();
//		json.put("url", r.getArticleUrl());
//		json.put("title", r.getArticleTitle());
//		json.put("success", true);
//		out.print(json);
//		
//		return "redirect:/CompanyAction/select";
//		return "redirect:/select?lid="+id;
		return "redirect:/select";
		
	}
}
