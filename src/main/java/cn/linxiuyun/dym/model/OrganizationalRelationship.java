package cn.linxiuyun.dym.model;

import java.io.Serializable;


public class OrganizationalRelationship implements Serializable {
	
	private static final long serialVersionUID = 1L;

	//columns START
	/**id*/
	private Integer id;
	/**用户账户鉴权信息表关联ID*/
	private Integer userAuthenticId;
	/**联系电话*/
	private String mobile;
	/**家庭住址*/
	private String address;
	/**户籍地址*/
	private String permanentAddress;
	/**全日制教育学历或学位*/
	private String fulltimeEducation;
	/**全日制教育院校及专业*/
	private String fulltimeUniversity;
	/**在职教育学历或学位*/
	private String onjobEducation;
	/**在职教育院校及专业*/
	private String onjobUniversity;
	/**党内职务*/
	private String innerPartySuites;
	/**入党时所在党支部*/
	private String joinBranch;
	/**参加工作时间*/
	private String joinWorkDate;
	/**现工作单位及职务*/
	private String workPalceAndSuites;
	/**入党资料是否齐全 */
	private String materialStatus;
	/**入党资料情况备注*/
	private String materialRemark;
	/**是否有入党志愿书 */
	private String haveVoluntaryBook;
	/**入党志愿书情况备注*/
	private String voluntaryBookRemark;
	/**入党信息是否真实准确 */
	private String infoRealStaus;
	/**入党信息是否真实准确 */
	private String infoRealRemark;
	/**是否存在违规入党或假党员情况*/
	private String haveIllegalRecord;
	/**违规记录备注*/
	private String illegalRecordRemark;
	/**是否是流动党员 */
	private String isFlowMember;
	/**流出时间*/
	private String flowDate;
	/**是否属于失联党员*/
	private String isOutContact;
	/**失联时间*/
	private String outContactDate;
	/**组织关系转出所在省*/
	private String turnOutProvince;
	/**组织关系转出所在市*/
	private String turnOutCity;
	/**组织关系转出所在区/县*/
	private String turnOutDistrict;
	/**备注*/
	private String remarks;
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
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getMobile() {
		return this.mobile;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	
	public String getPermanentAddress() {
		return this.permanentAddress;
	}
	
	public void setFulltimeEducation(String fulltimeEducation) {
		this.fulltimeEducation = fulltimeEducation;
	}
	
	public String getFulltimeEducation() {
		return this.fulltimeEducation;
	}
	
	public void setFulltimeUniversity(String fulltimeUniversity) {
		this.fulltimeUniversity = fulltimeUniversity;
	}
	
	public String getFulltimeUniversity() {
		return this.fulltimeUniversity;
	}
	
	public void setOnjobEducation(String onjobEducation) {
		this.onjobEducation = onjobEducation;
	}
	
	public String getOnjobEducation() {
		return this.onjobEducation;
	}
	
	public void setOnjobUniversity(String onjobUniversity) {
		this.onjobUniversity = onjobUniversity;
	}
	
	public String getOnjobUniversity() {
		return this.onjobUniversity;
	}
	
	public void setInnerPartySuites(String innerPartySuites) {
		this.innerPartySuites = innerPartySuites;
	}
	
	public String getInnerPartySuites() {
		return this.innerPartySuites;
	}
	
	public void setJoinBranch(String joinBranch) {
		this.joinBranch = joinBranch;
	}
	
	public String getJoinBranch() {
		return this.joinBranch;
	}
	
	public void setJoinWorkDate(String joinWorkDate) {
		this.joinWorkDate = joinWorkDate;
	}
	
	public String getJoinWorkDate() {
		return this.joinWorkDate;
	}
	
	public void setWorkPalceAndSuites(String workPalceAndSuites) {
		this.workPalceAndSuites = workPalceAndSuites;
	}
	
	public String getWorkPalceAndSuites() {
		return this.workPalceAndSuites;
	}
	
	public void setMaterialStatus(String materialStatus) {
		this.materialStatus = materialStatus;
	}
	
	public String getMaterialStatus() {
		return this.materialStatus;
	}
	
	public void setMaterialRemark(String materialRemark) {
		this.materialRemark = materialRemark;
	}
	
	public String getMaterialRemark() {
		return this.materialRemark;
	}
	
	public void setHaveVoluntaryBook(String haveVoluntaryBook) {
		this.haveVoluntaryBook = haveVoluntaryBook;
	}
	
	public String getHaveVoluntaryBook() {
		return this.haveVoluntaryBook;
	}
	
	public void setVoluntaryBookRemark(String voluntaryBookRemark) {
		this.voluntaryBookRemark = voluntaryBookRemark;
	}
	
	public String getVoluntaryBookRemark() {
		return this.voluntaryBookRemark;
	}
	
	public void setInfoRealStaus(String infoRealStaus) {
		this.infoRealStaus = infoRealStaus;
	}
	
	public String getInfoRealStaus() {
		return this.infoRealStaus;
	}
	
	public void setInfoRealRemark(String infoRealRemark) {
		this.infoRealRemark = infoRealRemark;
	}
	
	public String getInfoRealRemark() {
		return this.infoRealRemark;
	}
	
	public void setHaveIllegalRecord(String haveIllegalRecord) {
		this.haveIllegalRecord = haveIllegalRecord;
	}
	
	public String getHaveIllegalRecord() {
		return this.haveIllegalRecord;
	}
	
	public void setIllegalRecordRemark(String illegalRecordRemark) {
		this.illegalRecordRemark = illegalRecordRemark;
	}
	
	public String getIllegalRecordRemark() {
		return this.illegalRecordRemark;
	}
	
	public void setIsFlowMember(String isFlowMember) {
		this.isFlowMember = isFlowMember;
	}
	
	public String getIsFlowMember() {
		return this.isFlowMember;
	}
	
	public void setFlowDate(String flowDate) {
		this.flowDate = flowDate;
	}
	
	public String getFlowDate() {
		return this.flowDate;
	}
	
	public void setIsOutContact(String isOutContact) {
		this.isOutContact = isOutContact;
	}
	
	public String getIsOutContact() {
		return this.isOutContact;
	}
	
	public void setOutContactDate(String outContactDate) {
		this.outContactDate = outContactDate;
	}
	
	public String getOutContactDate() {
		return this.outContactDate;
	}
	
	public void setTurnOutProvince(String turnOutProvince) {
		this.turnOutProvince = turnOutProvince;
	}
	
	public String getTurnOutProvince() {
		return this.turnOutProvince;
	}
	
	public void setTurnOutCity(String turnOutCity) {
		this.turnOutCity = turnOutCity;
	}
	
	public String getTurnOutCity() {
		return this.turnOutCity;
	}
	
	public void setTurnOutDistrict(String turnOutDistrict) {
		this.turnOutDistrict = turnOutDistrict;
	}
	
	public String getTurnOutDistrict() {
		return this.turnOutDistrict;
	}
	
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public String getRemarks() {
		return this.remarks;
	}
}


