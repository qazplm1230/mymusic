package com.mymusic.entity;

import java.util.Date;

/**
 * 歌单用户类
 * @author 
 *
 */
public class SonglistWithUser {
	//歌单用户编号
	private int slwu_id;
	//歌单用户的用户编号
	private int slwu_userId;
	//歌单用户的歌单编号
	private int slwu_songlistId;
	//歌单用户的收藏时间
	private Date slwu_collectionDate;
	
	public SonglistWithUser() {
		super();
	}

	public int getSlwu_id() {
		return slwu_id;
	}

	public void setSlwu_id(int slwu_id) {
		this.slwu_id = slwu_id;
	}

	public int getSlwu_userId() {
		return slwu_userId;
	}

	public void setSlwu_userId(int slwu_userId) {
		this.slwu_userId = slwu_userId;
	}

	public int getSlwu_songlistId() {
		return slwu_songlistId;
	}

	public void setSlwu_songlistId(int slwu_songlistId) {
		this.slwu_songlistId = slwu_songlistId;
	}

	public Date getSlwu_collectionDate() {
		return slwu_collectionDate;
	}

	public void setSlwu_collectionDate(Date slwu_collectionDate) {
		this.slwu_collectionDate = slwu_collectionDate;
	}
	
}
