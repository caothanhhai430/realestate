package com.javaweb.paging.impl;

import com.javaweb.paging.Pageable;

public class PageRequest implements Pageable{
	private Integer page;
	private Integer limit;

	
	public PageRequest(Integer page, Integer limit) {
		super();
		this.page = page;
		this.limit = limit;
	}
	
	public PageRequest() {
		
	}

	@Override
	public Integer getLimit() {
		// TODO Auto-generated method stub
		return this.limit;
	}

	@Override
	public Integer getPage() {
		// TODO Auto-generated method stub
		return this.page;
	}

	@Override
	public void setPage(Integer page) {
		this.page = page;
	}

	@Override
	public void setLimit(Integer limit) {
		this.limit = limit;
	}


	

	
}
