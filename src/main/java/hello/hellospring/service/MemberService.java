package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class MemberService {

    // final : 값을 생성자에서 초기화 한 이후에 변경할 수 없다.
    private final MemberRepository memberRepository;

    // 외부에서 주입 - DI
    // 기존에는 회원 서비스가 메모리 회원 레포를 직접 생성하게 했으나
    // -> 회원 레포 코드가 회원 서비스 코드를 di 가능하게 변경한다
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*
     * 회원 가입(join)
     * 서비스 네이밍은 비즈니스 의존적으로.(기계적x)
     */
    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();

    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
    
    /*
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
