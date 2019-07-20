package com.cy.egoods.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.cy.egoods.pojo.TbGoods;

@Service
public interface GoodsService {

	List<TbGoods> findById(Long[] ids);


}
