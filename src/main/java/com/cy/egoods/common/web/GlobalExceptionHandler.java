package com.cy.egoods.common.web;

import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cy.egoods.common.vo.JsonResult;



/**
 * 全局异常处理
 * @author PHP
 *
 */
//@RestControllerAdvice
@ControllerAdvice//该类也会交给spring管理
public class GlobalExceptionHandler {
	/** 使用该注解描述的方法为异常处理方法*/
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public JsonResult doHandlerRuntimeException(RuntimeException e) {
		e.printStackTrace();
		return new JsonResult(e);
		
	}
	
	@ExceptionHandler(BindException.class)
	public JsonResult doHandlerBindException() {
		return null;
		
	}
	
	@ExceptionHandler(ShiroException.class)
	@ResponseBody
	public JsonResult doHandleShiroException(
			ShiroException e) {
		JsonResult r=new JsonResult();
		r.setState(0);
		if(e instanceof UnknownAccountException) {
			r.setMessage("账户不存在");
		}else if(e instanceof LockedAccountException) {
			r.setMessage("账户已被禁用");
		}else if(e instanceof IncorrectCredentialsException) {
			r.setMessage("密码不正确");
		}else if(e instanceof AuthorizationException) {
			r.setMessage("没有此操作权限");
		}else {
			r.setMessage("系统维护中");
		}
		e.printStackTrace();
		return r;
	}

}
