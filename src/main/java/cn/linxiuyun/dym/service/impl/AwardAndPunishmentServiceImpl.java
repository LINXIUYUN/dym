package cn.linxiuyun.dym.service.impl;

import cn.linxiuyun.dym.base.BaseMapper;
import cn.linxiuyun.dym.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.linxiuyun.dym.mapper.AwardAndPunishmentMapper;
import cn.linxiuyun.dym.model.AwardAndPunishment;
import cn.linxiuyun.dym.service.AwardAndPunishmentService;

@Service("awardAndPunishmentService")
public class AwardAndPunishmentServiceImpl extends BaseServiceImpl<AwardAndPunishment> implements AwardAndPunishmentService {

	@Autowired private AwardAndPunishmentMapper mapper;
	
	@Override
	public BaseMapper<AwardAndPunishment> getMapper() {
		return this.mapper;
	}

}
