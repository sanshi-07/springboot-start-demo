package com.example.springbootstartjar;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("com.example")
public class Properties {

    private String host;

    private int port;
}