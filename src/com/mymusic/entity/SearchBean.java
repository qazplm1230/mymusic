package com.mymusic.entity;

import java.util.List;
/**
 * �첽ajax�������ص����ݶ���
 * @author 
 *
 */
public class SearchBean {

	//��������
	private List<Song> songs;
	//���ּ���
	private List<Singer> singers;
	//ר������
	private List<Cd> cds;
	
	public SearchBean() {
		super();
	}
	public List<Song> getSongs() {
		return songs;
	}
	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
	public List<Singer> getSingers() {
		return singers;
	}
	public void setSingers(List<Singer> singers) {
		this.singers = singers;
	}
	public List<Cd> getCds() {
		return cds;
	}
	public void setCds(List<Cd> cds) {
		this.cds = cds;
	}

}
