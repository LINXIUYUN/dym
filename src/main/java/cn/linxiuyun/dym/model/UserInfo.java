package cn.linxiuyun.dym.model;

import java.io.Serializable;


public class UserInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	//columns START
	/**ID*/
	private Integer id;
	/**用户账户鉴权信息表关联ID*/
	private Integer userAuthenticId;
	/**姓名*/
	private String name;
	/**出生时间*/
	private java.util.Date birthday;
	/**入团时间*/
	private java.util.Date joinCylTime;
	/**民族*/
	private String nation;
	/**省份*/
	private String province;
	/**市*/
	private String city;
	/**县/区*/
	private String district;
	/**婚姻状态 0:未婚,1:已婚,2:离异*/
	private Integer maritalStatus;
	/**身份证号*/
	private String idNo;
	/**学历 0:本科 1:硕士研究生 2:博士研究生 3:其他*/
	private Integer education;
	/**专业班级*/
	private String majorAndClass;
	/**是否是党员，0:是,1:否*/
	private Integer isPartyMember;
	/**入党时间*/
	private java.util.Date partyTime;
	/**入党党支部所属省份*/
	private String partyProvince;
	/**入党党支部所属市*/
	private String partyCity;
	/**入党党支部所属县/区*/
	private String partyDistrict;
	/**备注*/
	private String remarks;
	/**性别 0:男,1:女*/
	private Integer gender;
	//columns END
	
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setUserAuthenticId(Integer userAuthenticId) {
		this.userAuthenticId = userAuthenticId;
	}
	
	public Integer getUserAuthenticId() {
		return this.userAuthenticId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}
	
	public java.util.Date getBirthday() {
		return this.birthday;
	}
	
	public void setJoinCylTime(java.util.Date joinCylTime) {
		this.joinCylTime = joinCylTime;
	}
	
	public java.util.Date getJoinCylTime() {
		return this.joinCylTime;
	}
	
	public void setNation(String nation) {
		this.nation = nation;
	}
	
	public String getNation() {
		return this.nation;
	}
	
	public void setProvince(String province) {
		this.province = province;
	}
	
	public String getProvince() {
		return this.province;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCity() {
		return this.city;
	}
	
	public void setDistrict(String district) {
		this.district = district;
	}
	
	public String getDistrict() {
		return this.district;
	}
	
	public void setMaritalStatus(Integer maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	
	public Integer getMaritalStatus() {
		return this.maritalStatus;
	}
	
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	
	public String getIdNo() {
		return this.idNo;
	}
	
	public void setEducation(Integer education) {
		this.education = education;
	}
	
	public Integer getEducation() {
		return this.education;
	}
	
	public void setMajorAndClass(String majorAndClass) {
		this.majorAndClass = majorAndClass;
	}
	
	public String getMajorAndClass() {
		return this.majorAndClass;
	}
	
	public void setIsPartyMember(Integer isPartyMember) {
		this.isPartyMember = isPartyMember;
	}
	
	public Integer getIsPartyMember() {
		return this.isPartyMember;
	}
	
	public void setPartyTime(java.util.Date partyTime) {
		this.partyTime = partyTime;
	}
	
	public java.util.Date getPartyTime() {
		return this.partyTime;
	}
	
	public void setPartyProvince(String partyProvince) {
		this.partyProvince = partyProvince;
	}
	
	public String getPartyProvince() {
		return this.partyProvince;
	}
	
	public void setPartyCity(String partyCity) {
		this.partyCity = partyCity;
	}
	
	public String getPartyCity() {
		return this.partyCity;
	}
	
	public void setPartyDistrict(String partyDistrict) {
		this.partyDistrict = partyDistrict;
	}
	
	public String getPartyDistrict() {
		return this.partyDistrict;
	}
	
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public String getRemarks() {
		return this.remarks;
	}
	
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	
	public Integer getGender() {
		return this.gender;
	}
}


