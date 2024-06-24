package org.choongang.member.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.*;
import org.choongang.member.services.JoinService;

@Controller
@RequestMapping("/member") //여러 개 매핑 가능
@RequiredArgsConstructor
public class MemberController {
    private final JoinService joinService;

    @GetMapping
    public String index(HttpServletRequest request) {
        String attr = (String) request.getAttribute("commonValue");
        // System.out.println(attr);
        /*
        boolean bool = true;
        if (bool) {
            throw new RuntimeException("테스트1212121212"); //예외 throw
        }
         */
        return "member/index"; //경로 + 해당 파일 찾아서 반환
    }

    @GetMapping("/{mode}/test/{num}") //요청 데이터 매핑: 쿼리 스트링, 양식 데이터에 입력한 값(name) 등
    public String join(@PathVariable("mode") String mode, @RequestParam("seq") int seq, RequestJoin form,  HttpServletResponse response, @PathVariable("num") int num) {
        System.out.printf("mode=%s, seq=%d, num=%d%n", mode, seq, num);
        System.out.println(form);
        joinService.process();
        return "member/join";
    }

    /*
    @ExceptionHandler({RuntimeException.class}) //특정 예외는 특정 에러페이지 출력 ->사용자 친화적 오류 화면
    public String errorHandler(RuntimeException e1, HttpServletRequest request, HttpServletResponse response, HttpSession session) { //필요하면 매개변수 추가하기
        System.out.println(e1);
        System.out.println(e2);
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);

        return "errors/error";
        //해당 컨트롤러에서 처리할 예외만 여기서 처리
    } */
}