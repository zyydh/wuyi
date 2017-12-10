package org.wuyi.common;

import java.io.Serializable;
import java.util.List;

public class JqGridData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7783364691615944384L;

	private int page = 0;
	
	private int total = 0;
	
	private int records = 0;
	
	private List rows;
	
	private String userdata = "";
	
	public JqGridData(){
		
	}//JqGridData(page, total, records,contracterService.getContracterList(null,null,limit));
	public JqGridData(int page,int total,int records,List rows){
		this.page=page;
		this.total=total;
		this.records=records;
		this.rows=rows;
	}
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getRecords() {
		return records;
	}

	public void setRecords(int records) {
		this.records = records;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List list) {
		this.rows = list;
	}

	public String getUserdata() {
		return userdata;
	}

	public void setUserdata(String userdata) {
		this.userdata = userdata;
	}
	
	
}
