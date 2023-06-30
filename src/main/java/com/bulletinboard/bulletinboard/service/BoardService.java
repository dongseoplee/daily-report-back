package com.bulletinboard.bulletinboard.service;

import com.bulletinboard.bulletinboard.domain.Board;
import com.bulletinboard.bulletinboard.dto.BoardDTO;
import com.bulletinboard.bulletinboard.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class BoardService {
    private final BoardRepository boardRepository; //선언 후 생성자 만들어야 함

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public List<Board> getBoards() {
        return boardRepository.findAll();
    }

    public List<Board> getBoardsById(Long boardId) {
        return boardRepository.findAllById(boardId);
    }

    public Page<Board> getBoardsPagination(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }
//    public List<Board> getBoardsPagination(int page, int pageSize) {
//        return boardRepository.findBoardByPagination(page, pageSize);
//    }

//    public List<Board> getBoardsByName() {
//        return boardRepository.findAllByName();
//    }
    public Board saveBoard(BoardDTO boardDTO) {
        Board board = convertToEntity(boardDTO);
//        System.out.println("boardRepository saveBoard" + board);
        return boardRepository.save(board);
    }

    public void deleteBoard(Long boardId) {
        boardRepository.deleteById(boardId);
    }

    public Board convertToEntity(BoardDTO boardDTO) {
        Board board = new Board();
//        board.setName(boardDTO.getName());
//        board.setEmail(boardDTO.getEmail());
//        board.setMessage(boardDTO.getMessage());
        board.setUsername(boardDTO.getUsername());
        board.setTitle(boardDTO.getTitle());
        board.setContent(boardDTO.getContent());
        board.setImg_url(boardDTO.getImg_url());
        board.setYyyymmdd(boardDTO.getYyyymmdd());
        board.setImage(boardDTO.getImage());
        board.setEmail(boardDTO.getEmail());
//        board.setDate_(boardDTO.getDate_());

        return board;
    }

}

//서비스 클래스 생성: 비즈니스 로직을 처리하는 서비스 클래스를 생성합니다.
// 이 클래스에서는 데이터베이스에 저장할 데이터를 받아서 Repository를 통해 저장 작업을 수행합니다.