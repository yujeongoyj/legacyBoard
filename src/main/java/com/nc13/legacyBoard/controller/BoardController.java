package com.nc13.legacyBoard.controller;


import com.nc13.legacyBoard.model.BoardDTO;
import com.nc13.legacyBoard.model.UserDTO;
import com.nc13.legacyBoard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService BOARD_SERVICE;


    @GetMapping("showAll")
    public String showAll(Model model, Authentication authentication) {
        UserDTO logIn = (UserDTO) authentication.getPrincipal();
        List<BoardDTO> list = BOARD_SERVICE.selectAll();
        model.addAttribute("logIn", logIn);
        model.addAttribute("list", list);

        return "board/showAll";
    }

}
