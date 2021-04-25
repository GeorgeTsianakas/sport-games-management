package com.example.sportgamesmanagement.service;

import com.example.sportgamesmanagement.dto.MatchDTO;
import com.example.sportgamesmanagement.mapper.MatchMapper;
import com.example.sportgamesmanagement.model.Match;
import com.example.sportgamesmanagement.repository.MatchRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class MatchServiceImpl implements MatchService {

    private final MatchRepository matchRepository;
    private final MatchMapper matchMapper;

    @Override
    public MatchDTO getById(String matchId) {
        return matchMapper.toDto(matchRepository.getOne(matchId));
    }

    @Override
    public List<MatchDTO> getAll() {
        //return matchMapper.toDto(matchRepository.findAll());
        return matchRepository.findAll()
                .stream()
                .map(matchMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(String matchId) {
        matchRepository.deleteById(matchId);
    }

    @Override
    public Match create(MatchDTO matchDTO) {
        return matchRepository.save(matchMapper.toEntity(matchDTO));
    }

    @Override
    public Match update(MatchDTO matchDTO) {
        return matchRepository.save(matchMapper.toEntity(matchDTO));
    }

}
