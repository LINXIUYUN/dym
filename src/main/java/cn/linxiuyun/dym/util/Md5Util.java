package cn.linxiuyun.dym.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;

public class Md5Util {

    private static final Logger logger = LoggerFactory.getLogger(Md5Util.class);

    public static String getMd5(String inputString){
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(inputString.getBytes("UTF-8"));
            return toHex(bytes);
        }catch (Exception e){
            logger.error("<|>Md5Util<|>getMd5<|>get md5 failure<|>",e);
        }

        return null;
    }

    public static boolean verify(String input,String md5){
        return StringUtils.equals(getMd5(input),md5);
    }

    private static String toHex(byte[] bytes) {
        final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        StringBuilder ret = new StringBuilder(bytes.length * 2);
        for (byte aByte : bytes) {
            ret.append(HEX_DIGITS[(aByte >> 4) & 0x0f]);
            ret.append(HEX_DIGITS[aByte & 0x0f]);
        }
        return ret.toString();
    }
}
