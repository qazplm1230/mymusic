package com.mymusic.entity;

import java.util.Date;
import java.util.List;

/**
 * 用户歌手类
 * @author 
 *
 */
public class UserWithSinger {
	//用户歌手的编号
	private int uws_id;
	//用户歌手的用户编号
	private int uws_userId;
	//用户歌手的歌手编号
	private int uws_singerId;
	//用户歌手的收藏时间
	private Date uws_collectionDate;
	
	public UserWithSinger() {
		super();
	}

	public int getUws_id() {
		return uws_id;
	}

	public void setUws_id(int uws_id) {
		this.uws_id = uws_id;
	}

	public int getUws_userId() {
		return uws_userId;
	}

	public void setUws_userId(int uws_userId) {
		this.uws_userId = uws_userId;
	}

	public int getUws_singerId() {
		return uws_singerId;
	}

	public void setUws_singerId(int uws_singerId) {
		this.uws_singerId = uws_singerId;
	}

	public Date getUws_collectionDate() {
		return uws_collectionDate;
	}

	public void setUws_collectionDate(Date uws_collectionDate) {
		this.uws_collectionDate = uws_collectionDate;
	}
	
}
