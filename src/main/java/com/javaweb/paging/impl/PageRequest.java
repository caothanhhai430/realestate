package com.javaweb.paging.impl;

import com.javaweb.paging.Pageable;

public class PageRequest implements Pageable{
	private Integer page;
	private Integer size;

	
	public PageRequest(Integer page, Integer size) {
		super();
		this.page = page;
		this.size = size;
	}
	
	public PageRequest() {
		
	}

	@Override
	public Integer getSize() {
		// TODO Auto-generated method stub
		return this.size;
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
	public void setSize(Integer size) {
		this.size = size;
	}


	

	
}
