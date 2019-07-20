package com.cy.egoods.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.egoods.common.vo.JsonResult;
import com.cy.egoods.pojo.TbUser;
import com.cy.egoods.pojo.UserRegist;
import com.cy.egoods.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping("doInsertUser")
	public JsonResult insertUser(UserRegist user) {
		userService.insertUser(user);
		return new JsonResult("注册成功");
	}
	@RequestMapping("doJudgeUser")
	public JsonResult doJudgeUser(UserRegist username) {
		userService.doJudgeUser(username);
		return new JsonResult("1");
	}
	@RequestMapping("doJudgePassword")
	public JsonResult doJudgePassword(UserRegist username) {
		userService.doJudgePassword(username);
		return new JsonResult("1");
	}
	@RequestMapping("doJudgeCfPassword")
	public JsonResult doJudgeCfPassword(UserRegist username) {
		userService.doJudgeCfPassword(username);
		return new JsonResult("1");
	}
	@RequestMapping("doLogin")
	public JsonResult doLogin(String username,String password) {
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username,password);
		 subject.login(token);
		return new JsonResult("登陆成功");
	}
	@RequestMapping("doGetUser")
	public JsonResult doGetUser() {
		TbUser user  = (TbUser) SecurityUtils.getSubject().getPrincipal();
		return new JsonResult(user);
	}
	

}
