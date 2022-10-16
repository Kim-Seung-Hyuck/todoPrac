package org.zerock.spring1.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.spring1.dto.PageRequestDTO;
import org.zerock.spring1.dto.PageResponseDTO;
import org.zerock.spring1.dto.TodoAddDTO;
import org.zerock.spring1.dto.TodoDTO;
import org.zerock.spring1.service.TodoService;

import java.util.List;

@Controller
@RequestMapping("/todo")
@Log4j2
@RequiredArgsConstructor
public class TodoController {

    private final TodoService service;

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model){

        PageResponseDTO<TodoDTO> list = service.getList(pageRequestDTO);

        model.addAttribute("result", list);
    }

    @GetMapping("/register")
    public void registerGet(){
        //그대로 냅둬도 됨. jsp랑 이름 같으면 지절로 감.
    }

    @PostMapping("/register")
    public String registerPost(TodoDTO todoDTO){

        log.info("-----------------register Post--------------------------------");

        service.register(todoDTO);

        log.info(todoDTO);

        return "redirect:/todo/list";
    }

    @GetMapping("/read")
    public void readGet(int tno, @ModelAttribute("reqDTO") PageRequestDTO pageRequestDTO, Model model){

        TodoDTO todoDTO = service.read(tno);

        model.addAttribute("dto", todoDTO);

    }

    @GetMapping("/modify")
    public void modifyGet(int tno, Model model, @ModelAttribute("reqDTO") PageRequestDTO pageRequestDTO){

        TodoDTO todoDTO = service.read(tno);

        model.addAttribute("dto", todoDTO);

    }

    @PostMapping("/modify")
    public String  modifyPost(TodoDTO todoDTO, RedirectAttributes rttr){

        boolean mo = service.modify(todoDTO);

        rttr.addFlashAttribute("mo", mo);
        return "redirect:/todo/list";
    }

    @PostMapping("/remove")
    public String removePost(int tno, RedirectAttributes rttr){

        boolean re = service.remove(tno);

        rttr.addFlashAttribute("re", re);

        return "redirect:/todo/list";
    }


}
