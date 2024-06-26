package com.ncs.spring02.service;

import java.util.List;

import com.ncs.spring02.domain.BoardDTO;
import com.ncs.spring02.domain.MemberDTO;

import pageTest.SearchCriteria;

public interface MemberService {

	
	
	
	
	
	public List<MemberDTO> mSearchList(SearchCriteria cri);
	public int mSearchRowsCount(SearchCriteria cri);
	
	public List<MemberDTO> mCheckList(SearchCriteria cri);
	public int mCheckRowsCount(SearchCriteria cri);
	
	
	public List<MemberDTO> mPageList(SearchCriteria cri) ;
	public int mTotalRowsCount(SearchCriteria cri) ;
	
	
	//** selectList
	public List<MemberDTO> selectList();
	
	//** selectOne
	public MemberDTO selectOne(String id);
	
	//** insert
	public int insert(MemberDTO dto);
	
	//** update
	public int update(MemberDTO dto);
	
	//** Password_Update
	public int pwUpdate(MemberDTO dto);
	
	//** delete
	public int delete(String id);
	
	//** selectJoList
	public List<MemberDTO> selectJoList(String jno);

}
