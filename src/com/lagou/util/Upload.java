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
 * SpringMVC�е��ļ��ϴ� 
 * 1)����SpringMVCʹ�õ���commons-fileuploadʵ��,������Ҫ�������������Ŀ�� 
 * 2)��SpringMVC�����ļ�������MultipartResolver������(���ڴ˼�����ϴ��ļ�����������) 
 * 3)��Controller�ķ��������MultipartFile����(�ò������ڽ��ձ���file���������) 
 * 4)��дǰ̨��(ע��enctype="multipart/form-data"�Լ�<input type="file" name="****"/>) 
 * PS:��������ʹ����ajaxfileupload.jsʵ����ˢ���ϴ�,�ʱ�����δʹ�ñ� 
 * --------------------------------------------------------------------------------------------- 
 * �����õ������µ�jar 
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
 * @author ����<http://blog.csdn.net/jadyer> 
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
		// ������Ŀ¼�����ڣ��������Ŀ¼
		int year = cal.get(Calendar.YEAR);
		path = path + "\\" + year;
		//����·ݲ����ڣ������·ݵ�Ŀ¼  
		int month=cal.get(Calendar.MONTH)+1;  
		path=path+"\\";  
		if(month<10)  
		{  
			path=path+"0";  
		}  
		path=path+month;
		//�����ļ������ղ���  
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
