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

}
