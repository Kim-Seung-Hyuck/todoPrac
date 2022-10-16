package org.zerock.spring1.mapper;

import com.sun.tools.javac.comp.Todo;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.spring1.dto.TodoDTO;

import java.time.LocalDate;
import java.util.List;
//import org.zerock.spring1.dto.PageRequestDTO;
//import org.zerock.spring1.dto.PageResponseDTO;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {org.zerock.spring1.config.RootConfig.class})
@Log4j2
public class MapperTest {

    @Autowired(required = false)
    TodoMapper mapper;

//    @Test
//    public void SelectAllTest(){
//
//        mapper.selectAll().forEach(TodoDTO -> log.info(TodoDTO));
//
//    }

    @Test
    public void SelectOneTest(){

        log.info(mapper.selectOne(1));

    }

    @Test
    public void insertTest(){

        TodoDTO todoDTO = TodoDTO.builder().title("hi").memo("hi").writer("hi").dueDate(LocalDate.now()).build();

        log.info(mapper.insert(todoDTO));

    }

    @Test
    public void updateTest(){
        TodoDTO todoDTO = TodoDTO.builder().title("DDong").memo("DDong").writer("DDong").dueDate(LocalDate.now()).complete(true).tno(504).build();

        log.info(mapper.update(todoDTO));
    }

    @Test
    public void deleteTest(){
        log.info(mapper.delete(504));
    }



}

