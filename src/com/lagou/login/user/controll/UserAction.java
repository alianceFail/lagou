package com.lagou.login.user.controll;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
import com.lagou.jianli.jianli.dao.JianliMapper;
import com.lagou.jianli.jianli.vo.Jianli;
import com.lagou.login.user.dao.vo.User;
import com.lagou.login.user.email.Mail;
import com.lagou.login.user.service.UserService;
import com.lagou.util.MD5;
import com.lagou.util.MailUtil;


@Controller
@SessionAttributes(value={"login","user","j","c","joblist","cmessage","founderlist","label"})
public class UserAction {
	@Autowired
	private UserService uService;
	@Autowired
	private CompanyService cservice;
	@Autowired
	private JianliMapper jservice;
	@Autowired
	private JobService jobservice;
	@Autowired
	private CompanymessageService cmservice;
	@Autowired
	private FounderService fservice;
	@Autowired
	private LabelService lservice;
	
	
	
	
	@RequestMapping(value="/addUser")
	public void add(HttpServletRequest req,HttpServletResponse resp,Model model) throws Exception{

		System.out.println("haha");
		PrintWriter out=resp.getWriter();
		resp.setContentType("text/html; charset=UTF-8");
		
			HttpSession session=req.getSession();
			User user=(User) session.getAttribute("user");
//			String pass=MD5.shaEncode(user.getPass());
//			user.setPass(pass);
			System.out.println(user.getId()+user.getPass());
			uService.add(user);
			session.invalidate();
			if(user.getType()!=null){
				model.addAttribute("login",user);
			if(user.getType()==1){
				Company c=new Company();
				c.setLid(user.getId());
				cservice.add(c);
				model.addAttribute("c", c);
				System.out.println(c.getId());
				out.println("<script type='text/javascript'>alert('激活成功！欢迎使用拉钩！请完善公司信息');location='index01.jsp';</script>");
				
			}
			if(user.getType()==0){
				//建立简历初始化信息
				Jianli j=new Jianli();
				j.setLid(user.getId());
				jservice.add(j);
				model.addAttribute("j", j);
				System.out.println(j.getId());
				out.println("<script type='text/javascript'>alert('激活成功！欢迎使用拉钩！请完善个人信息');location='jianli.jsp';</script>");
			}
		}
	}
		
	
	@RequestMapping(value="/setMail01")
	public void setMail01(User user,PrintWriter out,HttpServletRequest req,HttpServletResponse resp,Model model) throws Exception{
		User us=uService.queryByAccount(user.getAccount());
		
		if(us==null)
		{
			String pass=MD5.shaEncode(user.getPass());
			user.setPass(pass);
			System.out.println(user.getPass()+"+++");
			System.out.println(user.getAccount()+"123");
			HttpSession session=req.getSession();
			session.setAttribute("user",user);
			model.addAttribute("user", user);
			
			
//			model.addAttribute("u", u1);
			Mail m=new Mail();
			MailUtil mu=new MailUtil();
			
			m.setReceiver(user.getAccount());
			m.setSubject("拉勾网-激活账号");
			m.setMessage("尊敬的"+user.getAccount()+"你好，欢迎注册拉勾网！我们将竭诚为您服务，请点击<a href=\"http://localhost:8088/lagou/jihuo.jsp\">这里激活</a>,谢谢使用。");
			mu.send(m);
			
			out.print("success");
		}else
		{
			out.print("fail");
			
		}
	}
	
	@RequestMapping(value="/email")
	public void email(String email,HttpServletRequest req,PrintWriter out){
		User u=uService.queryByAccount(email);
		if(u==null)
		{
			out.print("yes");
		}else
		{
			out.print("no");
		}

	}
	
	@RequestMapping(value="/rePass01")
	public void rePass01(User u,HttpServletRequest req,HttpServletResponse resp) throws Exception{
		
		String pass=new MD5().shaEncode(u.getPass());
		u.setPass(pass);
		PrintWriter out=resp.getWriter();
		resp.setContentType("text/html; charset=UTF-8");
		uService.updatePass(u);
		
		out.println("<script type='text/javascript'>alert('密码修改成功！！立即登录');location='login.html';</script>");
		
//		resp.sendRedirect("login.html");
		
	}
	
