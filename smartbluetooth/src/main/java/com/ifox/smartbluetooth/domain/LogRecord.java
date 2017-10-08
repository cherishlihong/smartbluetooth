package com.ifox.smartbluetooth.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="logRecord")
public class LogRecord extends BaseEntity{

	private static final long serialVersionUID = -5626760911441345339L;
	private Integer logid;
	private User user;
	private Lock lock;
	private String  openDoorTime;
	private String openEndTime;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getLogid() {
		return logid;
	}
	public void setLogid(Integer logid) {
		this.logid = logid;
	}
	@ManyToOne(targetEntity=User.class)
	@JoinColumn(name="uid")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@OneToOne(targetEntity=Lock.class)
	@JoinColumn(name="lid")
	public Lock getLock() {
		return lock;
	}
	public void setLock(Lock lock) {
		this.lock = lock;
	}
	@Column(length=30)
	public String getOpenDoorTime() {
		return openDoorTime;
	}
	public void setOpenDoorTime(String openDoorTime) {
		this.openDoorTime = openDoorTime;
	}
	@Column(length=30)
	public String getOpenEndTime() {
		return openEndTime;
	}
	public void setOpenEndTime(String openEndTime) {
		this.openEndTime = openEndTime;
	}
 
	
}
