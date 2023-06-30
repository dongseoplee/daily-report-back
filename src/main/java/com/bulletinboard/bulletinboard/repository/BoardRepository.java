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

//    public Page<Board> findAllByIdDesc(Pageable pageable);

//    @Query(value = "SELECT * FROM board_data WHERE id >= (:page * :pageSize)-(:pageSize-1) AND id <= (:page * :pageSize)", nativeQuery = true)
//    @Query(value = "SELECT * FROM board_data ORDER BY yyyymmdd DESC", nativeQuery = true)
//    @Query(value = "SELECT *, ROW_NUMBER() OVER(ORDER BY yyyymmdd desc) as rownum limit pageSize offset pageSize * (page-1)", nativeQuery = true)
//    public List<Board> findBoardByPagination(@Param("page") int page, @Param("pageSize") int pageSize);
}