	@RequestMapping(value="/logine")
	public void login(String account,String pass,PrintWriter out,HttpServletRequest req,Model model) throws Exception{
		
		User u=uService.queryByAccount(account);	
		System.out.println(u.getAccount());
		HttpSession session=req.getSession();
		System.out.println(MD5.shaEncode(pass)+"+++"+pass);
		System.out.println(u.getPass());
		
		if(u!=null && MD5.shaEncode(pass).equals(u.getPass()))
		{
			model.addAttribute("login", u);
			session.setAttribute("login", u);
			System.out.println("success");
			int lid=u.getId();
			System.out.println(lid);
			
			List<Job> joblist=jobservice.queryAll();
			model.addAttribute("joblist", joblist);
			for(Job job:joblist){
				System.out.println(job.getCid());
				int cid=job.getCid();
				Company c1=cservice.queryById(cid);
				int mid1=c1.getMid();
				Companymessage cm= cmservice.query(mid1);
				model.addAttribute("cmessage", cm);
				System.out.println(cm.getHolename());
				List<Founder> founderlist=fservice.queryByCid(cid);
				model.addAttribute("founderlist",founderlist);
				for(Founder f:founderlist){
					System.out.println(f.getName());
				}
				Label l=lservice.queryByCompany(cid);
				model.addAttribute("label", l);
				System.out.println(l.getLabels());
				System.out.println("查询完成");
			}
			
			
			
			
			
			if(u.getType()==1)
			{
				Company c=cservice.query(lid);
				model.addAttribute("c", c);
				if("0".equals(c.getCompanyProfile())){
					System.out.println("判断成功");
					out.print("index01");
				}
				else{
					System.out.println("判断失败");
					out.print("index");
				}
				
			}
			System.out.println("进入判断");
			if(u.getType()==0)
			{
				Jianli jian=jservice.query(lid);
				model.addAttribute("j", jian);
				if(jian.getTitle()==null){
					System.out.println("判断成功");
					out.print("jianli");
				}else{
					System.out.println("判断失败");
					out.print("index");
				}
			}	
//			out.print("index");
//			out.print("index");
//			out.print("index");
		}else
		{
			out.print("error");
		}			
	}
	

	

	public void update(User u){
		
	}
	public List<User>queryAll(){
		return null;
		
	}
	
	@RequestMapping(value="/setMail")
	public void setMail(String email,PrintWriter out,HttpServletRequest req,HttpServletResponse resp){
		Mail m=new Mail();
		MailUtil mu=new MailUtil();
		int macth=new Random().nextInt(999999);
		Cookie ck=new Cookie("macth", String.valueOf(macth));
		ck.setMaxAge(300);
		ck.setPath("/");
		resp.addCookie(ck);
		
		m.setReceiver(email);
		m.setSubject("拉钩网-密码重置");
		m.setMessage("亲爱的"+email+"用户,"+macth+"是您的验证码。请在5分钟内验证，如非本人操作，请立即修改个人密码。");
		
		 mu.send(m);
	}
	

	
	@RequestMapping(value="/exit")
	public String exit(String account,HttpServletRequest req,HttpServletResponse resp) throws IOException{
		
		HttpSession session=req.getSession();
			session.invalidate();
//		System.out.println("haha"+session.getValue("u"));
		return ("login");
	}
	
	@RequestMapping(value="/repass")
	public String repass(String match,String email,HttpServletRequest req,HttpServletResponse resp) throws IOException{
		
		Cookie[] c=req.getCookies();
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out=resp.getWriter();
		
		if(c !=null)
		{
			for(Cookie cr:c)
			{
				String em=cr.getValue();
				if(em.equals(match))
				{
					req.setAttribute("account", email);
					return "rePasse";
//					out.print("3");
				}else
				{
					
					out.println("<script type='text/javascript'>alert('验证码输入错误！！');history.back();</script>");
//					resp.sendRedirect("reset.html");
//					out.print("2");
				}
			}
		}else{	
			out.println("<script type='text/javascript'>alert('此验证码已过期！！');history.back();</script>");
//			resp.sendRedirect("reset.html");
		
			return null;
		}
		return null;	
	}
	
	
	
	@RequestMapping(value="/updatePwd01")
	public void updatePwd01(String oldpassword,HttpServletRequest req,HttpServletResponse resp,PrintWriter out) throws Exception{
		HttpSession session=req.getSession();
		User u=(User) session.getAttribute("login");
		String pass=u.getPass();
		String oldpass=MD5.shaEncode(oldpassword);
		
		if(pass.equals(oldpass))
		{
			out.print("true");
		}else
		{
			out.print("error");
		}			
	}
	
	@RequestMapping(value="/updatePwd02")
	public void updatePwd02(String password,HttpServletRequest req,HttpServletResponse resp,PrintWriter out) throws Exception{
		HttpSession session=req.getSession();
		User u=(User) session.getAttribute("login");
		String pass=MD5.shaEncode(password);
		u.setPass(pass);
		uService.updatePass(u);
		session.invalidate();
		out.print("ok");
	//	out.println("<script type='text/javascript'>alert('密码修改成功！重新登录');location='login.html';</script>");
//		resp.sendRedirect("login.html");
		
	}
	
	
	
}
