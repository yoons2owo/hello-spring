package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    // 생성자에 @Autowired가 있으면 스프링이 연관된 객체를 컨테이너에 찾아서 넣어준다.
    // MemberController가 생성될 때 스프링 빈에 등록되어 있는 MemberService 객체를 넣어준다.
    // 이렇게 객체 의존관계를 외부에서 넣어주는 것을 DI(의존성 주입)라고 한다.
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

}
