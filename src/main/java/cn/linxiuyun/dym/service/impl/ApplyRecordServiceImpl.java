package cn.linxiuyun.dym.service.impl;

import cn.linxiuyun.dym.base.BaseMapper;
import cn.linxiuyun.dym.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.linxiuyun.dym.mapper.ApplyRecordMapper;
import cn.linxiuyun.dym.model.ApplyRecord;
import cn.linxiuyun.dym.service.ApplyRecordService;

@Service("applyRecordService")
public class ApplyRecordServiceImpl extends BaseServiceImpl<ApplyRecord> implements ApplyRecordService {

	@Autowired private ApplyRecordMapper mapper;
	
	@Override
	public BaseMapper<ApplyRecord> getMapper() {
		return this.mapper;
	}

}
