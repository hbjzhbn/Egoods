package com.cy.egoods.pojo;

import java.io.Serializable;

import lombok.Data;
@Data
public class UserRegist implements Serializable{

	private static final long serialVersionUID = 8653050633210250458L;
	private String username;
    private String password;
    private String cfpassword;
}
