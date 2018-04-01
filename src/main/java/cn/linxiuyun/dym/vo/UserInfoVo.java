package cn.linxiuyun.dym.vo;

import cn.linxiuyun.dym.model.UserInfo;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserInfoVo {

    /**姓名*/
    private String name;
    /**出生时间*/
    private String birthday;
    /**入团时间*/
    private String joinCylTime;
    /**性别*/
    private Integer gender;
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
    private Integer majorAndClass;
    /**是否是党员，0:是,1:否*/
    private String isPartyMember;
    /**入党时间*/
    private String partyTime;
    /**入党党支部所属省份*/
    private String partyProvince;
    /**入党党支部所属市*/
    private String partyCity;
    /**入党党支部所属县/区*/
    private String partyDistrict;
    /**备注*/
    private String remarks;

    private UserInfo userInfo;

    private SimpleDateFormat sdf;

    public UserInfoVo(UserInfo userInfo,String dataFormat) {
        this.userInfo = userInfo;
        this.sdf = new SimpleDateFormat(dataFormat);
    }

    public String getName() {
        return userInfo.getName();
    }

    public String getBirthday() {
        Date date = userInfo.getBirthday();
        if(date!=null)
            return this.sdf.format(userInfo.getBirthday());
        else
            return "";
    }

    public String getJoinCylTime() {
        Date date = userInfo.getJoinCylTime();
        if(date!=null)
            return this.sdf.format(userInfo.getBirthday());
        else
            return "";
    }

    public String getNation() {
        return this.userInfo.getNation();
    }

    public String getProvince() {
        if(StringUtils.isNotBlank(this.userInfo.getProvince()))
            return this.userInfo.getProvince();
        else
            return null;
    }

    public String getCity() {
        if(StringUtils.isNotBlank(this.userInfo.getCity()))
            return this.userInfo.getCity();
        else
            return null;
    }

    public String getDistrict() {
        if(StringUtils.isNotBlank(this.userInfo.getDistrict()))
            return this.userInfo.getDistrict();
        else
            return null;
    }

    public Integer getMaritalStatus() {
        return this.userInfo.getMaritalStatus();
    }

    public String getIdNo() {
        return this.userInfo.getIdNo();
    }

    public Integer getEducation() {
        return  this.userInfo.getEducation();
    }

    public String getMajorAndClass() {
        return  this.userInfo.getMajorAndClass();
    }

    public Integer getIsPartyMember() {
        return this.userInfo.getIsPartyMember();
    }

    public String getPartyTime() {
        Date date = userInfo.getPartyTime();
        if(date!=null)
            return this.sdf.format(userInfo.getPartyTime());
        else
            return "";
    }

    public String getPartyProvince() {
        if(StringUtils.isNotBlank(this.userInfo.getPartyProvince()))
            return this.userInfo.getPartyProvince();
        else
            return null;
    }

    public String getPartyCity() {
        if(StringUtils.isNotBlank(this.userInfo.getPartyCity()))
            return this.userInfo.getPartyCity();
        else
            return null;
    }

    public String getPartyDistrict() {
        if(StringUtils.isNotBlank(this.userInfo.getPartyDistrict()))
            return this.userInfo.getPartyDistrict();
        else
            return null;
    }

    public Integer getGender() {
        return userInfo.getGender();
    }

    public String getRemarks() {
        return this.userInfo.getRemarks();
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
