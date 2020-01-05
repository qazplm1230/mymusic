package com.mymusic.entity;

import java.util.Date;

/**
 * 歌单评论类
 * @author 
 *
 */
public class SonglistComment {
	//歌单评论编号
	private int slc_id;
	//歌单评论的歌单编号
	private int slc_songlistId;
	//歌单评论的用户编号
	private int slc_userId;
	//歌单评论的内容
	private String slc_text;
	//歌单评论的时间
	private Date slc_time;
	//歌单评论被点赞数量
	private int slc_praiseCount;
	//评论该歌单的用户
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
