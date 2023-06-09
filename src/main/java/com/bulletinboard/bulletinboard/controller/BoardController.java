package com.bulletinboard.bulletinboard.controller;

import com.bulletinboard.bulletinboard.domain.Board;
import com.bulletinboard.bulletinboard.domain.Comment;
import com.bulletinboard.bulletinboard.dto.BoardDTO;
import com.bulletinboard.bulletinboard.dto.CommentDTO;
import com.bulletinboard.bulletinboard.dto.UserDTO;
import com.bulletinboard.bulletinboard.repository.BoardRepository;
import com.bulletinboard.bulletinboard.repository.CommentRepository;
import com.bulletinboard.bulletinboard.service.BoardService;
import com.bulletinboard.bulletinboard.service.CommentService;
import com.bulletinboard.bulletinboard.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;
    private final CommentService commentService;
    private final UserService userService;
    @PostMapping("/board") //프론트에서 넘어온 데이터를 DTO 객체로 받는다.
    public String boardPost(BoardDTO boardDTO) {
        System.out.println(boardDTO);
        //DTO를 엔티티로 변환해서 저장
        boardService.saveBoard(boardDTO); //위에서 private final BoardService boardService; 선언되어 있음
        //BoardDTO를 Board(entity) 형태로 변환하여 DB에 저장헤야 한다.
//        BoardService.saveBoard(boardDTO);
//        Board board = BoardService.saveBoard(boardDTO);
//test
        return "success";
    }

    @PutMapping("/edit-board/{board_id}")
    public String boardPut(@PathVariable("board_id") Long board_id, BoardDTO boardDTO) {
//        System.out.println(boardDTO);
//        System.out.println(board.getTitle());
//        System.out.println(board.getContent());
        Optional<Board> optionalBoard = boardRepository.findById(board_id);
        Board board = optionalBoard.get();
        board.setTitle(boardDTO.getTitle());
        board.setContent(boardDTO.getContent());
        board.setImage(boardDTO.getImage());
        boardRepository.save(board);

        return "success";
    }

    @PutMapping("/edit-comment/{comment_id}")
    public String commentPut(@PathVariable("comment_id") Long comment_id, CommentDTO commentDTO) {
        Optional<Comment> optionalComment = commentRepository.findById(comment_id);
        Comment comment = optionalComment.get(); //get()을 사용해야함
        comment.setContent(commentDTO.getContent());
        commentRepository.save(comment);

        return "success";
    }

    @DeleteMapping("/board/{board_id}")
    public String deleteBoard(@PathVariable("board_id") Long boardId) {
        boardService.deleteBoard(boardId);
        return "success";

    }

    @DeleteMapping("/comment/{id}")
    public String deleteComment(@PathVariable("id") Long commentId) {
        commentService.deleteComment(commentId);
        return "success";
    }

    @PostMapping("/board/comment")
    public String commentPost(CommentDTO commentDTO) {
        System.out.println(commentDTO);
        commentService.saveComment(commentDTO);

        return "success";

    }

    //프론트에서 Post 할때 FormData()로 넘겨라
    @PostMapping("/auth/signup")
    public String signUpPost(UserDTO userDTO) {
        System.out.println(userDTO);
        userService.saveUser(userDTO);

        return "success";
    }

    @PostMapping("login")
    public String loginPost(UserDTO userDTO) {
        String email = userDTO.getEmail();
        String password = userDTO.getPassword();
        System.out.println(email + password);
        //post method로 받은 이메일 아이디, 비밀번호를 데이터베이스 user테이블에 저장된 값과 비교
        boolean isValid = userService.validateUser(email, password);
        System.out.println("isValid: " + isValid);
        if (isValid) {
            //token generate
            System.out.println(userService.getToken(email));
            return userService.getToken(email);
//            return "success"; //token
        } else {
            return "Invalid email or password";
        }
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

    //페이지네이션 api 생성
//    @GetMapping("/board/pagination") //같은 GetMapping에 대한 메소드는 하나뿐 이어야한다.
//    public List<Board> boardGetPagination(@RequestParam int page, @RequestParam int pageSize) {
//        return boardService.getBoardsPagination(page, pageSize);
//    }

    @GetMapping("/board/pagination")
    public Page<Board> boardGetPagination(@PageableDefault(page = 0, size = 4, sort ="id", direction = Sort.Direction.DESC) Pageable pageable) {
        return boardService.getBoardsPagination(pageable);
    }
    @GetMapping("/board/comment/{id}") //board id로 댓글 검색
    public List<Comment> commentGetId(@PathVariable("id") Long board_id) {
        return commentService.getCommentsByBoardId(board_id);
    }

    @GetMapping("/board/comment")
    public List<Comment> commentGet() {
        //Board는 엔티티이며 Board의 자료형을 가지는 List를 반환값으로 설정한다.
        //서비스계층에서 레포지토리 선언하고 선언한 레포지토리를 이용해서 함수 생성하고 반환값 도출한다.
        return commentService.getComments();
    }


}
