package com.calcfab.apollo;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;

/**
 * @author XuBowen
 * @date 2023/2/12 14:36
 */
public class GetApolloConfig {
    public static void main(String[] args) {
        Config appConfig = ConfigService.getAppConfig();
        System.out.println(appConfig.getProperty("bookname", null));
    }
}
