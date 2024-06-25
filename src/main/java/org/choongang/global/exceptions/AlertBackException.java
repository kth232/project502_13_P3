package org.choongang.global.exceptions;

public class AlertBackException extends AlertException{
    //메세지 띄우고 페이지 뒤로 이동
    private String target;
    
    public AlertBackException(String message, int status, String target) {
        super(message, status);
        this.target = target;
    }
    
    public AlertBackException(String message, int status) {
        this(message, status, "self"); //self인 경우 현재 창에서 페이지 이동
    }
    
    public String getTarget() {
        return target;
    } //현재 창에서 뒤로 가는 것이 편의상 좋음
}
