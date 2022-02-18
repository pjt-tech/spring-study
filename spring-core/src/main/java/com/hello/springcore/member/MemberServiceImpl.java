package com.hello.springcore.member;

public class MemberServiceImpl implements MemberService{

    //추상화에만 의존한다. 구현체는 생성자로부터 주입받는다.
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findById(Long id) {
        return memberRepository.findById(id);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
