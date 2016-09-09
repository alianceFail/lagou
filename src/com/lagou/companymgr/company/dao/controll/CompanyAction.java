package com.lagou.companymgr.company.dao.controll;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lagou.companymgr.company.dao.service.CompanyService;
import com.lagou.companymgr.company.dao.vo.Company;
import com.lagou.companymgr.companymessage.service.CompanymessageService;
import com.lagou.companymgr.companymessage.vo.Companymessage;
import com.lagou.companymgr.founder.service.FounderService;
import com.lagou.companymgr.founder.vo.Founder;
import com.lagou.companymgr.job.dao.vo.Job;
import com.lagou.companymgr.job.service.JobService;
import com.lagou.companymgr.label.dao.vo.Label;
import com.lagou.companymgr.label.service.LabelService;
import com.lagou.companymgr.product.service.ProductService;
import com.lagou.companymgr.product.vo.Product;
import com.lagou.companymgr.reported.service.ReportService;
import com.lagou.companymgr.reported.vo.Reported;
import com.lagou.companymgr.stage.service.StageService;
import com.lagou.companymgr.stage.vo.Stage;
import com.lagou.login.user.dao.vo.User;

@Controller
@SessionAttributes(value={"c","cm","label","flist","plist","s","rlist","jlist"})
//@RequestMapping("/CompanyAction")
public class CompanyAction {
	@Autowired
	private CompanyService cservice;
	@Autowired
	private CompanymessageService cmservice;
	@Autowired
	private LabelService lservice;
	@Autowired
	private ProductService pservice;
	@Autowired
	private FounderService fservice;
	@Autowired
	private StageService service;
	@Autowired
	private ReportService rservice;
	@Autowired
	private JobService jservice;
	
	
	
	@RequestMapping(value="updateCompany",method=RequestMethod.POST)
	public String update(Company c,Model model){
		cservice.update(c);
		System.out.println(c.getCompanyProfile());
		System.out.println(c.getId());
		return "success";
	}
	
	@RequestMapping(value="select")
	public String check(Model model,Company c,Label label,Companymessage cm,Stage s,HttpServletResponse resp,HttpServletRequest req){
		HttpSession session=req.getSession();
		User user=(User) session.getAttribute("login");
		System.out.println(user.getId()+"123");
//		System.out.println(lid);
		int lid=user.getId();
		 c=cservice.query(lid);
		 model.addAttribute("c", c);
		System.out.println(c.getId());
		System.out.println("基本信息id:"+c.getMid());
		//////////////////////////基本信息
		int id=c.getMid();
		System.out.println(id+"+++");
		cm=cmservice.query(id);
		model.addAttribute("cm", cm);
		System.out.println(cm.getHolename());
		//////////////////////////其他
		int cid=c.getId();
		System.out.println(cid);
		label=lservice.queryByCompany(cid);
		model.addAttribute("label", label);
		System.out.println(label.getId()+label.getLabels());
		////////////////////////Founder
		List<Founder> flist=fservice.queryByCid(cid);
//		model.addAllAttributes(flist);//????
		model.addAttribute("flist", flist);
		for(Founder f:flist){
			System.out.println(f.getRemark());
		}
		////////////////////Stage
		int mid=c.getMid();
		System.out.println(mid);
		s=service.query(mid);
		model.addAttribute("s", s);
		System.out.println(s.getInvest()+s.getOrg());
		//////////////////Product
		List<Product> plist=pservice.queryByCid(cid);
		model.addAttribute("plist", plist);
		for(Product p:plist){
			System.out.println(p.getProduct());
		}
		
		/////////////////////Reproted////////////////
		List<Reported> rlist=rservice.query(cid);
		model.addAttribute("rlist", rlist);
		for(Reported r:rlist){
			
			System.out.println(r.getArticleTitle());
		}
		///////////////////////职位信息///////////////////////
		List<Job> jlist=jservice.query0();
		model.addAttribute("jlist", jlist);
		for(Job j:jlist){
			System.out.println(j.getPositionAddress());
		}
		
		
		
		return "myhome";
		
	}

}
