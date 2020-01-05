package com.mymusic.entity;

import java.util.List;

/**
 * 分页类
 * @author yichong
 *
 */
public class PageBean {
private int totalCount;//总记录数
private int totalPage;//总页数
private int size=10;//每页显示的条数
private int currPage;//当前的页数
private int beginNum;
private int endNum;
private List data;//存一页数据
public List getData() {
	return data;
}
public void setData(List data) {
	this.data = data;
}
public int getTotalCount() {
	return totalCount;
}
public void setTotalCount(int totalCount) {
	this.totalCount = totalCount;
	//设置总记录时同时算出总页数
	this.totalPage=totalCount/size;
	if(totalCount%size!=0){
		this.totalPage++;
	}
}
public int getTotalPage() {
	return totalPage;
}
public void setTotalPage(int totalPage) {
	this.totalPage = totalPage;
}
public int getSize() {
	return size;
}
public void setSize(int size) {
	this.size = size;
}
public int getCurrPage() {
	return currPage;
}
public void setCurrPage(int currPage) {
	this.currPage = currPage;
	//设置当前页，自动算出首尾的页码
	if(totalPage<=10){
		this.beginNum=1;
		this.endNum=this.totalPage;
	}else{//大于10
		this.beginNum=this.currPage-5;
		this.endNum=this.currPage+4;
		if(beginNum<=0){
			this.beginNum=1;
			this.endNum=10;
		}
		if(endNum>totalPage){
			this.beginNum=totalPage-9;
			this.endNum=totalPage;
		}
	}
}
public int getBeginNum() {
	return beginNum;
}
public void setBeginNum(int beginNum) {
	this.beginNum = beginNum;
}
public int getEndNum() {
	return endNum;
}
public void setEndNum(int endNum) {
	this.endNum = endNum;
}

}
