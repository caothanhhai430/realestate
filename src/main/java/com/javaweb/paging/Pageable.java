package com.javaweb.paging;

public interface Pageable {
	Integer getSize();
	Integer getPage();
	void setSize(Integer size);
	void setPage(Integer page);
}
