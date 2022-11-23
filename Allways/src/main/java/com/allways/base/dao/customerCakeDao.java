package com.allways.base.dao;

import java.util.List;

import com.allways.base.model.customerCakeDto;

public interface customerCakeDao {
	
	public List<customerCakeDto> CustomerCakeList(String sort1, String sort2) throws Exception;

}
