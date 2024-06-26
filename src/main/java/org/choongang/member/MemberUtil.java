package org.choongang.member;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Component;
import org.choongang.member.constants.UserType;
import org.choongang.member.entities.Member;

@Component
@RequiredArgsConstructor
public class MemberUtil {
    private final HttpSession session;

    //로그인 여부
    public boolean isLogin(){
        return getMember() != null;
    }

    //관리자 login 여부, 유저 타입이 어드민이면 관리자
    public boolean isAdmin() {
        if (isLogin()) {
            Member member = getMember();

            return member.getUserType() == UserType.ADMIN;
        }

        return false;
    }

    /*
     * 로그인한 회원 정보
     *
     * @return
     */
    public Member getMember(){
        Member member = (Member)session.getAttribute("member");

        return member;
    }
}