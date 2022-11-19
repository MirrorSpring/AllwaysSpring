package com.allways.base.dao;

import java.util.List;

import com.allways.base.model.managerCakeListDto;

public interface managerCakeDao {
	
	public List<managerCakeListDto> ManagerCakeList(String cakeName) throws Exception;

}
