package com.mymusic.entity;

import java.util.Date;

/**
 * �赥������
 * @author 
 *
 */
public class SonglistComment {
	//�赥���۱��
	private int slc_id;
	//�赥���۵ĸ赥���
	private int slc_songlistId;
	//�赥���۵��û����
	private int slc_userId;
	//�赥���۵�����
	private String slc_text;
	//�赥���۵�ʱ��
	private Date slc_time;
	//�赥���۱���������
	private int slc_praiseCount;
	//���۸ø赥���û�
	private User user;
	
	public SonglistComment() {
	}

	public int getSlc_id() {
		return slc_id;
	}

	public void setSlc_id(int slc_id) {
		this.slc_id = slc_id;
	}

	public int getSlc_songlistId() {
		return slc_songlistId;
	}

	public void setSlc_songlistId(int slc_songlistId) {
		this.slc_songlistId = slc_songlistId;
	}

	public int getSlc_userId() {
		return slc_userId;
	}

	public void setSlc_userId(int slc_userId) {
		this.slc_userId = slc_userId;
	}

	public String getSlc_text() {
		return slc_text;
	}

	public void setSlc_text(String slc_text) {
		this.slc_text = slc_text;
	}

	public Date getSlc_time() {
		return slc_time;
	}

	public void setSlc_time(Date slc_time) {
		this.slc_time = slc_time;
	}

	public int getSlc_praiseCount() {
		return slc_praiseCount;
	}

	public void setSlc_praiseCount(int slc_praiseCount) {
		this.slc_praiseCount = slc_praiseCount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
