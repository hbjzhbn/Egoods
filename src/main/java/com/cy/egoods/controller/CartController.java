package com.cy.egoods.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.egoods.common.vo.JsonResult;
import com.cy.egoods.pojo.TbCart;
import com.cy.egoods.pojo.TbGoods;
import com.cy.egoods.service.CartService;
import com.cy.egoods.service.GoodsService;

@RestController
public class CartController {
	@Autowired
	private CartService cartService;
	@Autowired
	private GoodsService goodsService;
	@RequestMapping("findByUsername")
	public JsonResult findByUsername(String username) {
		Long[] goodsId = cartService.findByUsername(username);
		 List<TbGoods> result = goodsService.findById(goodsId);
		return new JsonResult(result);
	}
	
	@RequestMapping("joinCart")
	public JsonResult joinCart(TbCart cart) {
		cartService.joinCart(cart);
		return new JsonResult("添加成功");
	}
	
	

}
