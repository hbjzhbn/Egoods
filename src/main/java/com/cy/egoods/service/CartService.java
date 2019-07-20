package com.cy.egoods.service;

import com.cy.egoods.pojo.TbCart;

public interface CartService {

	Long[] findByUsername(String username);
	int joinCart(TbCart cart);
	
}
