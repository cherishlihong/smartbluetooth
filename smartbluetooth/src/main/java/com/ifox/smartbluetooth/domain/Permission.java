package com.ifox.smartbluetooth.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="permission")
public class Permission extends BaseEntity{

	private static final long serialVersionUID = 7571480910394369392L;
	private Integer pid;
	private String permissName;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	@Column(length=10)
	public String getPermissName() {
		return permissName;
	}
	public void setPermissName(String permissName) {
		this.permissName = permissName;
	}

}
