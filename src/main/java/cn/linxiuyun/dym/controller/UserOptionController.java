package cn.linxiuyun.dym.controller;

import cn.linxiuyun.dym.base.BaseResponse;
import cn.linxiuyun.dym.conf.ReturnCode;
import cn.linxiuyun.dym.model.*;
import cn.linxiuyun.dym.properties.FileUploadProperties;
import cn.linxiuyun.dym.service.ApplyAwardAndPunishService;
import cn.linxiuyun.dym.service.JoinPartyApplyService;
import cn.linxiuyun.dym.service.OrganizationalRelationshipService;
import cn.linxiuyun.dym.service.UserInfoService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserOptionController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private ApplyAwardAndPunishService applyAwardAndPunishService;

    @Autowired
    private JoinPartyApplyService joinPartyApplyService;

    @Autowired
    private FileUploadProperties fileUploadProperties;

    @Autowired
    private OrganizationalRelationshipService organizationalRelationshipService;


    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
    }

    @PostMapping("/userInfo/save")
    public BaseResponse saveOrUpdateUserInfo(UserInfo userInfo){
        BaseResponse response;
        boolean checkFlag;

        if(StringUtils.isBlank(userInfo.getName())){
            checkFlag = true;
        }else if(userInfo.getBirthday()==null){
            checkFlag = true;
        }else if(StringUtils.isBlank(userInfo.getNation())){
            checkFlag = true;
        }else if(StringUtils.isBlank(userInfo.getProvince())){
            checkFlag = true;
        }else if(StringUtils.isBlank(userInfo.getCity())){
            checkFlag = true;
        }else if(StringUtils.isBlank(userInfo.getDistrict())){
            checkFlag = true;
        }else if(userInfo.getMaritalStatus()==null){
            checkFlag = true;
        }else if(StringUtils.isBlank(userInfo.getIdNo())){
            checkFlag = true;
        }else if(StringUtils.isBlank(userInfo.getMajorAndClass())){
            checkFlag = true;
        }else if(userInfo.getIsPartyMember()==null){
            checkFlag = true;
        }else if(userInfo.getEducation()==null){
            checkFlag = true;
        }else {
            checkFlag = false;
        }

        if(userInfo.getIdNo().trim().length()!=18){
            checkFlag = true;
        }

        if(checkFlag){
            response = new BaseResponse(ReturnCode.PARAM_FAILURE);
        }else {
            response = userInfoService.saveOrUpdate(userInfo);
        }

        return response;
    }

    @PostMapping("/apply/awardAndPunish")
    public BaseResponse recordAwardAndPunish(AwardAndPunishment awardAndPunishment, MultipartFile file){
        return applyAwardAndPunishService.applyAwardAndPunish(awardAndPunishment,file);
    }

    @PostMapping("/apply/joinParty")
    public BaseResponse applyPartyMember(JoinPartyApply joinPartyApply){
        return joinPartyApplyService.applyJoin(joinPartyApply);
    }

    @PostMapping("/apply/relate")
    public BaseResponse applyRelate(OrganizationalRelationship organizationalRelationship){
        return organizationalRelationshipService.applyRelation(organizationalRelationship);
    }

    @GetMapping("userInfo/pagelist/{page}")
    public BaseResponse pageListUserInfo(@PathVariable("page") int page){
        List<UserInfo> list = userInfoService.getScrollData(null,"id",(page-1)*8,8);
        BaseResponse baseResponse = new BaseResponse(ReturnCode.OK);
        baseResponse.setResponseBody(list);
        return baseResponse;
    }
}
