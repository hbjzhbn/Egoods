package com.cy.egoods.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.egoods.dao.CartDao;
import com.cy.egoods.dao.GoodsDao;
import com.cy.egoods.pojo.TbGoods;
import com.cy.egoods.service.GoodsService;
@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsDao goodsDao;
	@Override
	public List<TbGoods> findById(Long[] ids) {
		
		List<TbGoods> result = goodsDao.findById(ids);
		return result;
	}

}
