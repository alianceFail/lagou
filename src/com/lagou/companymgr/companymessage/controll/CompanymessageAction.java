package com.lagou.companymgr.companymessage.controll;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.lagou.companymgr.company.dao.service.CompanyService;
import com.lagou.companymgr.company.dao.vo.Company;
import com.lagou.companymgr.companymessage.service.CompanymessageService;
import com.lagou.companymgr.companymessage.vo.Companymessage;
import com.lagou.companymgr.stage.service.StageService;
import com.lagou.companymgr.stage.vo.Stage;
import com.lagou.jianli.message.dao.vo.Message;

@Controller
@SessionAttributes(value="company")
public class CompanymessageAction {
	@Autowired
	private CompanymessageService cservice;
	@Autowired
	private StageService service;
	@Autowired
	private CompanyService ccservice;
	
	@RequestMapping(value="addmessage",method=RequestMethod.POST)
	public String add(Companymessage cm,Company company,Stage s,Model model,PrintWriter out,@RequestParam(value="id",required = false)String id){
//		model.addAttribute("cm", cm);
		cservice.add(cm);
		int mid=cm.getId();
		System.out.println("信息id:"+mid);
		
//		model.addAttribute("s", s);
		s.setMid(mid);
		service.add(s);
		System.out.println(s.getId());
		
		
		model.addAttribute("company", company);
		int cid=Integer.parseInt(id);
		company.setId(cid);
		company.setMid(mid);
		System.out.println(company.getMid());
		System.out.println(company.getLid());
		
		
		ccservice.updateMid(company);
		System.out.println("公司id:"+company.getId());
		
		return "tag";

		
	}
	
	
	@RequestMapping("/logoupload")
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
