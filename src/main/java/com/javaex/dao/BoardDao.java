package com.javaex.dao;

import java.util.List;

import com.javaex.vo.BoardVo;

public interface BoardDao {

	public boolean insert(BoardVo vo); // 글쓰기

	public boolean delete(int boardno); // 글삭제

	public boolean update(BoardVo vo); // 글수정

	public List<BoardVo> getList(BoardVo vo); // 게시판
//	int page, String search, String kwd
	
	public BoardVo getBoard(int boardno); // 글내용

	public boolean upHit(int boardno); // 조회수 올리기

	public int getTotalRow(BoardVo vo);
//	String search, String kwd
}
