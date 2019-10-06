package com.javaweb.paging;

public interface Pageable {
	Integer getLimit();
	Integer getPage();
	void setLimit(Integer limit);
	void setPage(Integer page);
}
