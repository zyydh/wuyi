package org.wuyi.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
@Entity
public class Classes implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cla_id")
	private String id;

	@Column(name = "cla_major")
	private String major;
	
	@Column(name = "cla_count")
	private int count;

	@ManyToOne
	@JoinColumn(name = "cla_instructor")
	private Teacher instructor;

	@ManyToOne
	@JoinColumn(name = "cla_class_mentor")
	private Teacher classMentor;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Teacher getInstructor() {
		return instructor;
	}

	public void setInstructor(Teacher instructor) {
		this.instructor = instructor;
	}

	public Teacher getClassMentor() {
		return classMentor;
	}

	public void setClassMentor(Teacher classMentor) {
		this.classMentor = classMentor;
	}

}