package com.ifox.smartbluetooth.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="application")
public class Application extends BaseEntity{
	
	private static final long serialVersionUID = 2359100719645138523L;
    
	private Integer appid;
	private User user;
	private String reason;
	private String applicant;//申请人
	private String telephone;//申请人电话
	private String openAddress;//开门地址
	private Integer openCount;//开门次数
	private String openTime;//开门时间
	private String leaveTime;//结束时间
	private String openCompany;//单位名称

	private boolean flag;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getAppid() {
		return appid;
	}
	public void setAppid(Integer appid) {
		this.appid = appid;
	}
	 @Column(length=70)
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	@Column(length=11)
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	 
	@Column(length=70)
	public String getOpenAddress() {
		return openAddress;
	}
	public void setOpenAddress(String openAddress) {
		this.openAddress = openAddress;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	@ManyToOne
	@JoinColumn(name="uid")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Column(length=15)
	public String getApplicant() {
		return applicant;
	}
	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}
	public Integer getOpenCount() {
		return openCount;
	}
	public void setOpenCount(Integer openCount) {
		this.openCount = openCount;
	}
	@Column(length=30)
	public String getOpenTime() {
		return openTime;
	}
	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}
	@Column(length=30)
	public String getLeaveTime() {
		return leaveTime;
	}
	public void setLeaveTime(String leaveTime) {
		this.leaveTime = leaveTime;
	}
	@Column(length=70)
	public String getOpenCompany() {
		return openCompany;
	}
	public void setOpenCompany(String openCompany) {
		this.openCompany = openCompany;
	}
	
}
