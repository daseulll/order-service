package hello.core.order;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder() {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "member1", Grade.VIP));

        // 스프링 없이 순수 자바 코드로만 테스트하는 경우, 생성자에 직접 주입해주어야 함.
        // 생성자 주입 방식을 사용하면 순수 자바 코드로 테스트가 가능
        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "orderA", 10000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}