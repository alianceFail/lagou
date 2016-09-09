package com.lagou.companymgr.bind.controll;

import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lagou.companymgr.bind.dao.vo.Bind;
import com.lagou.companymgr.bind.service.BindService;
import com.lagou.login.user.email.Mail;
import com.lagou.util.MailUtil;

@Controller
@SessionAttributes("b")
public class BindAction {
	@Autowired
	private BindService bservice;
	
	@RequestMapping(value="/addbind")
	public String add(Bind b,Model model,PrintWriter out,String tel,String email) 
	{  
		
		model.addAttribute("bind", b);	
		System.out.println(b.getEmail()+b.getTel());
		tel=b.getTel();
		email=b.getEmail();
		model.addAttribute("tel", tel);	
		model.addAttribute("email", email);	
		return "bindStep2";
	}
	
	@RequestMapping(value="/addbind2")
	public String add2(Bind b,Model model,PrintWriter out ,String email)
	{
		System.out.println(b.getHoleName());
		System.out.println(b.getCid());
		email=b.getEmail();
		model.addAttribute("email", email);
		boolean c=bservice.addbind(b);
		model.addAttribute("b", b);
		if(c){
			Mail m=new Mail();
			MailUtil mu=new MailUtil();
			
			m.setReceiver(email);
			m.setSubject("拉勾网-激活账号");
			m.setMessage("尊敬的"+email+"你好，欢迎注册拉勾网！我们将竭诚为您服务，请点击<a href=\"http://localhost:8088/lagou/create.jsp\">这里进行职位发布</a>,谢谢使用。");
			mu.send(m);
		}
		return "bindStep3";
	}
	
	@RequestMapping(value="/delbind")
	public void delbind(int id,Model model,PrintWriter out)
	{
		
		model.addAttribute("id", id);
		System.out.println(id);
		boolean b=bservice.delbind(id);
		if(b){
			out.println("<script type='text/javascript'>alert('success!');location.href='bindStep1.jsp';	</script>");;
		}
	}
}
