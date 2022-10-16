package org.zerock.spring1.service;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.spring1.dto.PageRequestDTO;
import org.zerock.spring1.dto.PageResponseDTO;
import org.zerock.spring1.dto.TodoAddDTO;
import org.zerock.spring1.dto.TodoDTO;
import org.zerock.spring1.mapper.TodoMapper;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
@ToString

public class TodoServiceImpl implements TodoService{

    private final TodoMapper mapper;

    @Override
    public PageResponseDTO<TodoDTO> getList(PageRequestDTO requestDTO) {

        List<TodoDTO> dtoList = mapper.selectAll(requestDTO);
        int total = mapper.listCount(requestDTO);

        return new PageResponseDTO(requestDTO, total, dtoList);
    }

    @Override
    public TodoDTO read(int tno) {
        return mapper.selectOne(tno);
    }

    @Override
    public Integer register(TodoDTO todoDTO) {
        mapper.insert(todoDTO);
        return todoDTO.getTno();
    }

    @Override
    public boolean remove(int tno) {
        return mapper.delete(tno) == 1;
    }

    @Override
    public boolean modify(TodoDTO todoDTO) {
        return mapper.update(todoDTO) == 1;
    }
}
