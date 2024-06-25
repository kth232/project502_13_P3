package org.choongang.member.entities;

import lombok.Builder;
import lombok.Data;
import org.choongang.member.constants.UserType;

import java.time.LocalDateTime;

@Data
@Builder
public class Member { //DB에서 불러오는 데이터들
    private long userNo;
    private String email;
    private String password;
    private String userName;
    private UserType userType = UserType.USER; //관리자, 일반회원 구분
    private LocalDateTime regDt;
    private LocalDateTime modDt;
}
