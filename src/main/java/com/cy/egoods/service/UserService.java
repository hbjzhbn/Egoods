package com.cy.egoods.service;

import com.cy.egoods.pojo.TbUser;
import com.cy.egoods.pojo.UserRegist;

public interface UserService {
	int insertUser(UserRegist user);
	void doJudgeUser(UserRegist user);
	TbUser findByUsername(String username);
	void doJudgePassword(UserRegist user);
	void doJudgeCfPassword(UserRegist user);
}
