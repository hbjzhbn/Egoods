package com.cy.egoods.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
@Data
public class TbUser implements Serializable{

	private static final long serialVersionUID = 2620681323708646748L;

	private String id;

    private String username;
    private String password;

    private String phone;

    private String email;

    private Date created;

    private Date updated;

    private String sourceType;

    private String nickName;

    private String name;

    private String status;

    private String headPic;

    private String qq;

    private Long accountBalance;

    private String isMobileCheck;

    private String isEmailCheck;

    private String sex;

    private Integer userLevel;

    private Integer points;

    private Integer experienceValue;

    private Date birthday;

    private Date lastLoginTime;
}