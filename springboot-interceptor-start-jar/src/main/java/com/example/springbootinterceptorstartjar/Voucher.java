package com.example.springbootinterceptorstartjar;

import lombok.Data;

@Data
public class Voucher {

    // 对应qt账号
    String username;
    // 资源路径
    String resource;
    // 项目名  可以通过读第三方配置文件得到
    String appCode;
}
