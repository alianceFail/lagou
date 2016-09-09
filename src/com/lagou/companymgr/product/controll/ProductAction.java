package com.lagou.companymgr.product.controll;

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

import com.lagou.companymgr.product.service.ProductService;
import com.lagou.companymgr.product.vo.Product;
import com.lagou.jianli.message.dao.vo.Message;

@Controller
//@SessionAttributes("p")
public class ProductAction {
	@Autowired
	private ProductService pservice;
	
	@RequestMapping(value="addProduct",method=RequestMethod.POST)
	public String add(String productInfos0productPicUrl,String productInfos0product,String productInfos0productUrl,String productInfos0productProfile,
			String productInfos1productPicUrl,String productInfos1product,String productInfos1productUrl,String productInfos1productProfile,
			String productInfos2productPicUrl,String productInfos2product,String productInfos2productUrl,String productInfos2productProfile,
			Product p,Product p1,Product p2,Model model,PrintWriter out){
		
//		model.addAttribute("p", p);
		p.setProductphoto(productInfos0productPicUrl);
		p.setProduct(productInfos0product);
		p.setProducturl(productInfos0productUrl);
		p.setProductprofile(productInfos0productProfile);
		pservice.add(p);
		System.out.println("以执行添加");
		
		if(productInfos1product!=null){
//			model.addAttribute("p1", p1);
			p1.setProductphoto(productInfos1productPicUrl);
			p1.setProduct(productInfos1product);
			p1.setProducturl(productInfos1productUrl);
			p1.setProductprofile(productInfos1productProfile);
			pservice.add(p1);
			System.out.println("以执行添加");

		}
		if(productInfos2product!=null){
//			model.addAttribute("p2", p2);
			p2.setProductphoto(productInfos2productPicUrl);
			p2.setProduct(productInfos2product);
			p2.setProducturl(productInfos2productUrl);
			p2.setProductprofile(productInfos2productProfile);
			pservice.add(p2);
			System.out.println("以执行添加");

		}
		
		 
		 return "index03";
		 
	}
	
	@RequestMapping("/productupload")
	public void parserUploadFile(ModelMap map,MultipartFile file, HttpServletRequest request,PrintWriter out) throws IOException {
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
