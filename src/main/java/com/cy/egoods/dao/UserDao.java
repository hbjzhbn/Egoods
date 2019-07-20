package com.cy.egoods.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.cy.egoods.pojo.TbUser;

@Mapper
public interface UserDao {
	 int insertUser(TbUser user);
	 @Select("select * from tb_user where username=#{username}")
	 TbUser findByUsername(String username);
}
