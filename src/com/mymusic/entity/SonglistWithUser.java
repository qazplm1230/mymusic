package com.mymusic.entity;

import java.util.Date;

/**
 * �赥�û���
 * @author 
 *
 */
public class SonglistWithUser {
	//�赥�û����
	private int slwu_id;
	//�赥�û����û����
	private int slwu_userId;
	//�赥�û��ĸ赥���
	private int slwu_songlistId;
	//�赥�û����ղ�ʱ��
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
