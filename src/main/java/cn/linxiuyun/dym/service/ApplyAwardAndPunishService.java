package cn.linxiuyun.dym.service;

import cn.linxiuyun.dym.base.BaseResponse;
import cn.linxiuyun.dym.base.BaseService;
import cn.linxiuyun.dym.model.ApplyAwardAndPunish;
import cn.linxiuyun.dym.model.AwardAndPunishment;
import org.springframework.web.multipart.MultipartFile;

public interface ApplyAwardAndPunishService extends BaseService<ApplyAwardAndPunish> {
	
    BaseResponse applyAwardAndPunish(AwardAndPunishment awardAndPunishment,MultipartFile file);
}
