package com.mymusic.entity;

import java.util.Date;

/**
 * ����������
 * @author 
 *
 */
public class SongComment {
	//�������۱��
	private int sc_id;
	//�������۵ĸ������
	private int sc_songId;
	//�������۵��û����
	private int sc_userId;
	//������������
	private String sc_text;
	//��������ʱ��
	private Date sc_time;
	//�������۱����޴���
	private int sc_praiseCount;
	//���۸ø������û�
	private User user;
	
	public SongComment() {
		super();
	}

	public int getSc_id() {
		return sc_id;
	}

	public void setSc_id(int sc_id) {
		this.sc_id = sc_id;
	}

	public int getSc_songId() {
		return sc_songId;
	}

	public void setSc_songId(int sc_songId) {
		this.sc_songId = sc_songId;
	}

	public int getSc_userId() {
		return sc_userId;
	}

	public void setSc_userId(int sc_userId) {
		this.sc_userId = sc_userId;
	}

	public String getSc_text() {
		return sc_text;
	}

	public void setSc_text(String sc_text) {
		this.sc_text = sc_text;
	}

	public Date getSc_time() {
		return sc_time;
	}

	public void setSc_time(Date sc_time) {
		this.sc_time = sc_time;
	}

	public int getSc_praiseCount() {
		return sc_praiseCount;
	}

	public void setSc_praiseCount(int sc_praiseCount) {
		this.sc_praiseCount = sc_praiseCount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
