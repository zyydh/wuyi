package org.wuyi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
@Entity
@PrimaryKeyJoinColumn(name = "item_id")
public class LoanHbl extends WorkFlowItem {

	private static final long serialVersionUID = -4972971069997402799L;

	@Column (name = "loan_jxj")
	private String jxj;
	
	@Column (name = "loan_native_type")
	private String nativeType;
	
	@Column (name = "loan_addr")
	private String  addr;
	
	@Column (name = "loan_tel")
	private String tel;

	@Column (name = "loan_total_count")
	private String totalCount;
	
	@Column (name = "loan_total_income")
	private String totalIncome;
	
	@Column (name = "loan_people_income")
	private String peopleIncome;
	
	@Column (name = "loan_income_from")
	private String incomeFrom;
	
	@Column (name = "loan_family_name1")
	private String familyName1;
	
	@Column (name = "loan_family_age1")
	private String familyAge1;
	
	@Column (name = "loan_family_relate1")
	private String familyRelate1;
	
	@Column (name = "loan_family_unit1")
	private String familyUnit1;
	
	@Column (name = "loan_family_name2")
	private String familyName2;
	
	@Column (name = "loan_family_age2")
	private String familyAge2;
	
	@Column (name = "loan_family_relate2")
	private String familyRelate2;
	
	@Column (name = "loan_family_unit2")
	private String familyUnit2;
	
	@Column (name = "loan_family_name3")
	private String familyName3;
	
	@Column (name = "loan_family_age3")
	private String familyAge3;
	
	@Column (name = "loan_family_relate3")
	private String familyRelate3;
	
	@Column (name = "loan_family_unit3")
	private String familyUnit3;
	
	@Column (name = "loan_family_name4")
	private String familyName4;
	
	@Column (name = "loan_family_age4")
	private String familyAge4;
	
	@Column (name = "loan_family_relate4")
	private String familyRelate4;
	
	@Column (name = "loan_family_unit4")
	private String familyUnit4;
	
	@Column (name = "loan_reason")
	private String reason;

	public String getJxj() {
		return jxj;
	}

	public void setJxj(String jxj) {
		this.jxj = jxj;
	}

	public String getNativeType() {
		return nativeType;
	}

	public void setNativeType(String nativeType) {
		this.nativeType = nativeType;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
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

	public String getIncomeFrom() {
		return incomeFrom;
	}

	public void setIncomeFrom(String incomeFrom) {
		this.incomeFrom = incomeFrom;
	}

	public String getFamilyName1() {
		return familyName1;
	}

	public void setFamilyName1(String familyName1) {
		this.familyName1 = familyName1;
	}

	public String getFamilyAge1() {
		return familyAge1;
	}

	public void setFamilyAge1(String familyAge1) {
		this.familyAge1 = familyAge1;
	}

	public String getFamilyRelate1() {
		return familyRelate1;
	}

	public void setFamilyRelate1(String familyRelate1) {
		this.familyRelate1 = familyRelate1;
	}

	public String getFamilyUnit1() {
		return familyUnit1;
	}

	public void setFamilyUnit1(String familyUnit1) {
		this.familyUnit1 = familyUnit1;
	}

	public String getFamilyName2() {
		return familyName2;
	}

	public void setFamilyName2(String familyName2) {
		this.familyName2 = familyName2;
	}

	public String getFamilyAge2() {
		return familyAge2;
	}

	public void setFamilyAge2(String familyAge2) {
		this.familyAge2 = familyAge2;
	}

	public String getFamilyRelate2() {
		return familyRelate2;
	}

	public void setFamilyRelate2(String familyRelate2) {
		this.familyRelate2 = familyRelate2;
	}

	public String getFamilyUnit2() {
		return familyUnit2;
	}

	public void setFamilyUnit2(String familyUnit2) {
		this.familyUnit2 = familyUnit2;
	}

	public String getFamilyName3() {
		return familyName3;
	}

	public void setFamilyName3(String familyName3) {
		this.familyName3 = familyName3;
	}

	public String getFamilyAge3() {
		return familyAge3;
	}

	public void setFamilyAge3(String familyAge3) {
		this.familyAge3 = familyAge3;
	}

	public String getFamilyRelate3() {
		return familyRelate3;
	}

	public void setFamilyRelate3(String familyRelate3) {
		this.familyRelate3 = familyRelate3;
	}

	public String getFamilyUnit3() {
		return familyUnit3;
	}

	public void setFamilyUnit3(String familyUnit3) {
		this.familyUnit3 = familyUnit3;
	}

	public String getFamilyName4() {
		return familyName4;
	}

	public void setFamilyName4(String familyName4) {
		this.familyName4 = familyName4;
	}

	public String getFamilyAge4() {
		return familyAge4;
	}

	public void setFamilyAge4(String familyAge4) {
		this.familyAge4 = familyAge4;
	}

	public String getFamilyRelate4() {
		return familyRelate4;
	}

	public void setFamilyRelate4(String familyRelate4) {
		this.familyRelate4 = familyRelate4;
	}

	public String getFamilyUnit4() {
		return familyUnit4;
	}

	public void setFamilyUnit4(String familyUnit4) {
		this.familyUnit4 = familyUnit4;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
	
}
