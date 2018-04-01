package cn.linxiuyun.dym.service.impl;

import cn.linxiuyun.dym.base.BaseMapper;
import cn.linxiuyun.dym.base.BaseResponse;
import cn.linxiuyun.dym.base.BaseServiceImpl;
import cn.linxiuyun.dym.conf.ReturnCode;
import cn.linxiuyun.dym.model.AwardAndPunishment;
import cn.linxiuyun.dym.model.UserInfo;
import cn.linxiuyun.dym.properties.FileUploadProperties;
import cn.linxiuyun.dym.service.AwardAndPunishmentService;
import cn.linxiuyun.dym.service.UserInfoService;
import cn.linxiuyun.dym.util.LoginUtil;
import cn.linxiuyun.dym.util.Md5Util;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.linxiuyun.dym.mapper.ApplyAwardAndPunishMapper;
import cn.linxiuyun.dym.model.ApplyAwardAndPunish;
import cn.linxiuyun.dym.service.ApplyAwardAndPunishService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import sun.rmi.runtime.Log;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;

@Service("applyAwardAndPunishService")
public class ApplyAwardAndPunishServiceImpl extends BaseServiceImpl<ApplyAwardAndPunish> implements ApplyAwardAndPunishService {

	private final Logger logger = LoggerFactory.getLogger(ApplyAwardAndPunishServiceImpl.class);

	@Autowired
	private ApplyAwardAndPunishMapper mapper;

	@Autowired
	private AwardAndPunishmentService awardAndPunishmentService;

	@Autowired
	private ApplyAwardAndPunishService applyAwardAndPunishService;

	@Autowired
	private UserInfoService userInfoService;

	@Autowired
	private FileUploadProperties fileUploadProperties;

	@Override
	@Transactional
	public BaseResponse applyAwardAndPunish(AwardAndPunishment awardAndPunishment,MultipartFile file) {
		BaseResponse baseResponse;
		int currentUserId = LoginUtil.getLoginUserId();
		UserInfo queryParam = new UserInfo();
		queryParam.setUserAuthenticId(currentUserId);

		UserInfo userInfo = userInfoService.getOne(queryParam);
		if(userInfo==null)
			userInfo = new UserInfo();

		awardAndPunishment.setUserAuthenticId(currentUserId);
		//保存文件
		String savePath = null;
		try{
			savePath = saveUploadFile(file);
		}catch (Exception e){
			logger.error(ExceptionUtils.getStackTrace(e));
		}

		if(savePath==null){
			baseResponse = new BaseResponse(ReturnCode.UPLOAD_FAIL);
			baseResponse.setDetailMsg("惩奖凭证上传失败");
		}else {
			try {
				awardAndPunishment.setVoucherFileUrl(savePath);
				int id = awardAndPunishmentService.save(awardAndPunishment);
				ApplyAwardAndPunish applyAwardAndPunish = new ApplyAwardAndPunish();
				applyAwardAndPunish.setUserAuthenticId(LoginUtil.getLoginUserId());
				applyAwardAndPunish.setCalssInfo(userInfo.getMajorAndClass());
				applyAwardAndPunish.setApplyTableId(id);
				applyAwardAndPunish.setApplyDate(new Date());
				applyAwardAndPunish.setIsApply(1);
				applyAwardAndPunishService.save(applyAwardAndPunish);
				baseResponse = new BaseResponse(ReturnCode.OK);
				baseResponse.setDetailMsg("保存成功");
			}catch (Exception e){
				logger.error("save exception",e);
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				baseResponse = new BaseResponse(ReturnCode.EXCEPTION);
				baseResponse.setDetailMsg("系统故障,请与管理员联系");
			}
		}
		return baseResponse;
	}

	/**
	 * 保存上传文件
	 */
	private String saveUploadFile(MultipartFile file) throws IOException{
		if(file.isEmpty()){
			return "";
		}else {
			String savePath;
			String filePath;
			boolean dirExists = false;
			if(fileUploadProperties.getPath().contains(":")){
				savePath = fileUploadProperties.getPath()+"\\"+LoginUtil.getLoginUsername()+"\\"+Md5Util.getMd5(UUID.randomUUID().toString()+System.currentTimeMillis())+"\\";
				filePath = savePath+file.getOriginalFilename();
			}else {
				savePath = fileUploadProperties.getPath()+"/"+LoginUtil.getLoginUsername()+"/"+Md5Util.getMd5(UUID.randomUUID().toString()+System.currentTimeMillis())+"/";
				filePath = savePath+file.getOriginalFilename();
			}
			File dir = new File(savePath);
			if(!dir.exists()){
				dir.mkdir();
				if(dir.exists()){
					dirExists = true;
					logger.info("<|>上传惩奖资料<|>创建存目录成功<|>存储目录:"+savePath+"<|>");
				}else {
					logger.info("<|>上传惩奖资料<|>创建存目录失败<|>");

				}
			}
			if(dirExists){
				InputStream is = null;
				try{
					is = file.getInputStream();
					File saveFile = new File(filePath);
					FileUtils.copyInputStreamToFile(is,saveFile);
					return filePath;
				}catch (IOException e){
					logger.error("read upload file failure.",e);
					throw new IOException("save file failure");
				}finally {
					if(is != null){
						try{
							is.close();
						}catch (IOException e){
							logger.error("close io stream failure.",e);
						}
					}
				}
			}else {
				return null;
			}
		}
	}
	@Override
	public BaseMapper<ApplyAwardAndPunish> getMapper() {
		return this.mapper;
	}

}
