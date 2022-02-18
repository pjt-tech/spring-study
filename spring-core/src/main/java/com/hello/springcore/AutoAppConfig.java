package com.hello.springcore;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
) //ComponentScan 은 현재 시작지점 부터 하위패키지를 모두 탐색하여 Component 를 빈으로 등록한다. Scan지점을 설정할수있지만 default(현위치) 로 사용하면 된다.
public class AutoAppConfig {
}
