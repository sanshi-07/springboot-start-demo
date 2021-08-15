package com.example.springbootstartjar;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Service {

    private String host;

    private int port;

    public Service(Properties properties){
        this.host = properties.getHost();
        this.port = properties.getPort();
    }

    public void print(){
        log.info(this.host + ":" +this.port);
    }
}