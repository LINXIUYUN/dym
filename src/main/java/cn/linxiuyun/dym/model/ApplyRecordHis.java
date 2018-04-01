package cn.linxiuyun.dym.model;

import java.io.Serializable;


public class ApplyRecordHis implements Serializable {
	
	private static final long serialVersionUID = 1L;

	//columns START
	/**id*/
	private Integer id;
	/**用户账户鉴权信息表关联ID*/
	private Integer userAuthenticId;
	/**申请表ID*/
	private Integer joinPartyApplyId;
	/**申请时间*/
	private java.util.Date applyDate;
	/**审核时间*/
	private java.util.Date examineDate;
	/**审核人ID*/
	private Integer examineUserId;
	/**是否审核 0:是,1:否*/
	private Integer isExamine;
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
	
	public void setJoinPartyApplyId(Integer joinPartyApplyId) {
		this.joinPartyApplyId = joinPartyApplyId;
	}
	
	public Integer getJoinPartyApplyId() {
		return this.joinPartyApplyId;
	}
	
	public void setApplyDate(java.util.Date applyDate) {
		this.applyDate = applyDate;
	}
	
	public java.util.Date getApplyDate() {
		return this.applyDate;
	}
	
	public void setExamineDate(java.util.Date examineDate) {
		this.examineDate = examineDate;
	}
	
	public java.util.Date getExamineDate() {
		return this.examineDate;
	}
	
	public void setExamineUserId(Integer examineUserId) {
		this.examineUserId = examineUserId;
	}
	
	public Integer getExamineUserId() {
		return this.examineUserId;
	}
	
	public void setIsExamine(Integer isExamine) {
		this.isExamine = isExamine;
	}
	
	public Integer getIsExamine() {
		return this.isExamine;
	}

	@Override
	public String toString() {
		return "ApplyRecordHis{" +
				"id=" + id +
				", userAuthenticId=" + userAuthenticId +
				", joinPartyApplyId=" + joinPartyApplyId +
				", applyDate=" + applyDate +
				", examineDate=" + examineDate +
				", examineUserId=" + examineUserId +
				", isExamine=" + isExamine +
				'}';
	}
}


