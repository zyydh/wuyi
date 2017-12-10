package org.wuyi.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Pagination implements Serializable 
{
	private static final long serialVersionUID = 7080505494378329596L;
	private int PAGE_DEFAULT_LIMIT = 10;
	private static final int PAGE_BAR_SIZE = 9;
	private String query;
	private int currentPage;
	private long totalCount;
	private int totalPage;
	private int pageLimit;
	private boolean hasNextPage;
	private boolean hasPrevPage;
	private List<String> pageBarList = new ArrayList<String>();
	private HashMap<String, String> params = null;

	public Pagination(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public Pagination(int currentPage, int pageLimit) {
		this.currentPage = currentPage;
		this.PAGE_DEFAULT_LIMIT = pageLimit; 
	}

	public void setTotalCount(long totalCount) {
		if (totalCount <= 0) {
			return;
		}
		this.totalCount = totalCount;
		if (this.pageLimit <= 0) {
			this.pageLimit = PAGE_DEFAULT_LIMIT;
		}
		if (this.totalCount % this.pageLimit == 0) {
			this.totalPage = new Long(this.totalCount / this.pageLimit).intValue();
		} else {
			this.totalPage = new Long(this.totalCount / this.pageLimit + 1).intValue();
		}
		if (this.currentPage > this.totalPage) {
			this.currentPage = this.totalPage;
		} else if (this.currentPage <= 0) {
			this.currentPage = 1;
		}
		this.setPageBar();
		this.hasPrevPage = this.currentPage != 1;
		this.hasNextPage = this.currentPage != this.totalPage;
	} 
	
	// 设置页面下方的分页按钮条 
	public void setPageBar() 
	{ 
		if (this.totalPage <= PAGE_BAR_SIZE) 
		{ 
			for (int i = 1; i <= this.totalPage; i++) 
			{
				pageBarList.add(Integer.toString(i)); 
			} 
		} 
		else if (this.currentPage <= PAGE_BAR_SIZE / 2) 
		{ 
			for (int i = 1; i <= PAGE_BAR_SIZE; i++) 
			{
				pageBarList.add(Integer.toString(i)); 
			} 
		} 
		else if (this.currentPage >= this.totalPage - (PAGE_BAR_SIZE - 1) / 2) 
		{ 
			for (int i = this.totalPage - PAGE_BAR_SIZE + 1; i <= this.totalPage; i++) 
			{
				pageBarList.add(Integer.toString(i)); 
			} 
		} 
		else 
		{ 
			for (int i = this.currentPage - PAGE_BAR_SIZE / 2; i < this.currentPage - PAGE_BAR_SIZE / 2 + PAGE_BAR_SIZE; i++) 
			{
				pageBarList.add(Integer.toString(i)); 
			} 
		} 
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageLimit() {
		return pageLimit;
	}

	public void setPageLimit(int pageLimit) {
		this.pageLimit = pageLimit;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	public boolean isHasPrevPage() {
		return hasPrevPage;
	}

	public void setHasPrevPage(boolean hasPrevPage) {
		this.hasPrevPage = hasPrevPage;
	}

	public List<String> getPageBarList() {
		return pageBarList;
	}

	public void setPageBarList(List<String> pageBarList) {
		this.pageBarList = pageBarList;
	}

	public int getPageDefaultLimit() {
		return PAGE_DEFAULT_LIMIT;
	}

	public static int getPageBarSize() {
		return PAGE_BAR_SIZE;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public HashMap<String, String> getParams() {
		return params;
	}

	public void setParams(HashMap<String, String> params) {
		this.params = params;
		this.query = "";
		if (params != null)
		{
			Iterator<String> ite = params.keySet().iterator();
			while(ite.hasNext())
			{
				String key = ite.next();
				if(!CommonUtil.isEmpty(params.get(key)))
				{
					query += "&" + key + "=" + params.get(key);
				}
			}
			if (!CommonUtil.isEmpty(this.query))
			{
				query = query.substring(1, query.length());
			}
		}
	}
}
