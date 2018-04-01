package cn.linxiuyun.dym.controller;

import cn.linxiuyun.dym.model.*;
import cn.linxiuyun.dym.service.*;
import cn.linxiuyun.dym.util.LoginUtil;
import cn.linxiuyun.dym.vo.CompletionDegreeVo;
import cn.linxiuyun.dym.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.soap.SOAPBinding;

@Controller
@RequestMapping("/view")
public class ViewController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private OrganizationalRelationshipService organizationalRelationshipService;

    @Autowired
    private UserAuthenticService userAuthenticService;

    @Autowired
    private ApplyRecordService applyRecordService;

    @Autowired
    private ApplyAwardAndPunishService applyAwardAndPunishService;

    @Autowired
    private ApplyTransferService applyTransferService;



    @GetMapping("/index.do")
    public String index(){
        return "/index";
    }

    @GetMapping("/sign.do")
    public String login(){
        return "/sign";
    }

    @GetMapping("/personal_info.do")
    public String personalInfo(Model model){
        UserInfo userInfo = userInfoService.getCurrentUserInfo();
        if(userInfo==null)
            userInfo = new UserInfo();

        model.addAttribute("userInfo",new UserInfoVo(userInfo,"yyyy-MM-dd"));
        return "/information";
    }

    @GetMapping("/award_punishment.do")
    public String awardAndPunishment(){
        return "/dans";
    }

    @GetMapping("/apply.do")
    public String applyParty(Model model){
        UserInfo userInfo = userInfoService.getCurrentUserInfo();
        if(userInfo==null)
            userInfo = new UserInfo();

        model.addAttribute("userInfo",new UserInfoVo(userInfo,"yyyy-MM-dd"));
        return "/apply";
    }

    @GetMapping("/learn.do")
    public String learn(){
        return "/learn";
    }

    @GetMapping("/related.do")
    public String related(Model model){

        UserInfo userInfo = userInfoService.getCurrentUserInfo();
        OrganizationalRelationship organizationalRelationship = organizationalRelationshipService.getCurrentRelation();
        if(userInfo == null)
            userInfo = new UserInfo();

        if(organizationalRelationship == null)
            organizationalRelationship = new OrganizationalRelationship();

        model.addAttribute("userInfo",new UserInfoVo(userInfo,"yyyy-MM-dd"));
        model.addAttribute("relation",organizationalRelationship);

        return "/related";
    }

    @GetMapping("/ad/index.do")
    public String adIndex(Model model){

        CompletionDegreeVo degreeVo = new CompletionDegreeVo();
        UserAuthentic userAuthentic = new UserAuthentic();
        userAuthentic.setUserType(0);

        ApplyTransfer transfer = new ApplyTransfer();
        transfer.setIsApply(0);

        ApplyRecord applyRecord = new ApplyRecord();
        applyRecord.setIsExamine(0);

        ApplyAwardAndPunish applyAwardAndPunish = new ApplyAwardAndPunish();
        applyAwardAndPunish.setIsApply(0);

        long tmp_1 = 0;
        long tmp_2 = 0;

        tmp_1 = userInfoService.count(null);
        tmp_2 = userAuthenticService.count(userAuthentic);
        System.out.println(tmp_2);
        if(tmp_2>0){
            degreeVo.setPersonalInfoDegree((int)(tmp_1/tmp_2)*100);
        }else {
            degreeVo.setPersonalInfoDegree(100);
        }

        tmp_1 = applyTransferService.count(transfer);
        tmp_2 = applyTransferService.count(null);
        if(tmp_2>0){
            degreeVo.setRelatedDegree((int)(tmp_1/tmp_2)*100);
        }else {
            degreeVo.setRelatedDegree(100);
        }

        tmp_1 = applyAwardAndPunishService.count(applyAwardAndPunish);
        tmp_2 = applyAwardAndPunishService.count(null);

        if(tmp_2>0){
            degreeVo.setAwardAndPunishDegree((int)(tmp_1/tmp_2)*100);
        }else {
            degreeVo.setAwardAndPunishDegree(100);
        }

        tmp_1 = applyRecordService.count(applyRecord);
        tmp_2 = applyRecordService.count(null);
        if(tmp_2>0){
            degreeVo.setJoinApplyDegree((int)(tmp_1/tmp_2)*100);
        }else {
            degreeVo.setJoinApplyDegree(100);
        }

        model.addAttribute("degree",degreeVo);
        model.addAttribute("username",LoginUtil.getLoginUsername());
        return "/ad";
    }

    @GetMapping("/ad/info.do")
    public String adInfoHtml(Model model){

        long total = userInfoService.count(null);
        model.addAttribute("totalPage",total);
        return "adinfo";
    }
}
