package com.exfinder.dao;

import java.util.List;


import com.exfinder.dto.BoardDto;
import com.exfinder.vo.BoardVo;

public interface BoardDao {
	
	public void create(BoardDto board) throws Exception;	//게시판 생성
	public BoardDto read(int b_id) throws Exception;		//특정 게시판 항목 조회
	public void update(BoardDto board) throws Exception;	//게시판 항목 업데이트
	public void delete(int b_id) throws Exception;			//특정 게시판 항목 삭제
	public List<BoardDto> listAll() throws Exception;		//모든 게시판 항목 조회
	
	public void b_viewUpdate(int b_id) throws Exception;				//조회수 업데이트
	public List<BoardDto> listSearch(BoardVo vo) throws Exception;		//검색 조건에 맞는 게시판 항목 조회
	
	public int getTotalCountByCategory(BoardVo vo) throws Exception;	//카테고리 및 검색 조건에 따른 전체 게시글 수 조회
	
	public List<BoardDto> getUserPosts(String u_id) throws Exception;
	public int deletePostByUser(int b_id) throws Exception;
	public List<BoardDto> adminBoardList() throws Exception;
	
}
