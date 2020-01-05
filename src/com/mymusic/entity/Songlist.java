package com.mymusic.entity;

import java.util.List;

/**
 * 歌单类
 * @author 
 *
 */
public class Songlist {
	//歌单编号
	private int sl_id;
	//创建该歌单的用户编号，外键
	private int sl_userId;
	//歌单名称
	private String sl_name;
	//歌单类别编号，外键
	private int sl_typeId;
	//歌单被访问次数
	private int sl_accessCount;
	//歌单简介
	private String sl_introduce;
	//歌单被收藏次数
	private int sl_collectionCount;
	//歌单封面地址
	private String sl_coverUrl;
	//歌单标签
	private String sl_tags;
	//歌单状态
	private int sl_stateId;
	//歌单包含的全部歌曲信息
	private List<Song> songs;
	//创建该歌单的用户信息
	private User user;
	
	public Songlist() {
		super();
	}
	
	public Songlist(int sl_userId, String sl_name, int sl_accessCount,
			int sl_collectionCount, String sl_coverUrl, int sl_stateId) {
		super();
		this.sl_userId = sl_userId;
		this.sl_name = sl_name;
		this.sl_accessCount = sl_accessCount;
		this.sl_collectionCount = sl_collectionCount;
		this.sl_coverUrl = sl_coverUrl;
		this.sl_stateId = sl_stateId;
	}

	public int getSl_id() {
		return sl_id;
	}

	public void setSl_id(int sl_id) {
		this.sl_id = sl_id;
	}

	public int getSl_userId() {
		return sl_userId;
	}

	public void setSl_userId(int sl_userId) {
		this.sl_userId = sl_userId;
	}

	public String getSl_name() {
		return sl_name;
	}

	public void setSl_name(String sl_name) {
		this.sl_name = sl_name;
	}

	public int getSl_typeId() {
		return sl_typeId;
	}

	public void setSl_typeId(int sl_typeId) {
		this.sl_typeId = sl_typeId;
	}

	public int getSl_accessCount() {
		return sl_accessCount;
	}

	public void setSl_accessCount(int sl_accessCount) {
		this.sl_accessCount = sl_accessCount;
	}

	public String getSl_introduce() {
		return sl_introduce;
	}

	public void setSl_introduce(String sl_introduce) {
		this.sl_introduce = sl_introduce;
	}

	public int getSl_collectionCount() {
		return sl_collectionCount;
	}

	public void setSl_collectionCount(int sl_collectionCount) {
		this.sl_collectionCount = sl_collectionCount;
	}

	public String getSl_tags() {
		return sl_tags;
	}

	public void setSl_tags(String sl_tags) {
		this.sl_tags = sl_tags;
	}

	public int getSl_stateId() {
		return sl_stateId;
	}

	public void setSl_stateId(int sl_stateId) {
		this.sl_stateId = sl_stateId;
	}

	public String getSl_coverUrl() {
		return sl_coverUrl;
	}

	public void setSl_coverUrl(String sl_coverUrl) {
		this.sl_coverUrl = sl_coverUrl;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
