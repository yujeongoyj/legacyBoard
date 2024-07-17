package com.nc13.legacyBoard.service;

import com.nc13.legacyBoard.model.BoardDTO;
import lombok.AllArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BoardService {
    private final SqlSession SESSION;
    private final String NAMESPACE ="mappers.BoardMapper";

    public List<BoardDTO> selectAll() {
        return SESSION.selectList(NAMESPACE + ".selectAll");
    }
}
