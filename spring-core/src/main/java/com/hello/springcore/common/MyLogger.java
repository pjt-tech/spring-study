package com.hello.springcore.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS) //가짜 Proxy객체를 주입해주기때문에 ObjectProvider를 사용하지 않아도 된다.
public class MyLogger {

    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message) {
        System.out.println("[" +uuid +"]" + "["+ requestURL +"] " + message);
    }

    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID().toString();
        System.out.println("[" +uuid +"] request scope bean create: " + this);
    }

    @PreDestroy
    public void close() {
        System.out.println("[" +uuid +"] request scope bean close: " + this);
    }
}
