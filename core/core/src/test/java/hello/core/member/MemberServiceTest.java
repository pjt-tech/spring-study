package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class MemberServiceTest {

    ApplicationContext applicationContext;
    MemberService service;

    @BeforeEach
    public void beforeEach() {
        applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        service = applicationContext.getBean("memberService",MemberService.class);
    }

    @Test
    public void join() throws Exception {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        service.join(member);
        Member findMember = service.findMember(1L);
        //then
        assertThat(findMember).isEqualTo(member);
    }
}
