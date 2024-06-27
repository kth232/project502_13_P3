package org.choongang.admin.advices;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.global.Interceptor;
import org.choongang.global.config.annotations.ControllerAdvice;
import org.choongang.global.config.annotations.ModelAttribute;
import org.choongang.global.exceptions.UnAuthorizedException;
import org.choongang.member.MemberUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequiredArgsConstructor
@ControllerAdvice("org.choongang.admin")
public class AdminControllerAdvice implements Interceptor {

    private final MemberUtil memberUtil;
    private final HttpServletRequest request;
    
    @Override
    public boolean preHandle() {
        if (!memberUtil.isAdmin()){
            //throw new UnAuthorizedException();
        }
        return true;
        //반환값이 true면 통과(화면 보임), 관리자일 때 통과하지 않도록 설정
        //관리자이면 예외 던저서 401 응답 코드 출력
    }

    /**
     * 서브 메뉴 전체
     * @return
     */
    @ModelAttribute
    public Map<String, List<String[]>> subMenusAll() {
        Map<String, List<String[]>> menus = new HashMap<>();
        //서브 메뉴가 생기면 여기에 추가하기

        //게시판 관리 서브 메뉴 S
        //board가 메뉴 코드
        List<String[]> boardMenus = new ArrayList<>();
        boardMenus.add(new String[] {"게시판 목록", "/admin/board"});
        boardMenus.add(new String[] {"게시판 등록", "/admin/board/register"});
        boardMenus.add(new String[] {"게시판 관리", "/admin/board/posts"});
        menus.put("board", boardMenus);
        //게시판 관리 서브 메뉴 E
        return menus;
    }

    /**
     * 주 메뉴 코드- /admin/주메뉴 코드
     * 정규 표현식으로 뽑아옴
     * @return
     */
    @ModelAttribute
    public String menuCode() {
        String uri = request.getRequestURI().replace(request.getContextPath(), "");
        Pattern pattern = Pattern.compile("^/admin/([^/]+)/?"); // 슬래시 기호가 있거나 없거나
        Matcher matcher = pattern.matcher(uri);
        String code = matcher.find() ? matcher.group(1) : "";
        return code;
    }

    @ModelAttribute
    public List<String[]> subMenus() {
        Map<String, List<String[]>> menus = subMenusAll();

        String code = menuCode();
        return menus.get(code);
    }
}
