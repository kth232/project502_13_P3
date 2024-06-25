package org.choongang.global.exceptions;

import jakarta.servlet.http.HttpServletResponse;

public class CommonException extends RuntimeException { //기준 예외
    private int status;

    public CommonException(String message) {
        this(message, HttpServletResponse.SC_INTERNAL_SERVER_ERROR); // status가 없는 경우 500 응답 코드
    }

    public CommonException(String message, int status) {
        super(message);
        this.status = status;
    }
    public int getStatus() {
        return status;
    }
}
