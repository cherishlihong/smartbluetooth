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
@Table(name="user")
public class User extends BaseEntity{
 
	private static final long serialVersionUID = -7449698959378940337L;
	private Integer uid;
	private String userName;
	private String userPwd;
	private Role role;
	private String company;
	private String address;
	private Permission permission;

	public User() {
		 
	}

	public User(Integer uid, String userName, String userPwd, Role role, String company, String address,
			Permission permission) {
		 
		this.uid = uid;
		this.userName = userName;
		this.userPwd = userPwd;
		this.role = role;
		this.company = company;
		this.address = address;
		this.permission = permission;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}
	@Column(length=20)
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Column(length=20)
	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
	@ManyToOne(targetEntity=Role.class)
	@JoinColumn(name="rid")
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}
	@Column(length=70)
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Column(length=100)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@ManyToOne(targetEntity=Permission.class)
	@JoinColumn(name="pid")
	public Permission getPermission() {
		return permission;
	}
	
	public void setPermission(Permission permission) {
		this.permission = permission;
	}
 
}
