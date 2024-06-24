package org.choongang.global.advices;

import jakarta.servlet.http.HttpServletRequest;
import org.choongang.global.config.annotations.ControllerAdvice;
import org.choongang.global.config.annotations.ModelAttribute;
import org.choongang.global.exceptions.ExceptionHandler;

@ControllerAdvice("org.choongang") //중앙 하위 패키지가 접근 범위(모든 페이지에서 공통으로 적용할 내용 정의)
public class CommonControllerAdvice {

    @ModelAttribute("commonValue2")
    public String commonValue() { //name 값이 없을 경우 메서드명이 속성값이 됨
        return "공통 값 속성 추가 테스트";
    }

    /**
     * 공통 에러 페이지 처리
     *
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(Exception.class) //공통 예외 처리 부분
    public String errorHandler(Exception e, HttpServletRequest request) {

        return "errors/error";
    }
}