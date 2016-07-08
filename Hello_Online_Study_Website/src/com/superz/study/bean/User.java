package com.superz.study.bean;

import java.util.Date;

/**
 * UserBean类
 * 
 * @author RZ_Jackson
 *
 */
public class User {
	private Integer id;

	private String username;

	private String password;

	private int status;

	private String sex;

	private String realname;

	private String birthday;

	private String email;

	private String ipCreated;

	private String ipLastActived;

	private Date dateLastActived;

	private Date dateCreated;
	
	private String img;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer id, String username, String password, int status, String sex, String realname, String birthday,
			String email, String ipCreated, String ipLastActived, Date dateLastActived, Date dateCreated, String img) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.status = status;
		this.sex = sex;
		this.realname = realname;
		this.birthday = birthday;
		this.email = email;
		this.ipCreated = ipCreated;
		this.ipLastActived = ipLastActived;
		this.dateLastActived = dateLastActived;
		this.dateCreated = dateCreated;
		this.img = img;
	}

	public User(Integer id, String username, String password, int status, String sex, String realname, String birthday,
			String email, String ipCreated, String ipLastActived, Date dateLastActived, Date dateCreated) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.status = status;
		this.sex = sex;
		this.realname = realname;
		this.birthday = birthday;
		this.email = email;
		this.ipCreated = ipCreated;
		this.ipLastActived = ipLastActived;
		this.dateLastActived = dateLastActived;
		this.dateCreated = dateCreated;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIpCreated() {
		return ipCreated;
	}

	public void setIpCreated(String ipCreated) {
		this.ipCreated = ipCreated;
	}

	public String getIpLastActived() {
		return ipLastActived;
	}

	public void setIpLastActived(String ipLastActived) {
		this.ipLastActived = ipLastActived;
	}

	public Date getDateLastActived() {
		return dateLastActived;
	}

	public void setDateLastActived(Date dateLastActived) {
		this.dateLastActived = dateLastActived;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", status=" + status + ", sex="
				+ sex + ", realname=" + realname + ", birthday=" + birthday + ", email=" + email + ", ipCreated="
				+ ipCreated + ", ipLastActived=" + ipLastActived + ", dateLastActived=" + dateLastActived
				+ ", dateCreated=" + dateCreated + "+img="+img+"]";
	}

}
