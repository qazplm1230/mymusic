package com.mymusic.entity;

import java.util.Date;

/**
 * �赥������
 * @author 
 *
 */
public class SonglistWithSong {
	//�赥�������
	private int slws_id;
	//�赥�����ĸ赥���
	private int slws_songlistId;
	//�赥�����ĸ������
	private int slws_songId;
	//�赥�������ղ�ʱ��
	private Date slws_collectionDate;
	
	public SonglistWithSong() {
		super();
	}

	public int getSlws_id() {
		return slws_id;
	}

	public void setSlws_id(int slws_id) {
		this.slws_id = slws_id;
	}

	public int getSlws_songlistId() {
		return slws_songlistId;
	}

	public void setSlws_songlistId(int slws_songlistId) {
		this.slws_songlistId = slws_songlistId;
	}

	public int getSlws_songId() {
		return slws_songId;
	}

	public void setSlws_songId(int slws_songId) {
		this.slws_songId = slws_songId;
	}

	public Date getSlws_collectionDate() {
		return slws_collectionDate;
	}

	public void setSlws_collectionDate(Date slws_collectionDate) {
		this.slws_collectionDate = slws_collectionDate;
	}
	
}
