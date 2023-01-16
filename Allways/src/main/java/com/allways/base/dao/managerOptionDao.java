package com.allways.base.dao;

import java.util.List;

import com.allways.base.model.managerOptionDto;

public interface managerOptionDao {

	public List<managerOptionDto> ManagerViewOptionList(int a, int b) throws Exception;
	public List<managerOptionDto> ManagerSearchOption(String condition, String query, int a, int b) throws Exception;
	public int ManagerCheckOptionName(String optionValue, String cakeoptionCategory) throws Exception;
	public void ManagerAddOption(String cakeoptionCategory, String cakeoptionValue, String cakeoptionPrice, String cakeoptionImage) throws Exception;
	public managerOptionDto ManagerOptionDetail(int cakeoptionId) throws Exception;
	public int ManagerCheckOptionName2(String optionValue, String cakeoptionCategory, int cakeoptionId) throws Exception;
	public void ManagerUpdateOption(String cakeoptionCategory, String cakeoptionValue, String cakeoptionPrice, String cakeoptionImage, int cakeoptionId) throws Exception;
	public void ManagerUpdateOption2(String cakeoptionCategory, String cakeoptionValue, String cakeoptionPrice, int cakeoptionId) throws Exception;
	public void ManagerDeleteOption(int cakeoptionId) throws Exception;
	public int OptionCount() throws Exception;
	public int SearchCount(String condition, String query) throws Exception;
}
