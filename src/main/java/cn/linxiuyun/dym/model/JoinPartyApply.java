package cn.linxiuyun.dym.model;

import java.io.Serializable;


public class JoinPartyApply implements Serializable {
	
	private static final long serialVersionUID = 1L;

	//columns START
	/**id*/
	private Integer id;
	/**用户账户鉴权信息表关联ID*/
	private Integer userAuthenticId;
	/**姓名*/
	private String name;
	/**出生时间*/
	private java.util.Date birthday;
	/**性别 0:男,1:女*/
	private Integer gender;
	/**民族*/
	private String nation;
	/**入团时间*/
	private java.util.Date partTime;
	/**学历*/
	private String education;
	/**学位或职称*/
	private String degreeOrTitle;
	/**参见工作时间*/
	private java.util.Date joinWorkDate;
	/**籍贯*/
	private String placeOfOrigin;
	/**出生地*/
	private String birthPlace;
	/**单位、职务或职业*/
	private String workpalceAndOccupation;
	/**现居住地*/
	private String residentialAddress;
	/**身份证号*/
	private String idNo;
	/**第一次申请入党时间*/
	private String firstJoinPartyTime;
	/**确定入党积极分子意见*/
	private String opinionOfEnthusiast;
	/**负责培养联系人*/
	private String cultivator;
	/**培养人党内职务*/
	private String cultivatorDuties;
	/**培养联系人意见*/
	private String opinionOfCultivator;
	/**党支部意见*/
	private String opinionOfBranch;
	/**申请书文件路径*/
	private String applicationFileUrl;
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
	
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	
	public Integer getGender() {
		return this.gender;
	}
	
	public void setNation(String nation) {
		this.nation = nation;
	}
	
	public String getNation() {
		return this.nation;
	}
	
	public void setPartTime(java.util.Date partTime) {
		this.partTime = partTime;
	}
	
	public java.util.Date getPartTime() {
		return this.partTime;
	}
	
	public void setEducation(String education) {
		this.education = education;
	}
	
	public String getEducation() {
		return this.education;
	}
	
	public void setDegreeOrTitle(String degreeOrTitle) {
		this.degreeOrTitle = degreeOrTitle;
	}
	
	public String getDegreeOrTitle() {
		return this.degreeOrTitle;
	}
	
	public void setJoinWorkDate(java.util.Date joinWorkDate) {
		this.joinWorkDate = joinWorkDate;
	}
	
	public java.util.Date getJoinWorkDate() {
		return this.joinWorkDate;
	}
	
	public void setPlaceOfOrigin(String placeOfOrigin) {
		this.placeOfOrigin = placeOfOrigin;
	}
	
	public String getPlaceOfOrigin() {
		return this.placeOfOrigin;
	}
	
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
	
	public String getBirthPlace() {
		return this.birthPlace;
	}
	
	public void setWorkpalceAndOccupation(String workpalceAndOccupation) {
		this.workpalceAndOccupation = workpalceAndOccupation;
	}
	
	public String getWorkpalceAndOccupation() {
		return this.workpalceAndOccupation;
	}
	
	public void setResidentialAddress(String residentialAddress) {
		this.residentialAddress = residentialAddress;
	}
	
	public String getResidentialAddress() {
		return this.residentialAddress;
	}
	
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	
	public String getIdNo() {
		return this.idNo;
	}
	
	public void setFirstJoinPartyTime(String firstJoinPartyTime) {
		this.firstJoinPartyTime = firstJoinPartyTime;
	}
	
	public String getFirstJoinPartyTime() {
		return this.firstJoinPartyTime;
	}
	
	public void setOpinionOfEnthusiast(String opinionOfEnthusiast) {
		this.opinionOfEnthusiast = opinionOfEnthusiast;
	}
	
	public String getOpinionOfEnthusiast() {
		return this.opinionOfEnthusiast;
	}
	
	public void setCultivator(String cultivator) {
		this.cultivator = cultivator;
	}
	
	public String getCultivator() {
		return this.cultivator;
	}
	
	public void setCultivatorDuties(String cultivatorDuties) {
		this.cultivatorDuties = cultivatorDuties;
	}
	
	public String getCultivatorDuties() {
		return this.cultivatorDuties;
	}
	
	public void setOpinionOfCultivator(String opinionOfCultivator) {
		this.opinionOfCultivator = opinionOfCultivator;
	}
	
	public String getOpinionOfCultivator() {
		return this.opinionOfCultivator;
	}
	
	public void setOpinionOfBranch(String opinionOfBranch) {
		this.opinionOfBranch = opinionOfBranch;
	}
	
	public String getOpinionOfBranch() {
		return this.opinionOfBranch;
	}
	
	public void setApplicationFileUrl(String applicationFileUrl) {
		this.applicationFileUrl = applicationFileUrl;
	}
	
	public String getApplicationFileUrl() {
		return this.applicationFileUrl;
	}

	@Override
	public String toString() {
		return "JoinPartyApply{" +
				"id=" + id +
				", userAuthenticId=" + userAuthenticId +
				", name='" + name + '\'' +
				", birthday=" + birthday +
				", gender=" + gender +
				", nation='" + nation + '\'' +
				", partTime=" + partTime +
				", education='" + education + '\'' +
				", degreeOrTitle='" + degreeOrTitle + '\'' +
				", joinWorkDate=" + joinWorkDate +
				", placeOfOrigin='" + placeOfOrigin + '\'' +
				", birthPlace='" + birthPlace + '\'' +
				", workpalceAndOccupation='" + workpalceAndOccupation + '\'' +
				", residentialAddress='" + residentialAddress + '\'' +
				", idNo='" + idNo + '\'' +
				", firstJoinPartyTime='" + firstJoinPartyTime + '\'' +
				", opinionOfEnthusiast='" + opinionOfEnthusiast + '\'' +
				", cultivator='" + cultivator + '\'' +
				", cultivatorDuties='" + cultivatorDuties + '\'' +
				", opinionOfCultivator='" + opinionOfCultivator + '\'' +
				", opinionOfBranch='" + opinionOfBranch + '\'' +
				", applicationFileUrl='" + applicationFileUrl + '\'' +
				'}';
	}
}


