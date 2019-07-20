package com.cy.egoods.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.egoods.pojo.TbGoods;
@Mapper
public interface GoodsDao {
	
	List<TbGoods> findById(@Param("ids")Long[] ids);
}
