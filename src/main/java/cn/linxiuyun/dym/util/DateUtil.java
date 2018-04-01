package cn.linxiuyun.dym.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);

    public Date parseDate(String dateFormat,String dateString){
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date date = null;
        try{
            date = sdf.parse(dateString);
        }catch (Exception e){
            logger.error("parse date exception",e);
        }finally {
            logger.info("<|>parseDate<|>dateFormat:"+dateFormat+"<|>dateString:"+dateString+"<|>result:"+date+"<|>");
        }

        return date;
    }
}
