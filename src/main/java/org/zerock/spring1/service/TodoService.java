package org.zerock.spring1.service;

import org.springframework.stereotype.Service;
import org.zerock.spring1.dto.PageRequestDTO;
import org.zerock.spring1.dto.PageResponseDTO;
import org.zerock.spring1.dto.TodoAddDTO;
import org.zerock.spring1.dto.TodoDTO;

import java.util.List;

public interface TodoService {

    PageResponseDTO<TodoDTO> getList(PageRequestDTO requestDTO);

    TodoDTO read(int tno);

    Integer register(TodoDTO todoDTO);

    boolean remove(int tno);

    boolean modify(TodoDTO todoDTO);




}
