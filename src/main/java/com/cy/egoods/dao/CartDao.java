package com.cy.egoods.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cy.egoods.pojo.TbCart;

@Mapper
public interface CartDao {
	@Select("select goods_id from tb_cart where username=#{username}")
	Long[] findByUsername(String username);
	@Insert("insert into tb_cart values(#{username},#{goodsId},#{goodsNumber})")
	int joinCart(TbCart cart);
	@Select("select * from tb_cart where username=#{username}&&goods_id=#{goodsId}")
	TbCart findByNameAndId(TbCart cart);
	@Update("update tb_cart set goods_number=#{goodsNumber} where username=#{username}&&goods_id=#{goodsId}")
	int updateCart(TbCart cart);
	@Select("select goods_number from tb_cart where username=#{username}")
	Integer[] findByName(String username);
}
