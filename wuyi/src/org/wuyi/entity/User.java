package org.wuyi.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonAutoDetect
@Entity
@Inheritance(strategy= InheritanceType.JOINED)
public class User implements Serializable {

	private static final long serialVersionUID = -7692712195056980663L;

	@Id
	@Column (name = "user_id")
	protected String userId;
	
	@Column (name = "user_type")
	protected String userType;
	
	@Column (name = "password")
	protected String password;
	
	@Column (name = "name")
	protected String name;
	
	@Column (name = "sex")
	protected String sex;
	
	@Column (name = "birthday")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern ="yyyy-MM-dd", timezone="GMT+8")
	protected Date birthday;
	
	@Column (name = "tel")
	protected String tel;
	
	@Column (name = "mail")
	protected String mail;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
}
