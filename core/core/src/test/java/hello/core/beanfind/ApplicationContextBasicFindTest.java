package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    public void findBeanByName() throws Exception {
        //given
        //빈 이름으로 조회
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        //when
        System.out.println("memberService = " + memberService);
        System.out.println("memberService.getClass() = " + memberService.getClass());

        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    public void findBeanByType() throws Exception {
        //given
        //빈이름 없이 타입으로만 조회
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    //역할에 의존하는것이 좋기때문에 구체클래스에 의존하는건 별로 좋지 않다.
    @Test
    @DisplayName("구체 타입으로 조회")
    public void findBeanByName2() throws Exception {
        //given
        //구체 클래스 타입으로 빈 조회
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
        //when
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }

    @Test
    @DisplayName("빈 이름으로 조회 x")
    public void findBeanByNameX() throws Exception {

        //MemberService xxxx = ac.getBean("xxxx", MemberService.class);
        //조회한 이름의 빈이 없으면 해당예외가 반드시 터져야한다.
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxx", MemberService.class));
    }
}
