package cn.linxiuyun.dym.model;

import java.io.Serializable;


public class AwardAndPunishment implements Serializable {
	
	private static final long serialVersionUID = 1L;

	//columns START
	/**id*/
	private Integer id;
	/**用户账户鉴权信息表关联ID*/
	private Integer userAuthenticId;
	/**惩奖信息标题*/
	private String title;
	/**惩奖信息详情*/
	private String description;
	/**凭证文件路径*/
	private String voucherFileUrl;
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
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setVoucherFileUrl(String voucherFileUrl) {
		this.voucherFileUrl = voucherFileUrl;
	}
	
	public String getVoucherFileUrl() {
		return this.voucherFileUrl;
	}

	@Override
	public String toString() {
		return "AwardAndPunishment{" +
				"id=" + id +
				", userAuthenticId=" + userAuthenticId +
				", title='" + title + '\'' +
				", description='" + description + '\'' +
				", voucherFileUrl='" + voucherFileUrl + '\'' +
				'}';
	}
}


