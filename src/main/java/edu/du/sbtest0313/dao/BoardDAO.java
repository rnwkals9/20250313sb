package edu.du.sbtest0313.dao;


import edu.du.sbtest0313.dto.BoardDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BoardDAO {

    private final JdbcTemplate jdbcTemplate;

    // 생성자를 통해 JdbcTemplate 주입
    public BoardDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 게시글 추가
    public int insertBoard(BoardDTO board) {
        String sql = "INSERT INTO board (title, content, author, created_at, updated_at) VALUES (?, ?, ?, NOW(), NOW())";
        return jdbcTemplate.update(sql, board.getTitle(), board.getContent(), board.getAuthor());
    }

    // 게시글 목록 조회
    public List<BoardDTO> getAllBoards() {
        String sql = "SELECT * FROM board";
        return jdbcTemplate.query(sql, new BoardRowMapper());
    }

    // 특정 게시글 조회
    public BoardDTO getBoardById(Long id) {
        String sql = "SELECT * FROM board WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BoardRowMapper(), id);
    }

    // 게시글 수정
    public int updateBoard(BoardDTO board) {
        String sql = "UPDATE board SET title = ?, content = ?, author = ?, updated_at = NOW() WHERE id = ?";
        return jdbcTemplate.update(sql, board.getTitle(), board.getContent(), board.getAuthor(), board.getId());
    }

    // 게시글 삭제
    public int deleteBoard(Long id) {
        String sql = "DELETE FROM board WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    // RowMapper 내부 클래스 (쿼리 결과를 DTO로 변환)
    public class BoardRowMapper implements RowMapper<BoardDTO> {
        @Override
        public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
            BoardDTO board = new BoardDTO();
            board.setId(rs.getLong("id"));
            board.setTitle(rs.getString("title"));
            board.setContent(rs.getString("content"));
            board.setAuthor(rs.getString("author"));
            board.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
            board.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());

            System.out.println("DB에서 가져온 게시글: " + board); // 🛠 디버깅 로그 추가
            return board;
        }
    }



}

