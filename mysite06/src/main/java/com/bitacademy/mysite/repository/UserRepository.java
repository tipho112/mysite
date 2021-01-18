package com.bitacademy.mysite.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.mysite.vo.UserVo;

@Repository
public class UserRepository {
	@Autowired
	private SqlSession sqlSession;
	
	public UserVo findByNo(Long userNo) {
		return sqlSession.selectOne("user.find", userNo);
	}

	public UserVo findByEmail(String email) {
		return sqlSession.selectOne("user.findByEmail", email);
	}
	
	public UserVo findByEmailAndPassword(UserVo vo) {
		return sqlSession.selectOne("user.findByEmailAndPassword", vo);
	}
	
	public UserVo findByEmailAndPassword2(UserVo vo) {
		Map<String, Object> map = new HashMap<>();
		map.put("e", vo.getEmail());
		map.put("p", vo.getPassword());
		return sqlSession.selectOne("user.findByEmailAndPassword2", map);
	}

	public int update(UserVo vo) {
		return sqlSession.update("user.update", vo);
	}

	public int insert(UserVo userVo) {
		return sqlSession.insert("user.insert", userVo);
	}
}
