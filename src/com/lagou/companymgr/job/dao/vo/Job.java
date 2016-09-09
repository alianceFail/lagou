package com.lagou.companymgr.job.dao.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.lagou.companymgr.company.dao.vo.Company;

public class Job {
    private Integer id;
    
    private int cid;

    private String positionType;

    private String positionName;
    
    private String department;
		

    private String jobNature;
    
    
    private int salaryMin;
    
    private int salaryMax;


    private String workYear;

    private String positionAdvantage;

    private String education;

    private String positionAddress;

    private String email;

    private String workAddress;

    private Company c;
    
    private String positionDetail;
    
    @DateTimeFormat(pattern="YYYY-MM-DD")
    private Date date;

	private int xiaxian;
	
	private int count;

	public String getPositionType() {
		return positionType;
	}

	public void setPositionType(String positionType) {
		this.positionType = positionType;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getJobNature() {
		return jobNature;
	}

	public void setJobNature(String jobNature) {
		this.jobNature = jobNature;
	}

	public int getSalaryMin() {
		return salaryMin;
	}

	public void setSalaryMin(int salaryMin) {
		this.salaryMin = salaryMin;
	}

	public int getSalaryMax() {
		return salaryMax;
	}

	public void setSalaryMax(int salaryMax) {
		this.salaryMax = salaryMax;
	}



	public void setWorkAddress(String workAddress) {
		this.workAddress = workAddress;
	}

	public String getWorkYear() {
		return workYear;
	}

	public void setWorkYear(String workYear) {
		this.workYear = workYear;
	}

	public String getPositionAdvantage() {
		return positionAdvantage;
	}

	public void setPositionAdvantage(String positionAdvantage) {
		this.positionAdvantage = positionAdvantage;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getPositionAddress() {
		return positionAddress;
	}

	public void setPositionAddress(String positionAddress) {
		this.positionAddress = positionAddress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWorkAddress() {
		return workAddress;
	}

	public void setWorkaddress(String workAddress) {
		this.workAddress = workAddress;
	}

	public Company getC() {
		return c;
	}

	public void setC(Company c) {
		this.c = c;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPositionDetail() {
		return positionDetail;
	}

	public void setPositionDetail(String positionDetail) {
		this.positionDetail = positionDetail;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getXiaxian() {
		return xiaxian;
	}

	public void setXiaxian(int xiaxian) {
		this.xiaxian = xiaxian;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

   
   
}