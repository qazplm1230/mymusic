package com.mymusic.entity;

import java.util.Date;

/**
 * 听歌历史类
 * @author 
 *
 */
public class HearSongHistory {
	//听歌历史的编号
	private int hsh_id;
	//听歌历史的歌曲编号
	private int hsh_songId;
	//听歌历史的用户编号
	private int hsh_userId;
	//听歌历史的时间
	private Date hsh_date;
	//听歌记录中的歌曲信息
	private Song song;
	
	public HearSongHistory() {
		super();
	}

	public int getHsh_id() {
		return hsh_id;
	}

	public void setHsh_id(int hsh_id) {
		this.hsh_id = hsh_id;
	}

	public int getHsh_songId() {
		return hsh_songId;
	}

	public void setHsh_songId(int hsh_songId) {
		this.hsh_songId = hsh_songId;
	}

	public int getHsh_userId() {
		return hsh_userId;
	}

	public void setHsh_userId(int hsh_userId) {
		this.hsh_userId = hsh_userId;
	}

	public Date getHsh_date() {
		return hsh_date;
	}

	public void setHsh_date(Date hsh_date) {
		this.hsh_date = hsh_date;
	}

	public Song getSong() {
		return song;
	}

	public void setSong(Song song) {
		this.song = song;
	}
	
}
