package org.choongang.admin.advices;

import lombok.RequiredArgsConstructor;
import org.choongang.global.Interceptor;
import org.choongang.global.config.annotations.ControllerAdvice;
import org.choongang.global.exceptions.UnAuthorizedException;
import org.choongang.member.MemberUtil;

@RequiredArgsConstructor
@ControllerAdvice("org.choongang.admin")
public class AdminControllerAdvice implements Interceptor {

    private final MemberUtil memberUtil;

    @Override
    public boolean preHandle() {
        if (!memberUtil.isAdmin()){
            throw new UnAuthorizedException();
        }
        return true;
        //반환값이 true면 통과(화면 보임), 관리자일 때 통과하지 않도록 설정
        //관리자이면 예외 던저서 401 응답 코드 출력
    }
}
