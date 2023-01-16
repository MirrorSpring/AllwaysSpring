package com.allways.base.dao;

import java.util.List;

import com.allways.base.model.customerBoardDto;

public interface customerBoardDao {
	
	public List<customerBoardDto> BoardList(String condition, String query, int a, int b) throws Exception;
	public int WriteId() throws Exception;
	public void WriteBoard(String w_customerId, int commentId, String writeTitle, String writeContent) throws Exception;
	public customerBoardDto BoardDetail(int writeId) throws Exception;
	public void WriteComment(String w_customerId, int commentId, String writeContent) throws Exception;
	public List<customerBoardDto> BoardComment(int commentId) throws Exception;
	public void DeleteBoard(int writeId) throws Exception;
	public int BoardCount(String condition, String query) throws Exception;
}
