package org.choongang.board.mappers;

import org.apache.ibatis.session.SqlSession;
import org.choongang.board.constants.Authority;
import org.choongang.board.entities.Board;
import org.choongang.board.entities.BoardData;
import org.choongang.global.config.DBConn;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardDataMapperTest {
    private SqlSession session;
    private BoardDataMapper dataMapper;
    private BoardMapper mapper;

    @BeforeEach
    void init() {
        session = DBConn.getSession(false);

        mapper = session.getMapper(BoardMapper.class);
        dataMapper = session.getMapper(BoardDataMapper.class);
    }

    @Test
    void registerTest(){
        Board board = Board.builder()
                .bId("B" + System.currentTimeMillis())
                .bName("테스트 게시판")
                .rowsPerPage(20)
                .authority(Authority.ALL)
                .active(1)
                .activeCategory(0)
                .category("0")
                .build();
        mapper.register(board);

        BoardData data = BoardData.builder()
                .bId(board.getBId())
                .gId(board.getBId())
                .poster("작성자")
                .subject("제목")
                .content("내용")
                .guestPassword("")
                .category("")
                .ua("")
                .ip("")
                .build();

        int result = dataMapper.register(data);

        BoardData data2 = dataMapper.register(data);

        assertNotNull(data2);

        assertEquals(data.getSeq())




        System.out.println(result);
    }

    @AfterEach
    void destroy () {
        session.rollback();
    }

}
