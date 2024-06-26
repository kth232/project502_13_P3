package org.choongang.global.advices;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.ControllerAdvice;
import org.choongang.global.config.annotations.ModelAttribute;
import org.choongang.global.exceptions.*;
import org.choongang.member.MemberUtil;
import org.choongang.member.entities.Member;

@RequiredArgsConstructor
@ControllerAdvice("org.choongang") //중앙 하위 패키지가 접근 범위(모든 페이지에서 공통으로 적용할 내용 정의)
public class CommonControllerAdvice {
    private final MemberUtil memberUtil;
    
    @ModelAttribute
    public boolean isLogin() { //메서드명이 속성명이 되어 동작, 모든 컨트롤러 범위 해당
        return memberUtil.isLogin(); //속성값 유지
    }
    
    @ModelAttribute //공통 속성 값
    public  boolean isAdmin() {
        return memberUtil.isAdmin();
    }
    
    public Member loggedMember() { //값을 전역에 유지함
        return memberUtil.getMember();
    }

    /*
    @ModelAttribute("commonValue2") //모든 컨트롤러 범위 해당
    public String commonValue() { //name 값이 없을 경우 메서드명이 속성값이 됨
        return "공통 값 속성 추가 테스트";
    }
     */

    /**
     * 공통 에러 페이지 처리
     *
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(Exception.class) //공통 예외 처리 부분
    public String errorHandler(Exception e, HttpServletRequest request, HttpServletResponse response) {
        e.printStackTrace();

        if (e instanceof CommonException commonException) {
            int status = commonException.getStatus();
            response.setStatus(status);

            StringBuffer sb = new StringBuffer(1000);
            if (e instanceof AlertException) {
                sb.append(String.format("alert('%s');", e.getMessage()));
            }
            if (e instanceof AlertBackException alertBackException) {
                String target = alertBackException.getTarget();
                sb.append(String.format("%s.history.back();", target));
            }
            if (e instanceof AlertRedirectException alertRedirectException) {
                String target = alertRedirectException.getTarget(); //타겟과 url 바꿈
                String url = alertRedirectException.getRedirectUrl();

                sb.append(String.format("%s.location.replace('%s');", target, url));
            }

            if (!sb.isEmpty()){
                request.setAttribute("script", sb.toString()); //스크립트 내에서 실행
                return "commons/execute_script";
            }
        } else {
            //commonException으로 정의한 예외가 아닌 경우-응답코드 500
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
        return "errors/error";
    }
}