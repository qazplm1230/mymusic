package com.mymusic.entity;

import java.util.Date;

/**
 * 歌曲类
 * @author 
 *
 */
public class Song {
	//歌曲编号
	private int s_id;
	//歌曲名称
	private String s_name;
	//歌曲所属歌手编号，外键
	private int s_singerId;
	//歌曲所属专辑编号，外键
	private int s_cdId;
	//歌曲语种
	private String s_languageType;
	//歌曲被点播数量
	private int s_playCount;
	//歌曲被下载数量
	private int s_downloadCount;
	//歌曲被收藏数量
	private int s_collectionCount;
	//歌曲发布时间
	private Date s_publishDate;
	//歌曲文件地址
	private String s_songUrl;
	//歌曲歌词地址
	private String s_songWordUrl;
	//歌曲封面地址
	private String s_coverUrl;
	//歌曲时长
	private double s_time;
	//歌曲类型
	private int s_typeId;
	//歌曲状态
	private int s_stateId;
	//歌曲所属歌手
	private Singer singer;
	
	//歌手名字
	private String s_singername;
	
	
	
	public String getS_singername() {
		return s_singername;
	}

	public void setS_singername(String s_singername) {
		this.s_singername = s_singername;
	}

	public Song() {
		super();
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public int getS_singerId() {
		return s_singerId;
	}

	public void setS_singerId(int s_singerId) {
		this.s_singerId = s_singerId;
	}

	public int getS_cdId() {
		return s_cdId;
	}

	public void setS_cdId(int s_cdId) {
		this.s_cdId = s_cdId;
	}

	public String getS_languageType() {
		return s_languageType;
	}

	public void setS_languageType(String s_languageType) {
		this.s_languageType = s_languageType;
	}

	public int getS_playCount() {
		return s_playCount;
	}

	public void setS_playCount(int s_playCount) {
		this.s_playCount = s_playCount;
	}

	public int getS_downloadCount() {
		return s_downloadCount;
	}

	public void setS_downloadCount(int s_downloadCount) {
		this.s_downloadCount = s_downloadCount;
	}

	public int getS_collectionCount() {
		return s_collectionCount;
	}

	public void setS_collectionCount(int s_collectionCount) {
		this.s_collectionCount = s_collectionCount;
	}

	public Date getS_publishDate() {
		return s_publishDate;
	}

	public void setS_publishDate(Date s_publishDate) {
		this.s_publishDate = s_publishDate;
	}

	public String getS_songUrl() {
		return s_songUrl;
	}

	public void setS_songUrl(String s_songUrl) {
		this.s_songUrl = s_songUrl;
	}

	public String getS_songWordUrl() {
		return s_songWordUrl;
	}

	public void setS_songWordUrl(String s_songWordUrl) {
		this.s_songWordUrl = s_songWordUrl;
	}

	public String getS_coverUrl() {
		return s_coverUrl;
	}

	public void setS_coverUrl(String s_coverUrl) {
		this.s_coverUrl = s_coverUrl;
	}

	public double getS_time() {
		return s_time;
	}

	public void setS_time(double s_time) {
		this.s_time = s_time;
	}

	public int getS_typeId() {
		return s_typeId;
	}

	public void setS_typeId(int s_typeId) {
		this.s_typeId = s_typeId;
	}

	public int getS_stateId() {
		return s_stateId;
	}

	public void setS_stateId(int s_stateId) {
		this.s_stateId = s_stateId;
	}

	public Singer getSinger() {
		return singer;
	}

	public void setSinger(Singer singer) {
		this.singer = singer;
	}
	
	
}
