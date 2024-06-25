package org.choongang.member.mappers;

import org.choongang.member.entities.Member;

public interface MemberMapper {
    Member get(String email);
    int exist(String email);
    int register(Member member); //간단하게 사용하기 위해 정의
}
