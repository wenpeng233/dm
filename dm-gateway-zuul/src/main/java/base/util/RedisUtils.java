package base.util;

import org.apache.commons.lang.StringUtils;

public class RedisUtils {

    public static boolean exist(String token){
        if (StringUtils.equals(token, "abcdefg"))
        {
            return true;
        }
        return false;
    }
}
