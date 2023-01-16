package com.allways.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.allways.base.model.customerBoardDto;

public class customerBoardDaoImpl implements customerBoardDao {
	
	SqlSession sqlSession;
	String nameSpace="com.allways.base.dao.customerBoardDao";

	@Override
	public List<customerBoardDto> BoardList(String condition, String query, int a, int b) throws Exception {
		return sqlSession.selectList(nameSpace + ".BoardList");
	}

	@Override
	public int WriteId() throws Exception {
		return sqlSession.selectOne(nameSpace + ".WriteId");
	}

	@Override
	public void WriteBoard(String w_customerId, int commentId, String writeTitle, String writeContent)
			throws Exception {
		sqlSession.insert(nameSpace + ".WriteBoard");
	}

	@Override
	public customerBoardDto BoardDetail(int writeId) throws Exception {
		return sqlSession.selectOne(nameSpace + ".BoardDetail");
	}

	@Override
	public void WriteComment(String w_customerId, int commentId, String writeContent) throws Exception {
		sqlSession.insert(nameSpace + ".WriteComment");
	}

	@Override
	public List<customerBoardDto> BoardComment(int commentId) throws Exception {
		return sqlSession.selectList(nameSpace + ".BoardComment");
	}

	@Override
	public void DeleteBoard(int writeId) throws Exception {
		sqlSession.update(nameSpace + ".DeleteBoard");
	}

	@Override
	public int BoardCount(String condition, String query) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".BoardCount");
	}

}
