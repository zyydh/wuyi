package org.wuyi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
@Entity
@PrimaryKeyJoinColumn(name = "user_id")
public class Student extends User {

	private static final long serialVersionUID = 959543034988899222L;
	
	@ManyToOne
	@JoinColumn(name = "cla_id")
	private Classes classes;
	
	@Column(name = "std_idcard")
	private String idcard;
	
	@Column(name = "std_from")
	private String from;
	
	@Column(name = "std_grade")
	private String grade;
	
	@Column(name = "std_school_year")
	private String schoolYear;

	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}
	
	
}
