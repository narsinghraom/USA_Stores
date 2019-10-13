package com.usastores.service;

import java.util.List;

import com.usastores.bean.StoreBean;

public interface Service 
{
	public int insert(StoreBean storeBean);
	public int delete(int storeId);
	public List<StoreBean> search(int storeId);
	public int update(StoreBean storeBean);

}
