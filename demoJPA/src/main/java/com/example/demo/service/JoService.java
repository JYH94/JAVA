package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Jo;

public interface JoService {

	
	public List<Jo> selectJoList();
	
	//**selectJoDetail
	public Jo selectJoDetail(int jno);
	
	//**insert & update
	public Jo save(Jo entity);
	
	//**delete
	public void delete(int jno);
}
