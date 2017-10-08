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

import org.hibernate.annotations.OnDelete;

@Entity
@Table(name="authorizeRecord")
public class AuthorizeRecord  extends BaseEntity{
 
	private static final long serialVersionUID = 619517674007318087L;
	private Integer aid;
	private Manager manager;
	private User user;
	private Lock lock;
	private Integer count;
	private String beginTime;
	private String endTime;
	private Application application;
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	@ManyToOne(targetEntity=Manager.class)
	@JoinColumn(name="mid")
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	@ManyToOne(targetEntity=User.class)
	@JoinColumn(name="uid")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@ManyToOne(targetEntity=Lock.class)
	@JoinColumn(name="lid")
	public Lock getLock() {
		return lock;
	}
	public void setLock(Lock lock) {
		this.lock = lock;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Column(length=30)
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	@Column(length=30)
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	@OneToOne
	@JoinColumn(name="appid")
	public Application getApplication() {
		return application;
	}
	public void setApplication(Application application) {
		this.application = application;
	}
}
