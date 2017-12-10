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
public class LoanStudent extends WorkFlowItem {

	private static final long serialVersionUID = -4972971069997402799L;

	@Column (name = "load_native")
	private String nativeAddr;
	
	@Column (name = "load_zip_code")
	private String zipCode;
	
	@Column (name = "load_addr")
	private String  addr;
	
	@Column (name = "load_marry")
	private String marry;
	
	@Column (name = "load_tel")
	private String tel;

	@Column (name = "load_mobile")
	private String mobile;
	
	@Column (name = "load_total_count")
	private String totalCount;
	
	@Column (name = "load_total_income")
	private String totalIncome;
	
	@Column (name = "load_people_income")
	private String peopleIncome;
	
	@Column (name = "load_father_name")
	private String fatherName;
	
	@Column (name = "load_father_tel")
	private String fatherTel;
	
	@Column (name = "load_father_idcard")
	private String fatherIdcard;
	
	@Column (name = "load_father_work")
	private String fatherWork;
	
	@Column (name = "load_father_mobile")
	private String fatherMobile;
	
	@Column (name = "load_mother_name")
	private String motherName;
	
	@Column (name = "load_mother_tel")
	private String motherTel;
	
	@Column (name = "load_mother_idcard")
	private String motherIdcard;
	
	@Column (name = "load_mother_work")
	private String motherWork;
	
	@Column (name = "load_mother_mobile")
	private String motherMobile;
	
	@Column (name = "load_other_name")
	private String otherName;
	
	@Column (name = "load_other_tel")
	private String otherTel;
	
	@Column (name = "load_other_idcard")
	private String otherIdcard;
	
	@Column (name = "load_other_work")
	private String otherWork;
	
	@Column (name = "load_other_mobile")
	private String otherMobile;
	
	@Column (name = "load_reason")
	private String reason;
	
	@Column (name = "load_type")
	private String type;
	
	@Column (name = "load_qq")
	private String qq;
	
	@Column (name = "load_amount")
	private int amount;

	public String getNativeAddr() {
		return nativeAddr;
	}

	public void setNativeAddr(String nativeAddr) {
		this.nativeAddr = nativeAddr;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getMarry() {
		return marry;
	}

	public void setMarry(String marry) {
		this.marry = marry;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	public String getTotalIncome() {
		return totalIncome;
	}

	public void setTotalIncome(String totalIncome) {
		this.totalIncome = totalIncome;
	}

	public String getPeopleIncome() {
		return peopleIncome;
	}

	public void setPeopleIncome(String peopleIncome) {
		this.peopleIncome = peopleIncome;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getFatherTel() {
		return fatherTel;
	}

	public void setFatherTel(String fatherTel) {
		this.fatherTel = fatherTel;
	}

	public String getFatherIdcard() {
		return fatherIdcard;
	}

	public void setFatherIdcard(String fatherIdcard) {
		this.fatherIdcard = fatherIdcard;
	}

	public String getFatherWork() {
		return fatherWork;
	}

	public void setFatherWork(String fatherWork) {
		this.fatherWork = fatherWork;
	}

	public String getFatherMobile() {
		return fatherMobile;
	}

	public void setFatherMobile(String fatherMobile) {
		this.fatherMobile = fatherMobile;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getMotherTel() {
		return motherTel;
	}

	public void setMotherTel(String motherTel) {
		this.motherTel = motherTel;
	}

	public String getMotherIdcard() {
		return motherIdcard;
	}

	public void setMotherIdcard(String motherIdcard) {
		this.motherIdcard = motherIdcard;
	}

	public String getMotherWork() {
		return motherWork;
	}

	public void setMotherWork(String motherWork) {
		this.motherWork = motherWork;
	}

	public String getMotherMobile() {
		return motherMobile;
	}

	public void setMotherMobile(String motherMobile) {
		this.motherMobile = motherMobile;
	}

	public String getOtherName() {
		return otherName;
	}

	public void setOtherName(String otherName) {
		this.otherName = otherName;
	}

	public String getOtherTel() {
		return otherTel;
	}

	public void setOtherTel(String otherTel) {
		this.otherTel = otherTel;
	}

	public String getOtherIdcard() {
		return otherIdcard;
	}

	public void setOtherIdcard(String otherIdcard) {
		this.otherIdcard = otherIdcard;
	}

	public String getOtherWork() {
		return otherWork;
	}

	public void setOtherWork(String otherWork) {
		this.otherWork = otherWork;
	}

	public String getOtherMobile() {
		return otherMobile;
	}

	public void setOtherMobile(String otherMobile) {
		this.otherMobile = otherMobile;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}
	
	
}
