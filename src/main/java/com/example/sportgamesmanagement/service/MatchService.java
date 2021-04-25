package com.example.sportgamesmanagement.service;

import com.example.sportgamesmanagement.dto.MatchDTO;
import com.example.sportgamesmanagement.model.Match;

import java.util.List;

public interface MatchService { // extends CRUDService<Match>{

    MatchDTO getById(String matchId);

    List<MatchDTO> getAll();

    void delete(String matchId);

    Match create(MatchDTO matchDTO);

    Match update(MatchDTO matchDTO);

}
