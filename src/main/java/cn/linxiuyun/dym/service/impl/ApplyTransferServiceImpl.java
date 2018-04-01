package cn.linxiuyun.dym.service.impl;

import cn.linxiuyun.dym.base.BaseMapper;
import cn.linxiuyun.dym.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.linxiuyun.dym.mapper.ApplyTransferMapper;
import cn.linxiuyun.dym.model.ApplyTransfer;
import cn.linxiuyun.dym.service.ApplyTransferService;

@Service("applyTransferService")
public class ApplyTransferServiceImpl extends BaseServiceImpl<ApplyTransfer> implements ApplyTransferService {

	@Autowired private ApplyTransferMapper mapper;
	
	@Override
	public BaseMapper<ApplyTransfer> getMapper() {
		return this.mapper;
	}

}
