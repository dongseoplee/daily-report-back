package com.bulletinboard.bulletinboard.repository;

import com.bulletinboard.bulletinboard.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    public List<Board> findAllById(Long id);

    public void deleteById(Long id);

    @Query(value = "SELECT * FROM board_data ORDER BY id DESC LIMIT :limit OFFSET :offset", nativeQuery = true)
    public List<Board> findBoardByPagination(@Param("limit") int limit, @Param("offset") int offset);


}
