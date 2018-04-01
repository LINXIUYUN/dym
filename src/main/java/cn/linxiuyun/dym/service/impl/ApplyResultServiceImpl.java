package cn.linxiuyun.dym.service.impl;

import cn.linxiuyun.dym.base.BaseMapper;
import cn.linxiuyun.dym.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.linxiuyun.dym.mapper.ApplyResultMapper;
import cn.linxiuyun.dym.model.ApplyResult;
import cn.linxiuyun.dym.service.ApplyResultService;

@Service("applyResultService")
public class ApplyResultServiceImpl extends BaseServiceImpl<ApplyResult> implements ApplyResultService {

	@Autowired private ApplyResultMapper mapper;
	
	@Override
	public BaseMapper<ApplyResult> getMapper() {
		return this.mapper;
	}

}
