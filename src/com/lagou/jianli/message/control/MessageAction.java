package com.lagou.jianli.message.control;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lagou.jianli.jianli.service.JianliService;
import com.lagou.jianli.jianli.vo.Jianli;
import com.lagou.jianli.message.dao.vo.Message;
import com.lagou.jianli.message.servce.MessageServce;
@Controller
@SessionAttributes("m")
public class MessageAction {
	@Autowired
   private MessageServce ms;
	@Autowired
	private JianliService jservice;
	
	
	@RequestMapping(value="/addmessage1")
	@ResponseBody
   public void add(Message m,Model model,PrintWriter out,HttpServletRequest req,@RequestParam("lid")String lid)
   {   
       //String name=request.getParameters("name");
	/////////////////////添加///////////////////////
	   ms.add(m);
	   model.addAttribute("m", m);
	   System.out.println(m.getTopDegree()+"====="+m.getName()+"====="+m.getTel()+"======"+m.getId());
	   out.print(JSONObject.fromObject(m).element("success", true));
	   /////////////////////////更新////////////////////////
	   int id=Integer.parseInt(lid);
	   System.out.println(id);
	   Jianli j=new Jianli();
	   j.setId(id);
	   j.setMid(m.getId());
	   jservice.updateMid(j);
	   System.out.println(j.getMid());
	   System.out.println("更新成功");
	   
	   
	   
	   
   }
	
//	@RequestMapping(value="/Upload")
//	@ResponseBody
//	public void parserUploadFile(PrintWriter out,Message m,ModelMap model, @RequestParam("photo")MultipartFile file, HttpServletRequest request) throws IOException {
//		String path = request.getSession().getServletContext().getRealPath("../Upload/images");
//		String fileName = file.getOriginalFilename();
//		String newfileName = System.currentTimeMillis() + fileName.substring(fileName.indexOf("."));
//		//(int)(Math.random()*1000)+1000
//		
//		System.out.println(fileName+"||"+file);
//		Calendar cal = Calendar.getInstance();
//		// 如果年的目录不存在，创建年的目录
//		int year = cal.get(Calendar.YEAR);
//		path = path + "\\" + year;
//		//如果月份不存在，创建月份的目录  
//		int month=cal.get(Calendar.MONTH)+1;  
//		path=path+"\\";  
//		if(month<10)  
//		{  
//			path=path+"0";  
//		}  
//		path=path+month;
//		//生成文件名的日部分  
//		int day=cal.get(Calendar.DAY_OF_MONTH);  
//		path=path+"\\";  
//		if(day<10)  
//		{    
//			path=path+"0";  
//		}  
//		path=path+day;  
//		
//		File targetFile = new File(path, newfileName);
//		
//		String paths=path.replace("\\", "/");
//		int i= paths.indexOf("/Upload");
//		String pathname =paths.substring(i);
//		String img=pathname+"/"+newfileName;
//		
//		if (!targetFile.exists()) {
//			targetFile.mkdirs();
//		}
//		try {
//			file.transferTo(targetFile);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		Message me=(Message)model.get("m");
//		System.out.println(me.getId());
//		m.setId(me.getId());
//		
//		ms.update(m);
//		
//		
//		JSONObject json=new JSONObject();
//		json.put("img", img);
//		json.put("success", true);
//		out.print(json);
//		
//		System.out.println(img);
//	}
	
	
}
