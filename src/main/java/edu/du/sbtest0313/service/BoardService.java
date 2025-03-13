package edu.du.sbtest0313.service;

import edu.du.sbtest0313.dao.BoardDAO;
import edu.du.sbtest0313.dto.BoardDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private final BoardDAO boardDAO;

    // 생성자를 통한 DAO 주입 (Spring이 자동으로 주입)
    public BoardService(BoardDAO boardDAO) {
        this.boardDAO = boardDAO;
    }

    // 게시글 추가
    public int createBoard(BoardDTO board) {
        return boardDAO.insertBoard(board);
    }

    // 모든 게시글 조회
    public List<BoardDTO> getAllBoards() {
        return boardDAO.getAllBoards();
    }

    // 특정 게시글 조회
    public BoardDTO getBoardById(Long id) {
        return boardDAO.getBoardById(id);
    }

    // 게시글 수정
    public int updateBoard(Long id, BoardDTO board) {
        board.setId(id); // ID 설정
        return boardDAO.updateBoard(board);
    }

    // 게시글 삭제
    public int deleteBoard(Long id) {
        return boardDAO.deleteBoard(id);
    }
}
