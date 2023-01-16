package com.allways.base.dao;

import java.util.List;

import com.allways.base.model.managerGoodsListDto;

public interface managerGoodsDao {

	public List<managerGoodsListDto> ManagerViewGoodsList(String goodsCategory, String goodsName, int a, int b) throws Exception;
	public List<managerGoodsListDto> ManagerViewAllGoods(String goodsName) throws Exception;
	public void ManagerAddGoods(String goodsName, String goodsCategory, int goodsPrice, String goodsDetail, String goodsImage) throws Exception;
	public int ManagerCheckGoodsName(String goodsName) throws Exception;
	public managerGoodsListDto ManagerGoodsDetail(String goodsName) throws Exception;
	public int ManagerCheckGoodsName2(String goodsName, String goodsOriginalName) throws Exception;
	public void ManagerUpdateGoods(String goodsName, String goodsCategory, int goodsPrice, String goodsDetail, String goodsImage, String goodsOriginalName) throws Exception;
	public void ManagerUpdateGoods2(String goodsName, String goodsCategory, int goodsPrice, String goodsDetail, String goodsOriginalName) throws Exception;
	public void ManagerDeleteGoods(String goodsOriginalName) throws Exception;
	public int GoodsCount(String goodsCategory, String goodsName) throws Exception;
}
