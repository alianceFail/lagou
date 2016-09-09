package com.lagou.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.lagou.jianli.message.dao.vo.Message;
import com.lagou.jianli.message.servce.MessageServce;

 
  
/** 
 * SpringMVC中的文件上传 
 * 1)由于SpringMVC使用的是commons-fileupload实现,所以先要将其组件引入项目中 
 * 2)在SpringMVC配置文件中配置MultipartResolver处理器(可在此加入对上传文件的属性限制) 
 * 3)在Controller的方法中添加MultipartFile参数(该参数用于接收表单中file组件的内容) 
 * 4)编写前台表单(注意enctype="multipart/form-data"以及<input type="file" name="****"/>) 
 * PS:由于这里使用了ajaxfileupload.js实现无刷新上传,故本例中未使用表单 
 * --------------------------------------------------------------------------------------------- 
 * 这里用到了如下的jar 
 * commons-io-2.4.jar 
 * commons-fileupload-1.3.jar 
 * commons-logging-1.1.2.jar 
 * spring-aop-3.2.4.RELEASE.jar 
 * spring-beans-3.2.4.RELEASE.jar 
 * spring-context-3.2.4.RELEASE.jar 
 * spring-core-3.2.4.RELEASE.jar 
 * spring-expression-3.2.4.RELEASE.jar 
 * spring-jdbc-3.2.4.RELEASE.jar 
 * spring-oxm-3.2.4.RELEASE.jar 
 * spring-tx-3.2.4.RELEASE.jar 
 * spring-web-3.2.4.RELEASE.jar 
 * spring-webmvc-3.2.4.RELEASE.jar 
 * --------------------------------------------------------------------------------------------- 
 * @create Sep 14, 2013 5:06:09 PM 
 * @author 玄玉<http://blog.csdn.net/jadyer> 
 */  
@Controller
@SessionAttributes("m")
public class Upload {
	@Autowired
	private MessageServce mservice;
	
	@RequestMapping("/upload")
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
		
		Message m1=(Message)map.get("m");
		ms.setId(m1.getId());
		mservice.update(ms);
		System.out.println(ms.getId());
		
		
		JSONObject json=new JSONObject();
		json.put("img",img);
		json.put("success", true);
		out.print(json);
		
		
	}
}
