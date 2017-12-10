package org.wuyi.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonAutoDetect
@Entity
@Inheritance(strategy= InheritanceType.JOINED)
public class WorkFlowItem implements Serializable {

	private static final long serialVersionUID = -4593981518524994565L;

	@Id
	@Column(name = "item_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected int id;

	@ManyToOne
	@JoinColumn(name = "wf_id")
	protected WorkFlow workFlow;
	
	@ManyToOne
	@JoinColumn(name = "item_maker")
	protected Student maker;
	
	@Column (name = "item_make_date")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern ="yyyy-MM-dd", timezone="GMT+8")
	protected Date makeDate;
	
	@ManyToOne
	@JoinColumn(name = "item_approver")
	protected Teacher approver;
	
	@Column (name = "item_approve_date")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern ="yyyy-MM-dd", timezone="GMT+8")
	protected Date approveDate;
	
	@Column (name = "item_approve_remark")
	protected String approveRemark;
	
	@ManyToOne
	@JoinColumn(name = "item_reviewer")
	protected Teacher reviewer;
	
	@Column (name = "item_review_date")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern ="yyyy-MM-dd", timezone="GMT+8")
	protected Date reviewDate;
	
	@Column (name = "item_review_remark")
	protected String reviewRemark;
	
	@ManyToOne
	@JoinColumn(name = "item_rejecter")
	protected Teacher rejecter;
	
	@Column (name = "item_reject_date")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern ="yyyy-MM-dd", timezone="GMT+8")
	protected Date rejectDate;
	
	@Column (name = "item_reject_remark")
	protected String rejectRemark;
	
	@Column(name = "item_status")
	protected String status;

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

	public Student getMaker() {
		return maker;
	}

	public void setMaker(Student maker) {
		this.maker = maker;
	}

	public Date getMakeDate() {
		return makeDate;
	}

	public void setMakeDate(Date makeDate) {
		this.makeDate = makeDate;
	}


	public Teacher getApprover() {
		return approver;
	}

	public void setApprover(Teacher approver) {
		this.approver = approver;
	}

	public Date getApproveDate() {
		return approveDate;
	}

	public void setApproveDate(Date approveDate) {
		this.approveDate = approveDate;
	}


	public Teacher getReviewer() {
		return reviewer;
	}

	public void setReviewer(Teacher reviewer) {
		this.reviewer = reviewer;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Teacher getRejecter() {
		return rejecter;
	}

	public void setRejecter(Teacher rejecter) {
		this.rejecter = rejecter;
	}

	public Date getRejectDate() {
		return rejectDate;
	}

	public void setRejectDate(Date rejectDate) {
		this.rejectDate = rejectDate;
	}

	public String getApproveRemark() {
		return approveRemark;
	}

	public void setApproveRemark(String approveRemark) {
		this.approveRemark = approveRemark;
	}

	public String getReviewRemark() {
		return reviewRemark;
	}

	public void setReviewRemark(String reviewRemark) {
		this.reviewRemark = reviewRemark;
	}

	public String getRejectRemark() {
		return rejectRemark;
	}

	public void setRejectRemark(String rejectRemark) {
		this.rejectRemark = rejectRemark;
	}
}