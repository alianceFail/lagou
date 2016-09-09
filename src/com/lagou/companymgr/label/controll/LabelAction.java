package com.lagou.companymgr.label.controll;

import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lagou.companymgr.label.dao.vo.Label;
import com.lagou.companymgr.label.service.LabelService;

@Controller
@SessionAttributes("label")
public class LabelAction {
    @Autowired
	private LabelService lService;
    
    @RequestMapping(value="/addLabel")
    @ResponseBody
    public void add(Label l,Model model,PrintWriter out,String labels,int companyId)
    {
    	
    	//System.out.println(labels);
    	model.addAttribute("label",l);
    	
    	/*System.out.println("id:"+l.getId());
    	System.out.println("labels:"+labels);
    	System.out.println("cid:"+l.getCid());
    	System.out.println("companyid:"+companyId);*/
    	
    
    	if("".equals(labels)){
    		out.print(false);
    	}else
    	{
    	l.setCid(companyId);
    	System.out.println("cid:"+l.getCid());
    	lService.add(l);
    	
    	out.print(true);
    	}
    }
}
