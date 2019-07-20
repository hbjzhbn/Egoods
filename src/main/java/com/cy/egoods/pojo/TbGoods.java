package com.cy.egoods.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;
import lombok.ToString;
@ToString
@Data
public class TbGoods implements Serializable {

	private static final long serialVersionUID = 3742721979319071340L;

	private Long id;

	private String sellerId;

	private String goodsName;

	private Long defaultItemId;

	private String auditStatus;

	private String isMarketable;

	private Long brandId;

	private String caption;

	private Long category1Id;

	private Long category2Id;

	private Long category3Id;

	private String smallPic;

	private BigDecimal price;

	private Long typeTemplateId;

	private String isEnableSpec;

	private String isDelete;
}
