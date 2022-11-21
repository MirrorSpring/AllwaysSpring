package com.allways.base.dao;

import java.util.List;

import com.allways.base.model.managerGoodsListDto;

public interface managerGoodsDao {

	public List<managerGoodsListDto> ManagerViewGoodsList(String goodsCategory, String goodsName) throws Exception;
	public void ManagerAddGoods(String goodsName, String goodsCategory, int goodsPrice, String goodsDetail, String goodsImage) throws Exception;
	public int ManagerCheckGoodsName(String goodsName) throws Exception;
}
