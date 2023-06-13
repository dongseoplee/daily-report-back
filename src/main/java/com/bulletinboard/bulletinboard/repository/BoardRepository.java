package com.bulletinboard.bulletinboard.repository;

import com.bulletinboard.bulletinboard.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    public List<Board> findAllById(Long id);

    @Query(value = "SELECT * FROM board_data WHERE id >= (:page * :pageSize)-(:pageSize-1) AND id <= (:page * :pageSize)", nativeQuery = true)
    public List<Board> findBoardByPagination(@Param("page") int page, @Param("pageSize") int pageSize);
}
