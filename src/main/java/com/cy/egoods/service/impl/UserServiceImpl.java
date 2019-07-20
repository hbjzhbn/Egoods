package com.cy.egoods.service.impl;

import java.util.UUID;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.egoods.dao.UserDao;
import com.cy.egoods.pojo.TbUser;
import com.cy.egoods.pojo.UserRegist;
import com.cy.egoods.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public int insertUser(UserRegist user) {
		if (user.getUsername().equals(""))
			throw new IllegalArgumentException("用户名不能为空");
		String regex = "^[a-zA-Z0-9_-]{3,16}$";
		if (!user.getUsername().matches(regex))
			throw new IllegalArgumentException("用户名格式错误");
		if (findByUsername(user.getUsername()) != null)
			throw new IllegalArgumentException("用户已存在");
		if (user.getPassword() == null)
			throw new IllegalArgumentException("密码不能为空");
		if (!user.getPassword().matches(regex))
			throw new IllegalArgumentException("密码格式错误");
		if (!user.getPassword().equals(user.getCfpassword()))
			throw new IllegalArgumentException("两次输入的密码不相等");
		TbUser tbUser = new TbUser();
		tbUser.setId(UUID.randomUUID().toString());
		SimpleHash sHash = new SimpleHash("MD5", // 加密算法
				user.getPassword(), // 要加密的密码
				tbUser.getId(), // 盐值
				1);// 加密次数
		tbUser.setUsername(user.getUsername());
		tbUser.setPassword(sHash.toHex());
		int rows = userDao.insertUser(tbUser);
		return rows;
	}

	@Override
	public void doJudgeUser(UserRegist user) {
		if (user.getUsername().equals(""))
			throw new IllegalArgumentException("*  用户名不能为空");
		String regex = "^[a-zA-Z0-9_-]{3,16}$";
		if (!user.getUsername().matches(regex))
			throw new IllegalArgumentException("*  用户名格式错误");
		if (findByUsername(user.getUsername()) != null)
			throw new IllegalArgumentException("*  用户已存在");
	}

	@Override
	public TbUser findByUsername(String username) {
		TbUser user = userDao.findByUsername(username);
		return user;
	}

	@Override
	public void doJudgePassword(UserRegist user) {
		if (user.getPassword().equals(""))
			throw new IllegalArgumentException("*  密码名不能为空");
		String regex = "^[a-zA-Z0-9_-]{3,16}$";
		if (!user.getPassword().matches(regex))
			throw new IllegalArgumentException("*  密码格式错误");
	}

	@Override
	public void doJudgeCfPassword(UserRegist user) {
		if (!user.getPassword().equals(user.getCfpassword()))
			throw new IllegalArgumentException("*  两次输入的密码不相等");		
	}

}
