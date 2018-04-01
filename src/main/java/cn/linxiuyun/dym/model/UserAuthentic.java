package cn.linxiuyun.dym.model;

import java.io.Serializable;


public class UserAuthentic implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public static final int NORMAL = 0;
	public static final int ADMINISTRATORS = 1;

	//columns START
	/**id*/
	private Integer id;
	/**用户名*/
	private String username;
	/**密码(MD5)*/
	private String password;
	/**用户类型 0:普通用户,1:管理员*/
	private Integer userType;
	//columns END
	
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	
	public Integer getUserType() {
		return this.userType;
	}

    @Override
    public String toString() {
        return "UserAuthentic{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userType=" + userType +
                '}';
    }
}


