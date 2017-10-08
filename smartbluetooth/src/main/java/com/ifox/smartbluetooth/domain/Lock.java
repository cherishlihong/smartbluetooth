package com.ifox.smartbluetooth.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mylock")
public class Lock extends BaseEntity{

	private static final long serialVersionUID = -8225938235180854605L;
	private Integer lid;
	private String lockkey;
	private String lockAddress;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getLid() {
		return lid;
	}
	public void setLid(Integer lid) {
		this.lid = lid;
	}
	@Column(length=30)
	public String getLockkey() {
		return lockkey;
	}
	public void setLockkey(String lockkey) {
		this.lockkey = lockkey;
	}
	
	@Column(length=70)
	public String getLockAddress() {
		return lockAddress;
	}
	
	public void setLockAddress(String lockAddress) {
		this.lockAddress = lockAddress;
	}
	
}
