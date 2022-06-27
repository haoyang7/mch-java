package com.chaohong.Utils;

import org.springframework.web.cors.CorsConfiguration;

import java.util.List;


public class CorsUtils {
    /**
     * 配置跨域地址
     */
//    private static Map<String, String> serverAddressMap;
    private static List<String> serverAddressList;

    //    public static void setServerAddressMap(Map<String, String> serverAddressMap) {
//        CorsUtils.serverAddressMap = serverAddressMap;
//    }
//
    public static void setAllowedOrigin(CorsConfiguration config) {
        if (serverAddressList != null && serverAddressList.size() > 0) {
            config.setAllowedOrigins(serverAddressList);
        } else {
            config.addAllowedOrigin(CorsConfiguration.ALL);
        }
    }

    public static List<String> getServerAddressList() {
        return serverAddressList;
    }

    public static void setServerAddressList(List<String> serverAddressList) {
        CorsUtils.serverAddressList = serverAddressList;
    }
}
