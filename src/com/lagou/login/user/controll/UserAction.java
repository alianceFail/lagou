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
				out.println("<script type='text/javascript'>alert('����ɹ�����ӭʹ�������������ƹ�˾��Ϣ');location='index01.jsp';</script>");
				
			}
			if(user.getType()==0){
				//����������ʼ����Ϣ
				Jianli j=new Jianli();
				j.setLid(user.getId());
				jservice.add(j);
				model.addAttribute("j", j);
				System.out.println(j.getId());
				out.println("<script type='text/javascript'>alert('����ɹ�����ӭʹ�������������Ƹ�����Ϣ');location='jianli.jsp';</script>");
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
			m.setSubject("������-�����˺�");
			m.setMessage("�𾴵�"+user.getAccount()+"��ã���ӭע�������������ǽ��߳�Ϊ����������<a href=\"http://localhost:8088/lagou/jihuo.jsp\">���Ｄ��</a>,ллʹ�á�");
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
		
		out.println("<script type='text/javascript'>alert('�����޸ĳɹ�����������¼');location='login.html';</script>");
		
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
				System.out.println("��ѯ���");
			}
			
			
			
			
			
			if(u.getType()==1)
			{
				Company c=cservice.query(lid);
				model.addAttribute("c", c);
				if("0".equals(c.getCompanyProfile())){
					System.out.println("�жϳɹ�");
					out.print("index01");
				}
				else{
					System.out.println("�ж�ʧ��");
					out.print("index");
				}
				
			}
			System.out.println("�����ж�");
			if(u.getType()==0)
			{
				Jianli jian=jservice.query(lid);
				model.addAttribute("j", jian);
				if(jian.getTitle()==null){
					System.out.println("�жϳɹ�");
					out.print("jianli");
				}else{
					System.out.println("�ж�ʧ��");
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
		m.setSubject("������-��������");
		m.setMessage("�װ���"+email+"�û�,"+macth+"��������֤�롣����5��������֤����Ǳ��˲������������޸ĸ������롣");
		
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
					
					out.println("<script type='text/javascript'>alert('��֤��������󣡣�');history.back();</script>");
//					resp.sendRedirect("reset.html");
//					out.print("2");
				}
			}
		}else{	
			out.println("<script type='text/javascript'>alert('����֤���ѹ��ڣ���');history.back();</script>");
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
	//	out.println("<script type='text/javascript'>alert('�����޸ĳɹ������µ�¼');location='login.html';</script>");
//		resp.sendRedirect("login.html");
		
	}
	
	
	
}
