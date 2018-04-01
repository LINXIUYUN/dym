package cn.linxiuyun.dym.service.impl;

import cn.linxiuyun.dym.base.BaseMapper;
import cn.linxiuyun.dym.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.linxiuyun.dym.mapper.ApplyRecordHisMapper;
import cn.linxiuyun.dym.model.ApplyRecordHis;
import cn.linxiuyun.dym.service.ApplyRecordHisService;

@Service("applyRecordHisService")
public class ApplyRecordHisServiceImpl extends BaseServiceImpl<ApplyRecordHis> implements ApplyRecordHisService {

	@Autowired private ApplyRecordHisMapper mapper;
	
	@Override
	public BaseMapper<ApplyRecordHis> getMapper() {
		return this.mapper;
	}

}
