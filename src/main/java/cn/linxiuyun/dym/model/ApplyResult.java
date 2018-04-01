package cn.linxiuyun.dym.model;

import java.io.Serializable;


public class ApplyResult implements Serializable {
	
	private static final long serialVersionUID = 1L;

	//columns START
	/**id*/
	private Integer id;
	/**用户账户鉴权信息表关联ID*/
	private Integer userAuthenticId;
	/**申请时间*/
	private java.util.Date applyDate;
	/**审核时间*/
	private java.util.Date examineDate;
	/**是否通过审核 0:是,1:否*/
	private Integer isAgree;
	/**审核人ID*/
	private Integer examineUserId;
	/**备注*/
	private String remark;
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
	
	public void setIsAgree(Integer isAgree) {
		this.isAgree = isAgree;
	}
	
	public Integer getIsAgree() {
		return this.isAgree;
	}
	
	public void setExamineUserId(Integer examineUserId) {
		this.examineUserId = examineUserId;
	}
	
	public Integer getExamineUserId() {
		return this.examineUserId;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getRemark() {
		return this.remark;
	}

	@Override
	public String toString() {
		return "ApplyResult{" +
				"id=" + id +
				", userAuthenticId=" + userAuthenticId +
				", applyDate=" + applyDate +
				", examineDate=" + examineDate +
				", isAgree=" + isAgree +
				", examineUserId=" + examineUserId +
				", remark='" + remark + '\'' +
				'}';
	}
}


