package com.example.sportgamesmanagement.service;

import com.example.sportgamesmanagement.dto.MatchOddsDTO;
import com.example.sportgamesmanagement.model.MatchOdds;

import java.util.List;

public interface MatchOddsService {

    MatchOddsDTO getById(String oddId);

    List<MatchOddsDTO> getAll();

    void delete(String oddId);

    MatchOdds create(MatchOddsDTO matchOddsDTO);

    MatchOdds update(MatchOddsDTO matchOddsDTO);

}
