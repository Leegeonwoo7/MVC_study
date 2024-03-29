package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void findById(){
        Member member = new Member("hong", 20);
        Member saveMember = memberRepository.save(member);
        Member resultMember = memberRepository.findById(saveMember.getId());

        assertThat(saveMember).isEqualTo(resultMember);
    }

    @Test
    void findAll(){
        Member member1 = new Member("hong", 20);
        Member member2 = new Member("lee", 30);

        memberRepository.save(member1);
        memberRepository.save(member2);
        List<Member> list = memberRepository.findAll();

        assertThat(list.size()).isEqualTo(2);
        assertThat(list).contains(member1, member2);
    }
}
