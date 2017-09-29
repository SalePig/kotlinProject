package com.kotlin.kotlinframework.http;

/**
 * 创建日期：2017/5/16 0016 on 16:23
 * 作者:penny
 */
public interface API {

    /**************开发环境******************************/

    //发短信
//    String SMS = "http://192.168.1.50:6061";
////    String SMS = "http://sms.yysp.local";
//    //注册
//    String XHS = "http://192.168.1.50:6060";
////    String XHS = "http://account.yysp.local";
//    //西红柿
//    String ACCOUNT2 = "http://192.168.1.169:8080";
//    //西红柿
//    String XHS_1 = "http://192.168.1.169:8080/dis-shop-api";
//    //佛手
//    String FS = "http://192.168.1.54:6062";
//    String FS_1 = "http://192.168.1.54:6064";
//    //支付
//    String PAY = "http://pay.yysp.me/dis-pay-api";
//    String BASE_URL = ACCOUNT2;

//    /**************测试环境******************************/
    //     蛇果 发短信
//    String SMS = "http://192.168.1.132:6061";
//    //    蛇果 注册
//    String XHS = "http://192.168.1.132:6060";
//    //西红柿
//    String ACCOUNT2 = "http://192.168.1.131:8080";
//    //西红柿
//    String XHS_1 = "http://192.168.1.131:8080/dis-shop-api";
//    //佛手
//    String FS = "http://192.168.1.133:6062";
//    String FS_1 = "http://192.168.1.133:6064";
//    //支付
//    String PAY = "http://paytest.yysp.me";
//    String BASE_URL = ACCOUNT2;

    /*************************预发环境prep**************************/
////    // 蛇果 发短信
    String SMS = "http://118.31.51.197:6061";
    //蛇果 注册
    String XHS = "http://118.31.51.197:6060";
    //西红柿
    String ACCOUNT2 = "http://118.31.51.197:8002";
    //西红柿
    String XHS_1 = "http://118.31.51.197:8002";
//    String XHS_1 = "http://118.31.51.197:8002/dis-shop-api";
    //佛手
    String FS = "http://118.31.51.197:7002";
    String FS_1 = "http://118.31.51.197:7003";
    //支付
    String PAY = "http://payprep.yysp.me";
    String BASE_URL = ACCOUNT2;
}
