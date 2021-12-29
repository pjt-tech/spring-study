package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

public class MemberServiceTest {

    MemberService service = new MemberServiceImpl();

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
