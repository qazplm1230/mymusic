package com.mymusic.entity;
/**
 * �����
 * @author 
 *
 */
public class Type {
	//�����
	private int t_id;
	//�������
	private String t_name;
	//���ȼ�
	private  int t_greed;
	//��һ�������
	private int t_parentId;
	
	public Type() {
		super();
	}

	public int getT_id() {
		return t_id;
	}

	public void setT_id(int t_id) {
		this.t_id = t_id;
	}

	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}

	public int getT_greed() {
		return t_greed;
	}

	public void setT_greed(int t_greed) {
		this.t_greed = t_greed;
	}

	public int getT_parentId() {
		return t_parentId;
	}

	public void setT_parentId(int t_parentId) {
		this.t_parentId = t_parentId;
	}
	
}
