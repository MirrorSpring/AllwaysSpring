package com.allways.base.dao;

import java.util.List;

import com.allways.base.model.managerCakeDetailDto;
import com.allways.base.model.managerCakeListDto;

public interface managerCakeDao {
	
	public List<managerCakeListDto> ManagerCakeList(String cakeName) throws Exception;
	public void ManagerAddCake(String cakeName, int cakePrice, String cakeImage, String cakeDetail) throws Exception;
	public int ManagerCheckCakeName(String cakeName) throws Exception;
	public managerCakeDetailDto ManagerViewCakeDetail(String cakeName) throws Exception;
	public void ManagerDeleteCake(String cakeName) throws Exception;
}
