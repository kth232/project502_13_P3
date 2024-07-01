package org.choongang.mypage.advices;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.choongang.global.Interceptor;
import org.choongang.global.config.annotations.ControllerAdvice;
import org.choongang.global.config.containers.BeanContainer;
import org.choongang.member.MemberUtil;

import java.io.IOException;

//공통 컨트롤 통제
@RequiredArgsConstructor
@ControllerAdvice("org.choongang.mypage")
public class MypageControllerAdvice implements Interceptor {

    private final MemberUtil memberUtil;

    @Override
    public boolean preHandle() {

        /*미로그인->로그인 페이지->로그인 완료->/mypage 자동 이동*/
        if (!memberUtil.isLogin()) {
            HttpServletResponse response = BeanContainer.getInstance().getBean(HttpServletResponse.class);
            HttpServletRequest request = BeanContainer.getInstance().getBean(HttpServletRequest.class);

            String url = request.getContextPath() + "/member/login?redirectUrl=/mypage";

            try{
                response.sendRedirect(url);
            } catch(IOException e){
                //e.printStackTrace();
            }
            return false;
        }

        return true; //컨트롤러 실행
        //false인 경우 컨트롤러 보이지 않음?
    }
}
