package cn.linxiuyun.dym.service;

import cn.linxiuyun.dym.base.BaseResponse;
import cn.linxiuyun.dym.base.BaseService;
import cn.linxiuyun.dym.model.JoinPartyApply;

public interface JoinPartyApplyService extends BaseService<JoinPartyApply> {

    BaseResponse applyJoin(JoinPartyApply joinPartyApply);

}
