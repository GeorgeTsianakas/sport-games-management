package com.example.sportgamesmanagement.repository;

import com.example.sportgamesmanagement.model.MatchOdds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchOddsRepository extends JpaRepository<MatchOdds, String> {
}
