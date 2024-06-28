package org.choongang.board.services.config;

import lombok.RequiredArgsConstructor;
import org.choongang.admin.board.controllers.RequestBoard;
import org.choongang.board.entities.Board;
import org.choongang.board.exceptions.BoardConfigNotFoundException;
import org.choongang.board.mappers.BoardMapper;
import org.choongang.global.config.annotations.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor //의존성 주입
public class BoardConfigInfoService {
    private final BoardMapper mapper;
    public Optional<Board> get(String bId) {
        Board board = mapper.get(bId);
        
        return Optional.ofNullable(board); //데이터가 없을 때는 optional 형태로 가져옴
    }

    //수정할 때 사용하는 양식! 회원 정보 수정할 때 참고할 것!
    public RequestBoard getForm(String bId) {
        Board board = get(bId).orElseThrow(BoardConfigNotFoundException::new);
        RequestBoard form = new RequestBoard();
        form.setMode("update");

        form.setBId(board.getBId());
        form.setBName(board.getBName());
        form.setRowsPerPage(board.getRowsPerPage());
        form.setActive(board.getActive() == 1); //1일 때 true
        form.setActiveCategory(board.getActiveCategory() == 1);
        form.setCategory(board.getCategory());
        form.setAuthority(board.getAuthority().name());

        return form;
    }
    
    //게시판 목록에서 나올 값들
    public List<Board> getList() {
        return mapper.getList();
    }
}
