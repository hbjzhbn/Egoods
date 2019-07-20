package com.cy.egoods.pojo;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;
@Data
@ToString
public class TbCart implements Serializable{
	private static final long serialVersionUID = 8813791402046262503L;
	private String username;
	private Long goodsId;
	private int goodsNumber;
}
