package org.wuyi.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
@Entity
public class WorkFlow implements Serializable {

	private static final long serialVersionUID = -2970905897563790496L;

	@Id
	@Column(name = "wf_id")
	private String id;

	@Column(name = "wf_name")
	private String name;
	
	@Column(name = "wf_approver")
	private String approver;

	@Column(name = "wf_reviewer")
	private String reviewer;

	@Column(name = "wf_entity_name")
	private String entityName;
	
	@Column(name = "wf_add_url")
	private String addUrl;
	
	@Column(name = "wf_update_url")
	private String updateUrl;
	
	@Column(name = "wf_detail_url")
	private String detailUrl;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getApprover() {
		return approver;
	}

	public void setApprover(String approver) {
		this.approver = approver;
	}

	public String getReviewer() {
		return reviewer;
	}

	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getAddUrl() {
		return addUrl;
	}

	public void setAddUrl(String addUrl) {
		this.addUrl = addUrl;
	}

	public String getUpdateUrl() {
		return updateUrl;
	}

	public void setUpdateUrl(String updateUrl) {
		this.updateUrl = updateUrl;
	}

	public String getDetailUrl() {
		return detailUrl;
	}

	public void setDetailUrl(String detailUrl) {
		this.detailUrl = detailUrl;
	}

}