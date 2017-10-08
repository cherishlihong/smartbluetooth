package com.ifox.smartbluetooth.domain;

import java.util.List;

public class Page {
	private List list;//结果
	private int totalRecords;//总记录数
	private int pageSize;//每一页的个数
	private int pagrNo;
	
	public int getTotalPages(){
		return (totalRecords+pageSize-1)/pageSize;
	}
	
	//取得首页
	public int getTopPageNo() {
		return 1;
	}
  //上一页
	public int getPreviousPageNo() {
		if (pagrNo<=1) {
			return 1;
		}
		return pagrNo-1;
		
	}
	//下一页
	public int getNextPageNo() {
		if (pagrNo>=getTotalPages()) {
			return pagrNo;
		}else{
			return pagrNo+1;
		}
	}
	//取得尾页
	public int  getBottomPageNo() {
		return getTotalPages();
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPagrNo() {
		return pagrNo;
	}

	public void setPagrNo(int pagrNo) {
		this.pagrNo = pagrNo;
	}
	
}
