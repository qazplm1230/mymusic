package com.mymusic.entity;

import java.util.Date;

/**
 * 用户专辑类
 * @author 
 *
 */
public class UserWithCd {
	//用户专辑的编号
	private int uwc_id;
	//用户专辑的用户编号
	private int uwc_userId;
	//用户专辑的专辑编号
	private int uwc_cdId;
	//用户专辑的收藏时间
	private Date uwc_collectionDate;
	
	public UserWithCd() {
		super();
	}

	public int getUwc_id() {
		return uwc_id;
	}

	public void setUwc_id(int uwc_id) {
		this.uwc_id = uwc_id;
	}

	public int getUwc_userId() {
		return uwc_userId;
	}

	public void setUwc_userId(int uwc_userId) {
		this.uwc_userId = uwc_userId;
	}

	public int getUwc_cdId() {
		return uwc_cdId;
	}

	public void setUwc_cdId(int uwc_cdId) {
		this.uwc_cdId = uwc_cdId;
	}

	public Date getUwc_collectionDate() {
		return uwc_collectionDate;
	}

	public void setUwc_collectionDate(Date uwc_collectionDate) {
		this.uwc_collectionDate = uwc_collectionDate;
	}
	
}
