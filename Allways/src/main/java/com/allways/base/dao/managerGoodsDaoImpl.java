package com.allways.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.allways.base.model.managerGoodsListDto;

public class managerGoodsDaoImpl implements managerGoodsDao {

	SqlSession sqlSession;
	public static String nameSpace="com.allways.base.dao.managerGoodsDao";
	
	@Override
	public List<managerGoodsListDto> ManagerViewGoodsList(String goodsCategory, String goodsName) throws Exception {
		return sqlSession.selectList(nameSpace + ".ManagerViewGoodsList");
	}

	@Override
	public void ManagerAddGoods(String goodsName, String goodsCategory, int goodsPrice, String goodsDetail,
			String goodsImage) throws Exception {
		sqlSession.update(nameSpace + ".ManagerAddGoods");
	}

	@Override
	public int ManagerCheckGoodsName(String goodsName) throws Exception {
		return (int) sqlSession.selectOne(nameSpace + ".ManagerCheckGoodsName");
	}

	@Override
	public List<managerGoodsListDto> ManagerViewAllGoods(String goodsName) throws Exception {
		return sqlSession.selectList(nameSpace + ".ManagerViewAllGoods");
	}

	@Override
	public managerGoodsListDto ManagerGoodsDetail(String goodsName) throws Exception {
		return (managerGoodsListDto) sqlSession.selectOne(nameSpace + ".ManagerGoodsDetail");
	}

	@Override
	public int ManagerCheckGoodsName2(String goodsName, String goodsOriginalName) throws Exception {
		return (int) sqlSession.selectOne(nameSpace + ".ManagerCheckGoodsName2");
	}

	@Override
	public void ManagerUpdateGoods(String goodsName, String goodsCategory, int goodsPrice, String goodsDetail,
			String goodsImage, String goodsOriginalName) throws Exception {
		sqlSession.update(nameSpace + ".ManagerUpdateGoods");
	}

	@Override
	public void ManagerUpdateGoods2(String goodsName, String goodsCategory, int goodsPrice, String goodsDetail,
			String goodsOriginalName) throws Exception {
		sqlSession.update(nameSpace + ".ManagerUpdateGoods2");
	}

	@Override
	public void ManagerDeleteGoods(String goodsOriginalName) throws Exception {
		sqlSession.update(nameSpace + ".ManagerDeleteGoods");
	}

}
