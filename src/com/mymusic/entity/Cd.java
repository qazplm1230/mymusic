package com.mymusic.entity;
/**
 * ר����
 */
import java.util.Date;
import java.util.List;

public class Cd {
	//ר�����
	private int c_id;
	//ר������
	private String c_name;
	//ר�������ַ
	private String c_coverUrl;
	//ר����������
	private int c_songCount;
	//ר������ʱ��
	private Date c_publishDate;
	//ר���������ֱ�ţ����
	private int c_singerId;
	//ר�����
	private String c_introduce;
	//ר���ղ�����
	private int c_collectionCount;
	//ר��ת̬
	private int c_stateId;
	//ר����������
	private Singer singer;
	//ר�������ĸ���
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
