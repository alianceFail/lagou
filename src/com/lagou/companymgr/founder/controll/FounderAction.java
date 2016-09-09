package com.lagou.companymgr.founder.controll;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.lagou.companymgr.founder.service.FounderService;
import com.lagou.companymgr.founder.vo.Founder;
import com.lagou.jianli.message.dao.vo.Message;

@Controller
//@SessionAttributes(value={"f","f1","f2"})
public class FounderAction {
	@Autowired
	private FounderService fservice;
	//private CompanyService cservice;
	@RequestMapping(value="addfounder",method=RequestMethod.POST)
	public String add(String leaderInfos0photo,String leaderInfos0name,String leaderInfos0position,String leaderInfos0weibo,String leaderInfos0remark,
			String leaderInfos1photo,String leaderInfos1name,String leaderInfos1position,String leaderInfos1weibo,String leaderInfos1remark,
			String leaderInfos2photo,String leaderInfos2name,String leaderInfos2position,String leaderInfos2weibo,String leaderInfos2remark,
			Founder f,Founder f1,Founder f2,Model model,PrintWriter out){
		
//		model.addAttribute("f", f);
		f.setFounderphoto(leaderInfos0photo);
		f.setName(leaderInfos0name);
		f.setPosition(leaderInfos0position);
		f.setWeibo(leaderInfos0weibo);
		f.setRemark(leaderInfos0remark);
		fservice.add(f);
		System.out.println("已执行添加");
		
		if(leaderInfos1name!=null){
//			model.addAttribute("f1", f1);
			f1.setFounderphoto(leaderInfos1photo);
			f1.setName(leaderInfos1name);
			f1.setPosition(leaderInfos1position);
			f1.setWeibo(leaderInfos1weibo);
			f1.setRemark(leaderInfos1remark);
			fservice.add(f1);
			System.out.println("已执行添加");
			
		}
		if(leaderInfos2name!=null){
//			model.addAttribute("f2", f2);
			f2.setFounderphoto(leaderInfos2photo);
			f2.setName(leaderInfos2name);
			f2.setPosition(leaderInfos2position);
			f2.setRemark(leaderInfos2remark);
			f2.setWeibo(leaderInfos2weibo);
			fservice.add(f2);
			System.out.println("已执行添加");
		}
		
		
		
		return "index02";
	}
	
	@RequestMapping("/founderupload")
	public void parserUploadFile(Message ms,ModelMap map,MultipartFile file, HttpServletRequest request,PrintWriter out) throws IOException {
		String path = request.getSession().getServletContext().getRealPath("../upload/lagou");
		String fileName = file.getOriginalFilename();
		String newfileName = System.currentTimeMillis() + fileName.substring(fileName.indexOf("."));
		//(int)(Math.random()*1000)+1000
		System.out.println(fileName);
		System.out.println(newfileName);
		Calendar cal = Calendar.getInstance();
		// 如果年的目录不存在，创建年的目录
		int year = cal.get(Calendar.YEAR);
		path = path + "\\" + year;
		//如果月份不存在，创建月份的目录  
		int month=cal.get(Calendar.MONTH)+1;  
		path=path+"\\";  
		if(month<10)  
		{  
			path=path+"0";  
		}  
		path=path+month;
		//生成文件名的日部分  
		int day=cal.get(Calendar.DAY_OF_MONTH);  
		path=path+"\\";  
		if(day<10)  
		{   
			path=path+"0";  
		}  
		path=path+day;  
		
		File targetFile = new File(path, newfileName);
		
		String paths=path.replace("\\", "/");
		int i= paths.indexOf("/upload");
		String pathname =paths.substring(i);
		System.out.println(pathname);
		String img=pathname+"/"+newfileName;
		System.out.println("img:"+img);
		
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		try {
			file.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		System.out.println(targetFile);
		
		
		
		JSONObject json=new JSONObject();
		json.put("img",img);
		json.put("success", true);
		out.print(json);
		
		
	}
	
}
