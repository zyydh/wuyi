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
public class Attachment implements Serializable {

	private static final long serialVersionUID = 7675316853253482270L;

	@Id
	@Column(name = "ath_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@ManyToOne
	@JoinColumn(name = "item_id")
	private WorkFlowItem workFlowItem;
	
	@Column(name = "ath_name")
	private String name;
	
	@Column(name = "ath_path")
	private String path;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public WorkFlowItem getWorkFlowItem() {
		return workFlowItem;
	}

	public void setWorkFlowItem(WorkFlowItem workFlowItem) {
		this.workFlowItem = workFlowItem;
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

}