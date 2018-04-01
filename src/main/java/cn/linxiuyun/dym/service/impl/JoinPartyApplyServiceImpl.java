package cn.linxiuyun.dym.service.impl;

import cn.linxiuyun.dym.base.BaseMapper;
import cn.linxiuyun.dym.base.BaseResponse;
import cn.linxiuyun.dym.base.BaseServiceImpl;
import cn.linxiuyun.dym.conf.ReturnCode;
import cn.linxiuyun.dym.model.ApplyRecord;
import cn.linxiuyun.dym.service.ApplyRecordService;
import cn.linxiuyun.dym.util.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.linxiuyun.dym.mapper.JoinPartyApplyMapper;
import cn.linxiuyun.dym.model.JoinPartyApply;
import cn.linxiuyun.dym.service.JoinPartyApplyService;

import java.util.Date;

@Service("joinPartyApplyService")
public class JoinPartyApplyServiceImpl extends BaseServiceImpl<JoinPartyApply> implements JoinPartyApplyService {

	@Autowired
	private JoinPartyApplyMapper mapper;

	@Autowired
	private ApplyRecordService applyRecordService;

	@Override
	public BaseResponse applyJoin(JoinPartyApply joinPartyApply) {
		BaseResponse baseResponse;
		joinPartyApply.setUserAuthenticId(LoginUtil.getLoginUserId());
		try{
			int applyInfoId = save(joinPartyApply);
			if(applyInfoId>0){
				ApplyRecord applyRecord = new ApplyRecord();
				applyRecord.setApplyDate(new Date());
				applyRecord.setIsExamine(1);
				applyRecord.setJoinPartyApplyId(applyInfoId);
				applyRecord.setUserAuthenticId(LoginUtil.getLoginUserId());
				applyRecordService.save(applyRecord);
				baseResponse = new BaseResponse(ReturnCode.OK);
				baseResponse.setDetailMsg("保存成功");
			}else {
				baseResponse = new BaseResponse(ReturnCode.FAIL);
				baseResponse.setDetailMsg("数据保存失败");
			}
		}catch (Exception e){
			baseResponse = new BaseResponse(ReturnCode.EXCEPTION);
			baseResponse.setDetailMsg("系统故障,请与管理员联系");
		}

		return baseResponse;
	}

	@Override
	public BaseMapper<JoinPartyApply> getMapper() {
		return this.mapper;
	}

}
