package com.mymusic.entity;
/**
 * 专辑类
 */
import java.util.Date;
import java.util.List;

public class Cd {
	//专辑编号
	private int c_id;
	//专辑名称
	private String c_name;
	//专辑封面地址
	private String c_coverUrl;
	//专辑歌曲数量
	private int c_songCount;
	//专辑发布时间
	private Date c_publishDate;
	//专辑所属歌手编号，外键
	private int c_singerId;
	//专辑简介
	private String c_introduce;
	//专辑收藏数量
	private int c_collectionCount;
	//专辑转态
	private int c_stateId;
	//专辑所属歌手
	private Singer singer;
	//专辑包含的歌曲
	private List<Song> songs;
	
	public Cd() {
		super();
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_coverUrl() {
		return c_coverUrl;
	}

	public void setC_coverUrl(String c_coverUrl) {
		this.c_coverUrl = c_coverUrl;
	}

	public int getC_songCount() {
		return c_songCount;
	}

	public void setC_songCount(int c_songCount) {
		this.c_songCount = c_songCount;
	}

	public Date getC_publishDate() {
		return c_publishDate;
	}

	public void setC_publishDate(Date c_publishDate) {
		this.c_publishDate = c_publishDate;
	}

	public int getC_singerId() {
		return c_singerId;
	}

	public void setC_singerId(int c_singerId) {
		this.c_singerId = c_singerId;
	}

	public String getC_introduce() {
		return c_introduce;
	}

	public void setC_introduce(String c_introduce) {
		this.c_introduce = c_introduce;
	}

	public int getC_collectionCount() {
		return c_collectionCount;
	}

	public void setC_collectionCount(int c_collectionCount) {
		this.c_collectionCount = c_collectionCount;
	}

	public int getC_stateId() {
		return c_stateId;
	}

	public void setC_stateId(int c_stateId) {
		this.c_stateId = c_stateId;
	}

	public Singer getSinger() {
		return singer;
	}

	public void setSinger(Singer singer) {
		this.singer = singer;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
	
}
