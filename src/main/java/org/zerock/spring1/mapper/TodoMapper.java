package org.zerock.spring1.mapper;

import org.zerock.spring1.dto.PageRequestDTO;
import org.zerock.spring1.dto.PageResponseDTO;
import org.zerock.spring1.dto.TodoDTO;

import java.util.List;

public interface TodoMapper {

    List<TodoDTO> selectAll(PageRequestDTO pageRequestDTO);

    int listCount(PageRequestDTO pageRequestDTO);

    TodoDTO selectOne(int tno);

    int insert(TodoDTO todoDTO);

    int update(TodoDTO todoDTO);

    int delete(int tno);

}
