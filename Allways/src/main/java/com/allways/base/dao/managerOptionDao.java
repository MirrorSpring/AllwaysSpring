package com.allways.base.dao;

import java.util.List;

import com.allways.base.model.managerOptionDto;

public interface managerOptionDao {

	public List<managerOptionDto> ManagerViewOptionList() throws Exception;
	public List<managerOptionDto> ManagerSearchOption(String condition, String query) throws Exception;
}
