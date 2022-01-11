package com.javaex.dao;

import java.util.List;

import com.javaex.vo.GuestBookVo;

public interface GuestBookDao {

	public int insert(GuestBookVo vo);

	public boolean delete(int num, String pwd);

	public List<GuestBookVo> getList();

}
