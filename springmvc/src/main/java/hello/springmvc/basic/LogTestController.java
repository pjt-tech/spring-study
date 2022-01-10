package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j //롬복에서 지원하는 로그 애노테이션
@RestController
public class LogTestController {

    @GetMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        //레벨순 치환방식으로 해야함 연산으로 하면 안된다. properties 사용 할 로그 레벨 지정, 지정안할시 info가 default
        log.trace("trace log={}", name);
        log.debug("debug log={}", name);
        log.info("info log={}", name);
        log.warn("warn log={}", name);
        log.error("error log={}", name);
        return "ok";
    }
}
