package com.mymusic.entity;

import java.util.Date;

/**
 * ¸èµ¥¸èÇúÀà
 * @author 
 *
 */
public class SonglistWithSong {
	//¸èµ¥¸èÇú±àºÅ
	private int slws_id;
	//¸èµ¥¸èÇúµÄ¸èµ¥±àºÅ
	private int slws_songlistId;
	//¸èµ¥¸èÇúµÄ¸èÇú±àºÅ
	private int slws_songId;
	//¸èµ¥¸èÇúµÄÊÕ²ØÊ±¼ä
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
