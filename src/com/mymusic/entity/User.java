package com.mymusic.entity;

import java.util.List;

/**
 * �û���
 * @author 
 *
 */
public class User {
	//�û����
	private int u_id;
	//�û���¼��
	private String u_loginId;
	//�û���¼����
	private String u_loginPwd;
	//�û��ǳ�
	private String u_userName;
	//�û��Ա�
	private String u_sex;
	//�û�����
	private String u_email;
	//�û��绰
	private String u_phone;
	//�û�ͷ��
	private String u_photo;
	//�û����
	private int u_userType;
	//�ղصĸ��ּ���
	private List<Singer> collectionSgs;
	//�ղص�ר��
	private List<Cd> collectionCds;
	//�û������ĸ赥
	private List<Songlist> createSonglists;
	//�û��ղصĸ赥
	private List<Songlist> collectionSonglists;
	//������ʷ����
	private List<HearSongHistory> heardSongs;
	
	public User() {
		super();
	}
	
	public User(String u_loginId, String u_loginPwd, String u_userName,
			String u_sex, String u_photo, int u_userType) {
		super();
		this.u_loginId = u_loginId;
		this.u_loginPwd = u_loginPwd;
		this.u_userName = u_userName;
		this.u_sex = u_sex;
		this.u_photo = u_photo;
		this.u_userType = u_userType;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public String getU_loginId() {
		return u_loginId;
	}

	public void setU_loginId(String u_loginId) {
		this.u_loginId = u_loginId;
	}

	public String getU_loginPwd() {
		return u_loginPwd;
	}

	public void setU_loginPwd(String u_loginPwd) {
		this.u_loginPwd = u_loginPwd;
	}

	public String getU_userName() {
		return u_userName;
	}

	public void setU_userName(String u_userName) {
		this.u_userName = u_userName;
	}

	public String getU_sex() {
		return u_sex;
	}

	public void setU_sex(String u_sex) {
		this.u_sex = u_sex;
	}

	public String getU_email() {
		return u_email;
	}

	public void setU_email(String u_email) {
		this.u_email = u_email;
	}

	public String getU_phone() {
		return u_phone;
	}

	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}

	public String getU_photo() {
		return u_photo;
	}

	public void setU_photo(String u_photo) {
		this.u_photo = u_photo;
	}

	public int getU_userType() {
		return u_userType;
	}

	public void setU_userType(int u_userType) {
		this.u_userType = u_userType;
	}

	public List<Singer> getCollectionSgs() {
		return collectionSgs;
	}

	public void setCollectionSgs(List<Singer> collectionSgs) {
		this.collectionSgs = collectionSgs;
	}

	public List<Cd> getCollectionCds() {
		return collectionCds;
	}

	public void setCollectionCds(List<Cd> collectionCds) {
		this.collectionCds = collectionCds;
	}

	public List<Songlist> getCreateSonglists() {
		return createSonglists;
	}

	public void setCreateSonglists(List<Songlist> createSonglists) {
		this.createSonglists = createSonglists;
	}

	public List<HearSongHistory> getHeardSongs() {
		return heardSongs;
	}

	public void setHeardSongs(List<HearSongHistory> heardSongs) {
		this.heardSongs = heardSongs;
	}

	public List<Songlist> getCollectionSonglists() {
		return collectionSonglists;
	}

	public void setCollectionSonglists(List<Songlist> collectionSonglists) {
		this.collectionSonglists = collectionSonglists;
	}

	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", u_loginId=" + u_loginId
				+ ", u_loginPwd=" + u_loginPwd + ", u_userName=" + u_userName
				+ ", u_sex=" + u_sex + ", u_email=" + u_email + ", u_phone="
				+ u_phone + ", u_photo=" + u_photo + ", u_userType="
				+ u_userType + ", collectionSgs=" + collectionSgs
				+ ", collectionCds=" + collectionCds + ", createSonglists="
				+ createSonglists + ", collectionSonglists="
				+ collectionSonglists + ", heardSongs=" + heardSongs + "]";
	}

	
}
