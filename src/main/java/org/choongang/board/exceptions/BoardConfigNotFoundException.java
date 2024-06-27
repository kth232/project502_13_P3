package org.choongang.board.exceptions;

import jakarta.servlet.http.HttpServletResponse;
import org.choongang.global.exceptions.AlertException;

public class BoardConfigNotFoundException extends AlertException {
    public BoardConfigNotFoundException() {
        super("등록된 게시판이 아닙니다.", HttpServletResponse.SC_BAD_REQUEST);
    }
}
