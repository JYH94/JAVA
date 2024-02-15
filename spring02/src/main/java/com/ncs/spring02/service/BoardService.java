package com.ncs.spring02.service;

import java.util.List;

import com.ncs.spring02.domain.BoardDTO;

import pageTest.SearchCriteria;


public interface BoardService {
	
	
	public List<BoardDTO> bCheckList(SearchCriteria cri) ;
	public int bCheckRowsCount(SearchCriteria cri) ;
	
	//** Board_Paging
	public List<BoardDTO> bPageList(SearchCriteria cri) ;
	public int totalRowsCount(SearchCriteria cri) ;
	
	
	// List
	public List<BoardDTO> selectList() ;

	// Detail
	public BoardDTO selectOne(int seq) ;

	// Insert
	public int insert(BoardDTO dto) ;
	
	//replyInsert
	public int rinsert(BoardDTO dto) ;

	// Update
	public int update(BoardDTO dto) ;

	// Delete
	public int delete(BoardDTO dto) ;
}
