package org.wuyi.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
@Entity
public class Template implements Serializable {

	private static final long serialVersionUID = 7675316853253482270L;

	@Id
	@Column(name = "tmp_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@ManyToOne
	@JoinColumn(name = "wf_id")
	private WorkFlow workFlow;
	
	@Column(name = "tmp_name")
	private String name;
	
	@Column(name = "tmp_path")
	private String path;
	
	@Column(name = "tmp_required")
	private String required;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public WorkFlow getWorkFlow() {
		return workFlow;
	}

	public void setWorkFlow(WorkFlow workFlow) {
		this.workFlow = workFlow;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getRequired() {
		return required;
	}

	public void setRequired(String required) {
		this.required = required;
	}
	
}