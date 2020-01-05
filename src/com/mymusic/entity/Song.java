package com.mymusic.entity;

import java.util.Date;

/**
 * ������
 * @author 
 *
 */
public class Song {
	//�������
	private int s_id;
	//��������
	private String s_name;
	//�����������ֱ�ţ����
	private int s_singerId;
	//��������ר����ţ����
	private int s_cdId;
	//��������
	private String s_languageType;
	//�������㲥����
	private int s_playCount;
	//��������������
	private int s_downloadCount;
	//�������ղ�����
	private int s_collectionCount;
	//��������ʱ��
	private Date s_publishDate;
	//�����ļ���ַ
	private String s_songUrl;
	//������ʵ�ַ
	private String s_songWordUrl;
	//���������ַ
	private String s_coverUrl;
	//����ʱ��
	private double s_time;
	//��������
	private int s_typeId;
	//����״̬
	private int s_stateId;
	//������������
	private Singer singer;
	
	//��������
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
