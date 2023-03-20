package com.kdh.board.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kdh.board.entity.resulySet.SearchWordResultSet;

@Repository
public interface RelatedSearchWordRepository extends JpaRepository<RelatedSearchWordEntity, Integer>{
    
    @Query(value = "SELECT previous_search_word AS count(previous_search_word) AS count FROM RelatedsearchWord WHERE search_word = ?1 GROUP BY previous_search_word ORDER BY count DESC LIMIT 15", nativeQuery = true)
    public List<SearchWordResultSet> findTop15(String searchWord);
}
