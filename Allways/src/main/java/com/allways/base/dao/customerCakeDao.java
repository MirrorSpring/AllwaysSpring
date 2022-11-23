package com.allways.base.dao;

import java.util.List;

import com.allways.base.model.customerCakeDto;
import com.allways.base.model.customercakeOptionDto;

public interface customerCakeDao {
	
	public List<customerCakeDto> CustomerCakeList(String sort1, String sort2) throws Exception;
	public customerCakeDto CustomerCakeDetail(int cakeId) throws Exception;
	public List<customercakeOptionDto> CustomerCakeOption(String cakeoptionCategory) throws Exception;

}
