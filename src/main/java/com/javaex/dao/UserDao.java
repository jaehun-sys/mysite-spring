package com.javaex.dao;

import java.util.List;

import com.javaex.vo.UserVo;

public interface UserDao {
	public int join(UserVo vo);

	public List<UserVo> loginSelect(UserVo vo);

	public int updateUser(UserVo vo);

	public int emailCheckCnt(String email);
}
