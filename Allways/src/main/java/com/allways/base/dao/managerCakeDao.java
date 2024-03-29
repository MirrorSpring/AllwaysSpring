package com.allways.base.dao;

import java.util.List;

import com.allways.base.model.managerCakeDetailDto;
import com.allways.base.model.managerCakeListDto;

public interface managerCakeDao {
	
	public List<managerCakeListDto> ManagerCakeList(String cakeName, int a, int b) throws Exception;
	public void ManagerAddCake(String cakeName, int cakePrice, String cakeImage, String cakeDetail) throws Exception;
	public int ManagerCheckCakeName(String cakeName) throws Exception;
	public managerCakeDetailDto ManagerViewCakeDetail(String cakeName) throws Exception;
	public void ManagerDeleteCake(String cakeName) throws Exception;
	public void ManagerUpdateCake(String cakeName, int cakePrice, String cakeDetail, String cakeImage, String cakeOriginalName) throws Exception;
	public void ManagerUpdateCake2(String cakeName, int cakePrice, String cakeDetail, String cakeOriginalName) throws Exception;
	public int ManagerCheckCakeName2(String cakeName, String cakeOriginalName) throws Exception;
	public int CakeCount(String cakeName) throws Exception;
}
