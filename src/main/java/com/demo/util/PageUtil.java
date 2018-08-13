package com.demo.util;

import java.util.List;
import java.util.Map;

public class PageUtil<T> {
	private Integer pageNumber;
	private Integer pageSize;
	
	private long total;
	private List<T> rows;
	
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	public Integer getPageNumber() {
		if(pageNumber == null) {
			pageNumber = 10;
		}
		return pageNumber;
	}
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
	public Integer getPageSize() {
		if(pageSize == null) {
			pageSize = 0;
		}
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	
	
}
