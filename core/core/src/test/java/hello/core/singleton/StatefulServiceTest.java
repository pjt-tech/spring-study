package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        //싱글톤이기때문에 값을 공유한다. 여러사용자가 멤버변수의 값에 접근하면 값이 변경된다.
        //스프링은 항상 무상태로 설계하자.
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

        int userAPrice = statefulService1.order("userA", 10000);

        int userBPrice = statefulService2.order("userB", 20000);


        Assertions.assertThat(userAPrice).isNotEqualTo(userBPrice);
    }

    static class TestConfig {

        @Bean
        StatefulService statefulService() {
            return new StatefulService();
        }
    }

}
