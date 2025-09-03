package hello.core.xml;

import hello.core.member.MemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClassPathXmlAppContext {

    @Test
    void xmlAppContext(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("appConfig.xml");
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        Assertions.assertInstanceOf(MemberService.class, memberService);
    }
}
