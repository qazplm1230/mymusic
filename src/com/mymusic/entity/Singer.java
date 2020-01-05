package com.mymusic.entity;

import java.util.Date;

/**
 * 歌手类
 * @author 
 *
 */
public class Singer {
	//歌手编号
	private int sg_id;
	//歌手姓名
	private String sg_name;
	//歌手被访问次数
	private int sg_accessCount;
	//歌手被收藏次数
	private int sg_collectionCount;
	//歌手所属地区编号，外键
	private int sg_areaId;
	//歌手简介
	private String sg_introduce;
	//歌手生日
	private Date sg_birthday;
	//歌手性别（0表示女，1表示男）
	private int sg_sex;
	//歌手封面地址
	private String sg_coverUrl;
	//歌手出道年份
	private int sg_debutDate;
	//歌手状态
	private int sg_stateId;
	
	public Singer() {
		super();
	}

	public int getSg_id() {
		return sg_id;
	}

	public void setSg_id(int sg_id) {
		this.sg_id = sg_id;
	}

	public String getSg_name() {
		return sg_name;
	}

	public void setSg_name(String sg_name) {
		this.sg_name = sg_name;
	}

	public int getSg_accessCount() {
		return sg_accessCount;
	}

	public void setSg_accessCount(int sg_accessCount) {
		this.sg_accessCount = sg_accessCount;
	}

	public int getSg_collectionCount() {
		return sg_collectionCount;
	}

	public void setSg_collectionCount(int sg_collectionCount) {
		this.sg_collectionCount = sg_collectionCount;
	}

	public int getSg_areaId() {
		return sg_areaId;
	}

	public void setSg_areaId(int sg_areaId) {
		this.sg_areaId = sg_areaId;
	}

	public String getSg_introduce() {
		return sg_introduce;
	}

	public void setSg_introduce(String sg_introduce) {
		this.sg_introduce = sg_introduce;
	}

	public Date getSg_birthday() {
		return sg_birthday;
	}

	public void setSg_birthday(Date sg_birthday) {
		this.sg_birthday = sg_birthday;
	}

	public int getSg_sex() {
		return sg_sex;
	}

	public void setSg_sex(int sg_sex) {
		this.sg_sex = sg_sex;
	}

	public String getSg_coverUrl() {
		return sg_coverUrl;
	}

	public void setSg_coverUrl(String sg_coverUrl) {
		this.sg_coverUrl = sg_coverUrl;
	}

	public int getSg_debutDate() {
		return sg_debutDate;
	}

	public void setSg_debutDate(int sg_debutDate) {
		this.sg_debutDate = sg_debutDate;
	}

	public int getSg_stateId() {
		return sg_stateId;
	}

	public void setSg_stateId(int sg_stateId) {
		this.sg_stateId = sg_stateId;
	}
	
}
