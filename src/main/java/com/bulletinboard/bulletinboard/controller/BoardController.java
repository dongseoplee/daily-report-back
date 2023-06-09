package com.bulletinboard.bulletinboard.controller;

import com.bulletinboard.bulletinboard.domain.Board;
import com.bulletinboard.bulletinboard.dto.BoardDTO;
import com.bulletinboard.bulletinboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/board") //프론트에서 넘어온 데이터를 DTO 객체로 받는다.
    public String boardPost(BoardDTO boardDTO) {
        System.out.println(boardDTO);
        //DTO를 엔티티로 변환해서 저장
        boardService.saveBoard(boardDTO); //위에서 private final BoardService boardService; 선언되어 있음
        //BoardDTO를 Board(entity) 형태로 변환하여 DB에 저장헤야 한다.
//        BoardService.saveBoard(boardDTO);
//        Board board = BoardService.saveBoard(boardDTO);

        return "success";
    }

    @GetMapping("/board")
    public List<Board> boardGet() {
        //Board는 엔티티이며 Board의 자료형을 가지는 List를 반환값으로 설정한다.
        //서비스계층에서 레포지토리 선언하고 선언한 레포지토리를 이용해서 함수 생성하고 반환값 도출한다.
        return boardService.getBoards();
    }

    @GetMapping("/board/{id}")
    public List<Board> boardGetId(@PathVariable("id") Long boardId) {
        return boardService.getBoardsById(boardId);
    };
}
