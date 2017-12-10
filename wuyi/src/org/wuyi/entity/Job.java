package org.wuyi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonAutoDetect
@Entity
@PrimaryKeyJoinColumn(name = "item_id")
public class Job extends WorkFlowItem {

	private static final long serialVersionUID = 8342262175675981446L;

	@Column (name = "job_go")
	private String go;
	
	@Column (name = "job_unit_code")
	private String unitCode;
	
	@Column (name = "job_unit_name")
	private String unitName;
	
	@Column (name = "job_unit_type")
	private String unitType;
	
	@Column (name = "job_unit_industry")
	private String unitIndustry;
	
	@Column (name = "job_unit_area")
	private String unitArea;
	
	@Column (name = "job_unit_contacts")
	private String unitContacts;
	
	@Column (name = "job_unit_tel")
	private String unitTel;
	
	@Column (name = "job_type")
	private String type;
	
	@Column (name = "job_payment")
	private int payment;

	@Column (name = "job_date")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern ="yyyy-MM-dd", timezone="GMT+8")
	private Date date;

	@Column (name = "job_reason")
	private String reason;

	@Column (name = "job_match")
	private String match;

	@Column (name = "job_hard")
	private String hard;

	public String getGo() {
		return go;
	}

	public void setGo(String go) {
		this.go = go;
	}

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getUnitType() {
		return unitType;
	}

	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}

	public String getUnitIndustry() {
		return unitIndustry;
	}

	public void setUnitIndustry(String unitIndustry) {
		this.unitIndustry = unitIndustry;
	}

	public String getUnitArea() {
		return unitArea;
	}

	public void setUnitArea(String unitArea) {
		this.unitArea = unitArea;
	}

	public String getUnitContacts() {
		return unitContacts;
	}

	public void setUnitContacts(String unitContacts) {
		this.unitContacts = unitContacts;
	}

	public String getUnitTel() {
		return unitTel;
	}

	public void setUnitTel(String unitTel) {
		this.unitTel = unitTel;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getMatch() {
		return match;
	}

	public void setMatch(String match) {
		this.match = match;
	}

	public String getHard() {
		return hard;
	}

	public void setHard(String hard) {
		this.hard = hard;
	}
	
}
