package com.example.sportgamesmanagement.repository;

import com.example.sportgamesmanagement.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<Match, String> {
}
