package com.mymusic.entity;

import java.util.List;
/**
 * 异步ajax搜索返回的数据对象
 * @author 
 *
 */
public class SearchBean {

	//歌曲集合
	private List<Song> songs;
	//歌手集合
	private List<Singer> singers;
	//专辑集合
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
