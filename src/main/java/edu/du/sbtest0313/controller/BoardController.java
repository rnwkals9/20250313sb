package edu.du.sbtest0313.controller;

import edu.du.sbtest0313.dto.BoardDTO;
import edu.du.sbtest0313.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    // 게시글 목록
    @GetMapping("/list")
    public String list(Model model) {
        List<BoardDTO> boardList = boardService.getAllBoards();

        model.addAttribute("boardList", boardList);
        return "list"; // list.jsp로 이동
    }


    // 게시글 작성 폼
    @GetMapping("/write")
    public String writeForm() {
        return "write";
    }

    // 게시글 저장
    @PostMapping("/save")
    public String save(@ModelAttribute BoardDTO boardDTO) {
        boardService.createBoard(boardDTO);
        return "redirect:/board/list";
    }

    // 게시글 상세보기
    @GetMapping("/view")
    public String view(@RequestParam("id") Long id, Model model) {
        BoardDTO board = boardService.getBoardById(id);
        model.addAttribute("board", board);
        return "view";
    }

    // 게시글 수정 폼
    @GetMapping("/edit")
    public String edit(@RequestParam("id") Long id, Model model) {
        BoardDTO board = boardService.getBoardById(id);
        model.addAttribute("board", board);
        return "edit";
    }

    // 게시글 수정
    @PostMapping("/update")
    public String update(@ModelAttribute BoardDTO boardDTO) {
        boardService.updateBoard(boardDTO.getId(), boardDTO);
        return "redirect:/board/list";
    }

    // 게시글 삭제
    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        boardService.deleteBoard(id);
        return "redirect:/board/list";
    }
}
