package com.cy.egoods.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.egoods.dao.CartDao;
import com.cy.egoods.pojo.TbCart;
import com.cy.egoods.service.CartService;
@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDao cartDao;
	@Override
	public Long[] findByUsername(String username) {
		Long[] goodsId = cartDao.findByUsername("admin");
		return goodsId;
	}
	
	@Override
	public int joinCart(TbCart cart) {
		TbCart cart1 = cartDao.findByNameAndId(cart);
		if(cart1!=null) {
			cart.setGoodsNumber(cart1.getGoodsNumber()+cart.getGoodsNumber());
			int rows = cartDao.updateCart(cart);
			System.out.println(rows);
			return rows;
		}else {
			int rows = cartDao.joinCart(cart);
			return rows;
		}
	}

	}


