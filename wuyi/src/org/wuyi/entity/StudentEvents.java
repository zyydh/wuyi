package org.wuyi.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonAutoDetect
@Entity
public class StudentEvents implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "event_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User maker;
	
	@Column(name = "unit_name")
	private String unitName;

	@Column(name = "unit_contact")
	private String unitContact;
	
	@Column(name = "unit_tel")
	private String unitTel;
	
	@Column(name = "student_name")
	private String studentName;
	
	@Column(name = "student_native")
	private String studentNative;
	
	@Column(name = "sex")
	private String sex;
	
	@Column(name = "birthday")
	private String birthday;
	
	@Column(name = "tel")
	private String tel;
	
	@Column(name = "classes")
	private String classes;
	
	@Column(name = "father_name")
	private String fatherName;
	
	@Column(name = "father_tel")
	private String fatherTel;
	
	@Column(name = "instructor")
	private String instructor;
	
	@Column(name = "event_addr")
	private String eventAddr;
	
	@Column(name = "event_time")
	private String eventTime;
	
	@Column(name = "event_type")
	private String eventType;
	
	@Column(name = "family_desc")
	private String familyDesc;
	
	@Column(name = "school_desc")
	private String schoolDesc;
	
	@Column(name = "mental_status")
	private String mentalStatus;
	
	@Column(name = "has_protect")
	private String hasProtect;
	
	@Column(name = "die_count")
	private String dieCount;
	
	@Column(name = "hurt_count")
	private String hurtCount;
	
	@Column(name = "event_detail")
	private String eventDetail;
	
	@Column(name = "unit_incharg")
	private String unitIncharg;
	
	@Column(name = "submit_time")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern ="yyyy-MM-dd", timezone="GMT+8")
	private Date submitTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getMaker() {
		return maker;
	}

	public void setMaker(User maker) {
		this.maker = maker;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getUnitContact() {
		return unitContact;
	}

	public void setUnitContact(String unitContact) {
		this.unitContact = unitContact;
	}

	public String getUnitTel() {
		return unitTel;
	}

	public void setUnitTel(String unitTel) {
		this.unitTel = unitTel;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentNative() {
		return studentNative;
	}

	public void setStudentNative(String studentNative) {
		this.studentNative = studentNative;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
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

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public String getEventAddr() {
		return eventAddr;
	}

	public void setEventAddr(String eventAddr) {
		this.eventAddr = eventAddr;
	}

	public String getEventTime() {
		return eventTime;
	}

	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getFamilyDesc() {
		return familyDesc;
	}

	public void setFamilyDesc(String familyDesc) {
		this.familyDesc = familyDesc;
	}

	public String getSchoolDesc() {
		return schoolDesc;
	}

	public void setSchoolDesc(String schoolDesc) {
		this.schoolDesc = schoolDesc;
	}

	public String getMentalStatus() {
		return mentalStatus;
	}

	public void setMentalStatus(String mentalStatus) {
		this.mentalStatus = mentalStatus;
	}

	public String getHasProtect() {
		return hasProtect;
	}

	public void setHasProtect(String hasProtect) {
		this.hasProtect = hasProtect;
	}

	public String getDieCount() {
		return dieCount;
	}

	public void setDieCount(String dieCount) {
		this.dieCount = dieCount;
	}

	public String getHurtCount() {
		return hurtCount;
	}

	public void setHurtCount(String hurtCount) {
		this.hurtCount = hurtCount;
	}

	public String getEventDetail() {
		return eventDetail;
	}

	public void setEventDetail(String eventDetail) {
		this.eventDetail = eventDetail;
	}

	public String getUnitIncharg() {
		return unitIncharg;
	}

	public void setUnitIncharg(String unitIncharg) {
		this.unitIncharg = unitIncharg;
	}

	public Date getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}
	
	
}